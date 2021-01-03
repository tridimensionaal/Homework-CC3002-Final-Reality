package com.github.tridimensionaal.finalreality.gui;

import com.github.tridimensionaal.finalreality.controller.GameController;
import com.github.tridimensionaal.finalreality.controller.phases.*;
import com.github.tridimensionaal.finalreality.model.character.ICharacter;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Random;

/**
 * Main entry point for the application.
 * <p>
 * <Complete here with the details of the implemented application>
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil.
 */
public class FinalReality extends Application {
  private final GameController controller = new GameController();
  private final int WIDTH = 640;
  private final int HEIGHT = 360;
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
  private Scene InitialScene() {
    Group root = new Group();
    Scene scene = new Scene(root, WIDTH, HEIGHT);
    Button button = new Button("Press to start the game");
    button.setLayoutX( WIDTH/2 - 130);
    button.setLayoutY(HEIGHT/2);
    button.setOnAction(event -> this.toCreationScene());
    root.getChildren().add(button);
    Label initialPhaseLabel = createLabel(10, 30, controller.getPhase().getText());
    root.getChildren().add(initialPhaseLabel);
    return scene;
  }

  private void toCreationScene() {
    try {
      controller.getPhase().toCreationPhase();
    } catch (InvalidTransitionException e) {
      e.printStackTrace();
    }
    Group root = new Group();
    Label label = createLabel(10, 30, controller.getPhase().getText());
    Button button = new Button("Press to start the fight");
    button.setLayoutX( WIDTH/2 - 130);
    button.setLayoutY(HEIGHT/2);
    button.setOnAction(event -> this.toPrepareToAttackScene());

    root.getChildren().add(button);
    root.getChildren().add(label);

    try {
      controller.getPhase().createElements();
    } catch (InvalidMovementException e) {
      e.printStackTrace();
    }
    actualScene.setRoot(root);
  }

  private void toPrepareToAttackScene() {
    Group root = new Group();
    Label initialPhaseLabel = createLabel(10, 30, controller.getPhase().getText());
    root.getChildren().add(initialPhaseLabel);
    actualScene.setRoot(root);
    try {
      controller.getPhase().prepareToAttack();
    } catch (InvalidMovementException e) {
      e.printStackTrace();
    }

    Task<Void> sleeper = new Task<Void>() {
      @Override
      protected Void call() throws Exception {
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        return null;
      }
    };
    sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
      @Override
      public void handle(WorkerStateEvent event) {
        getCharacterScene();
            }
        });
        new Thread(sleeper).start();
  }

    private void getCharacterScene() {
      if(controller.getPhase().equals(new FinalPhase(true))) {
          finalScene();
          return;
      }

      try {
        controller.getPhase().getCharacter();
      } catch (InvalidMovementException e) {
        e.printStackTrace();
      }

      if(controller.getPhase().equals(new PrepareToAttackPhase())) {
        toPrepareToAttackScene();
        return;
      }
      System.out.println(controller.getPhase().toString());

      Group root = new Group();
      int large = controller.getEnemyCharacterSize();
      int step = WIDTH/large;
      for(int i = 0; i < large; i++) {
        String text = controller.getEnemyCharacterElementName(i) + '\n'
                + "Health: " + controller.getEnemyCharacterElementHealth(i) + '\n'
                + "Defense: " + controller.getEnemyCharacterElementDefense(i) + '\n'
                + "Damage: " + controller.getEnemyCharacterElementDamage(i) + '\n'
                + "Weight: " + controller.getEnemyCharacterElementWeight(i) + '\n';
        Label label = createLabel(10 + step*i, 10, text);
        root.getChildren().add(label);
      }

      large = controller.getPlayerCharacterSize();
      step = WIDTH/large;
      for(int i = 0; i < large; i++) {
        String text = controller.getPlayerCharacterElementName(i) + '\n'
                + "Health: " + controller.getPlayerCharacterElementHealth(i) + '\n'
                + "Defense: " + controller.getPlayerCharacterElementDefense(i) + '\n'
                + "Weapon: " + controller.getPlayerCharacterElementWeaponName(i) + '\n'
                + "Damage: " + controller.getPlayerCharacterElementWeaponDamage(i) + '\n'
                + "Weight: " + controller.getPlayerCharacterElementWeaponWeight(i) + '\n';
        Label label = createLabel(10 + step*i, HEIGHT-100, text);
        root.getChildren().add(label);
      }
      Label label = createLabel(WIDTH/2 - 60 , HEIGHT/2, "It is " + controller.getCurrentCharacter().getName() + "'s turn");
      root.getChildren().add(label);

      Button button = new Button("Press to continue");
      button.setLayoutX( WIDTH/2 - 60);
      button.setLayoutY(HEIGHT/2+20);
      button.setOnAction(event -> this.attackScene1());
      root.getChildren().add(button);

      actualScene.setRoot(root);
    }
  private void attackScene1() {
    if(controller.getCurrentCharacter().isPlayerCharacter()) {
      Group root = new Group();
      int large = controller.getEnemyCharacterSize();
      int step = WIDTH / large;
      for (int i = 0; i < large; i++) {
        String text = controller.getEnemyCharacterElementName(i) + '\n'
                + "Health: " + controller.getEnemyCharacterElementHealth(i) + '\n'
                + "Defense: " + controller.getEnemyCharacterElementDefense(i) + '\n'
                + "Damage: " + controller.getEnemyCharacterElementDamage(i) + '\n'
                + "Weight: " + controller.getEnemyCharacterElementWeight(i) + '\n';
        Label label = createLabel(10 + step * i, 10, text);
        root.getChildren().add(label);

        Button button = new Button("attack");
        button.setLayoutX( 10 +step*i);
        button.setLayoutY(100);
        final int n = i;
        button.setOnAction(event -> this.attackScene2(n, controller.getEnemyCharacterElementName(n)));
        root.getChildren().add(button);
      }
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
    System.out.println(controller.getPhase().toString());

    Task<Void> sleeper = new Task<Void>() {
      @Override
      protected Void call() throws Exception {
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        return null;
      }
    };

    sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
      @Override
      public void handle(WorkerStateEvent event) {
        if(controller.getPhase().equals(new FinalPhase(true))){
          finalScene();
        }
        else{
            getCharacterScene();
        }
      }
    });
    new Thread(sleeper).start();
  }

  private void finalScene() {
    Group root = new Group();
    Label label = createLabel(10, 30, "GG ");
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
}

