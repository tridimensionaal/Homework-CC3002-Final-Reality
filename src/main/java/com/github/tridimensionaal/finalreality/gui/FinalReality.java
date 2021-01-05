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
    createLabel(10, 30, controller.getPhaseText(), root);
    Button button = createButton(centerX - 100, centerY - 20, "Press to start the game");
    button.setOnAction(event -> this.creationScene());
    root.getChildren().add(button);
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
    createLabel(10, 30, controller.getPhaseText(), root);
    Button button = createButton(centerX - 100, centerY - 20, "Press to start the fight");
    button.setOnAction(event -> this.prepareToAttackScene());
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
    createLabel(10, 30, controller.getPhaseText(),root);
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

  /**
   * Creates the get character scene of the game.
   */
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

    if (controller.isTheCurrentCharacterAPlayerCharacter()) {
      createLabel(centerX - 200, centerY - 20, "It is " + controller.getCurrentCharacterName()+ "'s turn\n" +
              "Choose attack or equip a new weapon and then attack", root);

      Button button = createButton(centerX - 200, centerY+20, "Equip a new weapon");
      button.setOnAction(event -> this.equipWeaponScene1(controller.getCurrentCharacterName(),true));
      root.getChildren().add(button);

      Button button1 = createButton(centerX +50, centerY+20, "Attack");
      button1.setOnAction(event -> this.attackScene1(controller.getCurrentCharacterName()));
      root.getChildren().add(button1);

    } else {
      createLabel(centerX - 100, centerY - 20, "It is " + controller.getCurrentCharacterName() + "'s turn", root);

      Button button = createButton(centerX - 100, centerY, "Press to continue");
      button.setOnAction(event -> this.attackScene1(controller.getCurrentCharacterName()));
      root.getChildren().add(button);
    }
    actualScene.setRoot(root);
  }

  /**
   * Creates the equip weapon scene of the game.
   * @param name the name of the current character
   * @param bol true if the player haven't tried to equip a new weapon otherwise false
   */
  private void equipWeaponScene1(String name,boolean bol) {
    Group root = new Group();
    createPlayerCharactersInfo(root);
    String text;
    if(bol) {
      text = "Choose a weapon to equip to " + name;
    }
    else{
        text = name + " can't equip these weapon. Choose another weapon";

    }
    createLabel(centerX - 150, centerY - 20, text, root);

    Button button = createButton(centerX - 150, centerY, "Press if you dont want to change the weapon");
    button.setOnAction(event -> this.attackScene1(controller.getCurrentCharacterName()));
    root.getChildren().add(button);

    createInventoryInfo(root);
    actualScene.setRoot(root);
  }

  /**
   * Creates the first part of the attack scene of the game.
   * @param name the name of the current character
   */
  private void attackScene1(String name) {
    if(controller.getPhase().equals(new EquipWeaponPhase())){
      try {
        controller.getPhase().toAttackPhase();
      } catch (InvalidTransitionException e) {
        e.printStackTrace();
      }

    }
    if(controller.isTheCurrentCharacterAPlayerCharacter()) {

      Group root = new Group();
      createEnemiesInfo(root, true);
      createPlayerCharactersInfo(root);
      createLabel(centerX - 100, centerY - 20, "Choose a enemy to attack \n"+ name + " is going to attack",root);
      actualScene.setRoot(root);
    }
    else {
        Random rng = new Random();
        int large = controller.getPlayerCharacterSize();
        int i = rng.nextInt(large);
        attackScene2(i, controller.getPlayerCharacterElementName(i));
    }
  }
  /**
   * Creates the second part of the attack scene of the game.
   * @param i the index of the character to be attacked.
   * @param name the name of the attacked character.
   *
   */
  private void attackScene2(int i, String name) {
    Group root = new Group();
    try {
      controller.getPhase().attack(i);
    } catch (InvalidMovementException e) {
      e.printStackTrace();
    }

    String text = controller.getCurrentCharacterName() + " has attacked " +  name;
    createLabel(10, 30, text, root);
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

  /**
   * Creates the second part of the attack scene of the game.
   */
  private void finalScene() {
    Group root = new Group();
    createLabel(10, 30, controller.getPhaseText(),root);
    actualScene.setRoot(root);
  }

  /**
   * Creates a new label
   * @param x position in the x-axis of the label
   * @param y position in the y-axis of the label
   * @param text text of the label
   * @param root where the label if going to be added
   */
  private void createLabel(int x, int y, String text, Group root) {
    Label label = new Label();
    label.setLayoutX(x);
    label.setLayoutY(y);
    label.setText(text);
    root.getChildren().addAll(label);
  }
  /**
   * Creates a new button
   * @param x position in the x-axis of the button
   * @param y position in the y-axis of the button
   * @param text button of the label
   * @return the new created button
   *
   */
  private Button createButton(int x, int y, String text) {
    Button button = new Button(text);
    button.setLayoutX(x);
    button.setLayoutY(y);
    return button;
  }

  /**
   * Creates the "information" of a enemy
   * @param i index of the enemy
   * @return a string with all the enemy's information
   *
   */
  private String createEnemyInfo(int i) {
    return  controller.getEnemyCharacterElementName(i) + '\n'
            + "Health: " + controller.getEnemyCharacterElementHealth(i) + '\n'
            + "Defense: " + controller.getEnemyCharacterElementDefense(i) + '\n'
            + "Damage: " + controller.getEnemyCharacterElementDamage(i) + '\n'
            + "Weight: " + controller.getEnemyCharacterElementWeight(i) + '\n';
  }

  /**
   * Creates the "information" of a player character
   * @param i index of the player character
   * @return a string with all the player character's information
   *
   */
  private String createPlayerCharacterInfo(int i) {
    return controller.getPlayerCharacterElementName(i) + '\n'
            + "Health: " + controller.getPlayerCharacterElementHealth(i) + '\n'
            + "Defense: " + controller.getPlayerCharacterElementDefense(i) + '\n'
            + "Weapon: " + controller.getPlayerCharacterElementWeaponName(i) + '\n'
            + "Damage: " + controller.getPlayerCharacterElementWeaponDamage(i) + '\n'
            + "Weight: " + controller.getPlayerCharacterElementWeaponWeight(i) + '\n';
  }

  /**
   * Creates the "information" of a weapon
   * @param i index of the weapon
   * @return a string with all the weapon's information
   *
   */
  private String createWeaponInfo(int i) {
    return controller.getInventoryElementName(i) + '\n'
            + "Damage: " + controller.getInventoryElementDamage(i) + '\n'
            + "Weight: " + controller.getInventoryElementWeight(i) + '\n';
  }

  /**
   * Creates the "information" of all player characters in the game.
   * @param root where all the information is going to be added
   */
  private void createPlayerCharactersInfo(Group root){
    int large = controller.getPlayerCharacterSize();
    int step = WIDTH/large;
    for(int i = 0; i < large; i++) {
      createLabel(10 + step*i, HEIGHT-100, createPlayerCharacterInfo(i),root);
    }

  }
  /**
   * Creates the "information" of all enemies in the game.
   * @param root where all the information is going to be added
   */
  private void createEnemiesInfo(Group root, boolean attack){
    int large = controller.getEnemyCharacterSize();
    int step = WIDTH / large;
    for (int i = 0; i < large; i++) {
      createLabel(10 + step * i, 10, createEnemyInfo(i),root);
      if(attack){
        Button button = createButton(10 + step * i, 100, "Attack");
        final int n = i;
        button.setOnAction(event -> this.attackScene2(n, controller.getEnemyCharacterElementName(n)));
        root.getChildren().add(button);
      }
    }
  }

  /**
   * Creates the "information" of all weapons in the game.
   * @param root where all the information is going to be added
   */
  private void createInventoryInfo(Group root){
    int large = controller.getPlayerInventorySize();
    int step = WIDTH/large;
    for(int i = 0; i < large; i++) {
      createLabel(10 + step*i, 10, createWeaponInfo(i),root);
      Button button = createButton(10 + step * i, 70, "Equip");
      final int n = i;
      button.setOnAction(event -> this.equipWeapon(n));
      root.getChildren().add(button);

    }
  }

  /**
   * Handles the logic of the scenes when the current character tries to equip a new weapon.
   * @param i the index of the weapon to be equipped
   */
  private void equipWeapon(int i) {
    try {
      controller.getPhase().equipWeapon(i);
    } catch (InvalidMovementException e) {
      e.printStackTrace();
    }

    if(controller.getPhase().equals(new AttackPhase())) {
      attackScene1(controller.getCurrentCharacter().getName());
    }
    else{
      equipWeaponScene1(controller.getCurrentCharacter().getName(), false);
    }
  }
}



