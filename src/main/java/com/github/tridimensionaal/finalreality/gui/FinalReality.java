package com.github.tridimensionaal.finalreality.gui;

import com.github.tridimensionaal.finalreality.controller.GameController;
import com.github.tridimensionaal.finalreality.controller.phases.*;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.Random;

/**
 * Main entry point for the application.
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil.
 */

public class FinalReality extends Application {
  private final GameController controller = new GameController();
  private final int WIDTH = 640;
  private final int HEIGHT = 360;
  private final int centerX = WIDTH / 2;
  private final int centerY = HEIGHT / 2;
  private Scene actualScene;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Final reality");
    primaryStage.setResizable(false);
    actualScene = InitialScene();
    primaryStage.setScene(actualScene);
    primaryStage.show();

  }

  /**
   * Creates the initial scene of the game.
   */
  private Scene InitialScene() {
    Group root = new Group();
    Scene scene = new Scene(root, WIDTH, HEIGHT);
    Label label = createLabel(10, 30, controller.getPhase().getText());
    Button button = createButton(centerX - 100, centerY - 20, "Press to start the game");
    button.setOnAction(event -> this.creationScene());
    root.getChildren().add(button);
    root.getChildren().add(label);
    return scene;
  }

  /**
   * Creates the creation scene of the game.
   */
  private void creationScene() {
    try {
      controller.getPhase().toCreationPhase();
    } catch (InvalidTransitionException e) {
      e.printStackTrace();
    }

    Group root = new Group();
    Label label = createLabel(10, 30, controller.getPhase().getText());
    Button button = createButton(centerX - 100, centerY - 20, "Press to start the fight");
    button.setOnAction(event -> this.prepareToAttackScene());
    root.getChildren().add(label);
    root.getChildren().add(button);

    try {
      controller.getPhase().createElements();
    } catch (InvalidMovementException e) {
      e.printStackTrace();
    }
    actualScene.setRoot(root);
  }

  /**
   * Creates the prepare to attack scene of the game.
   */
  private void prepareToAttackScene() {
    Group root = new Group();
    Label initialPhaseLabel = createLabel(10, 30, controller.getPhase().getText());
    root.getChildren().add(initialPhaseLabel);
    actualScene.setRoot(root);

    try {
      controller.getPhase().prepareToAttack();
    } catch (InvalidMovementException e) {
      e.printStackTrace();
    }

    Task<Void> sleeper = new Task<>() {
      @Override
      protected Void call() {
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        return null;
      }
    };
    sleeper.setOnSucceeded(event -> getCharacterScene());
    new Thread(sleeper).start();
  }

  private void getCharacterScene() {
    try {
      controller.getPhase().getCharacter();
    } catch (InvalidMovementException e) {
      e.printStackTrace();
    }

    if (controller.getPhase().equals(new PrepareToAttackPhase())) {
      prepareToAttackScene();
      return;
    }
    Group root = new Group();
    createEnemiesInfo(root, false);
    createPlayerCharactersInfo(root);

    if (controller.getCurrentCharacter().isPlayerCharacter()) {
      Label label= createLabel(centerX - 200, centerY - 20, "It is " + controller.getCurrentCharacter().getName() + "'s turn\n" +
              "Choose attack or equip a new weapon and then attack");
      root.getChildren().add(label);

      Button button = createButton(centerX - 200, centerY+20, "Equip a new weapon");
      button.setOnAction(event -> this.equipWeaponScene());
      root.getChildren().add(button);

      Button button1 = createButton(centerX +50, centerY+20, "Attack");
      button1.setOnAction(event -> this.attackScene1(controller.getCurrentCharacter().getName()));
      root.getChildren().add(button1);

    } else {
      Label label = createLabel(centerX - 100, centerY - 20, "It is " + controller.getCurrentCharacter().getName() + "'s turn");
      root.getChildren().add(label);

      Button button = createButton(centerX - 100, centerY, "Press to continue");
      button.setOnAction(event -> this.attackScene1(controller.getCurrentCharacter().getName()));
      root.getChildren().add(button);
    }

    actualScene.setRoot(root);
  }

  private void equipWeaponScene() {
    Group root = new Group();
    createPlayerCharactersInfo(root);
    actualScene.setRoot(root);
  }


  private void attackScene1(String name) {
    if(controller.getCurrentCharacter().isPlayerCharacter()) {

      Group root = new Group();
      createEnemiesInfo(root, true);
      createPlayerCharactersInfo(root);
      Label label = createLabel(centerX - 100, centerY - 20, "Choose a enemy to attack \n"+ name + " is going to attack");
      root.getChildren().add(label);
      actualScene.setRoot(root);
    }
    else {
        Random rng = new Random();
        int large = controller.getPlayerCharacterSize();
        int i = rng.nextInt(large);
        attackScene2(i, controller.getPlayerCharacterElementName(i));
    }
  }

  private void attackScene2(int i, String name) {
    Group root = new Group();
    try {
      controller.getPhase().attack(i);
    } catch (InvalidMovementException e) {
      e.printStackTrace();
    }

    String text = controller.getCurrentCharacter().getName() + " has attacked " +  name;
    Label label = createLabel(10, 30, text);
    root.getChildren().add(label);
    actualScene.setRoot(root);

    Task<Void> sleeper = new Task<>() {
      @Override
      protected Void call() {
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        return null;
      }
    };

    sleeper.setOnSucceeded(event -> {
      if(controller.getPhase().equals(new FinalPhase())){
        finalScene();
      }
      else{
          getCharacterScene();
      }
    });
    new Thread(sleeper).start();
  }

  private void finalScene() {
    Group root = new Group();
    Label label = createLabel(10, 30, controller.getPhase().getText());
    root.getChildren().add(label);
    actualScene.setRoot(root);
  }

  private Label createLabel(int x, int y, String text) {
    Label label = new Label();
    label.setLayoutX(x);
    label.setLayoutY(y);
    label.setText(text);
    return label;
  }
  private Button createButton(int x, int y, String text) {
    Button button = new Button(text);
    button.setLayoutX(x);
    button.setLayoutY(y);
    return button;
  }
  private String createEnemyInfo(int i) {
    return  controller.getEnemyCharacterElementName(i) + '\n'
            + "Health: " + controller.getEnemyCharacterElementHealth(i) + '\n'
            + "Defense: " + controller.getEnemyCharacterElementDefense(i) + '\n'
            + "Damage: " + controller.getEnemyCharacterElementDamage(i) + '\n'
            + "Weight: " + controller.getEnemyCharacterElementWeight(i) + '\n';
  }
  private String createPlayerCharacterInfo(int i) {
    return controller.getPlayerCharacterElementName(i) + '\n'
            + "Health: " + controller.getPlayerCharacterElementHealth(i) + '\n'
            + "Defense: " + controller.getPlayerCharacterElementDefense(i) + '\n'
            + "Weapon: " + controller.getPlayerCharacterElementWeaponName(i) + '\n'
            + "Damage: " + controller.getPlayerCharacterElementWeaponDamage(i) + '\n'
            + "Weight: " + controller.getPlayerCharacterElementWeaponWeight(i) + '\n';
  }
  private String createWeaponInfo(int i) {
    return controller.getInventoryElementName(i) + '\n'
            + "Damage: " + controller.getInventoryElementDamage(i) + '\n'
            + "Weight: " + controller.getInventoryElementWeight(i) + '\n';
  }

  private void createPlayerCharactersInfo(Group root){
    int large = controller.getPlayerCharacterSize();
    int step = WIDTH/large;
    for(int i = 0; i < large; i++) {
      Label label = createLabel(10 + step*i, HEIGHT-100, createPlayerCharacterInfo(i));
      root.getChildren().add(label);
    }

  }

  private void createEnemiesInfo(Group root, boolean attack){
    int large = controller.getEnemyCharacterSize();
    int step = WIDTH / large;
    for (int i = 0; i < large; i++) {
      Label label = createLabel(10 + step * i, 10, createEnemyInfo(i));
      root.getChildren().add(label);
      if(attack){
        Button button = createButton(10 + step * i, 100, "Attack");
        final int n = i;
        button.setOnAction(event -> this.attackScene2(n, controller.getEnemyCharacterElementName(n)));
        root.getChildren().add(button);
      }
    }
  }
  private void createInventoryInfo(Group root){
    int large = controller.getPlayerInventorySize();
    int step = WIDTH/large;
    for(int i = 0; i < large; i++) {
      Label label = createLabel(10 + step*i, 100, createWeaponInfo(i));
      root.getChildren().add(label);
    }
  }

}



