package com.github.tridimensionaal.finalreality.controller.phases;

import com.github.tridimensionaal.finalreality.controller.GameController;
import com.github.tridimensionaal.finalreality.model.character.ICharacter;
import com.github.tridimensionaal.finalreality.model.character.player.IPlayerCharacter;
import com.github.tridimensionaal.finalreality.model.weapon.IWeapon;
import com.github.tridimensionaal.finalreality.model.weapon.normal.Sword;

import java.util.Random;

public class Phase{
    protected GameController controller;
    protected boolean canCreateCharacters = false;
    protected boolean canAttack = false;
    protected boolean canPrepareToAttack= false;
    protected boolean canGetCharacter= false;

    protected String namePhase;

    public void setController(GameController controller){
        this.controller = controller;
    }

    protected void changePhase(Phase phase){
        controller.setPhase(phase);
    }

      public void CreateElements() throws InvalidMovementException {
          if(!canCreateCharacters){
              throw new InvalidMovementException("Can't create characters on " + this.toString() + ".");
          }
          for (int i = 1; i < 10; i++){
              controller.addEnemy(controller.createEnemy("Enemy " + i ));
          }
          IPlayerCharacter character1 = controller.createKnight("Knight");
          IWeapon sword = controller.createSword();
          character1.equipWeapon(sword);
          controller.addPlayerCharacter(character1);

          IPlayerCharacter character2 = controller.createEngineer("Engineer");
          IWeapon bow = controller.createBow();
          character2.equipWeapon(bow);
          controller.addPlayerCharacter(character2);

          IPlayerCharacter character3 = controller.createThief("Thief");
          IWeapon axe = controller.createAxe();
          character3.equipWeapon(axe);
          controller.addPlayerCharacter(character3);

          IPlayerCharacter character4 = controller.createBlackMage("Black mage");
          IWeapon knife = controller.createKnife();
          character3.equipWeapon(knife);
          controller.addPlayerCharacter(character4);

          IPlayerCharacter character5 = controller.createWhiteMage("White mage");
          IWeapon staff = controller.createStaff();
          character3.equipWeapon(staff);
          controller.addPlayerCharacter(character5);

          //Extra weapons
          controller.addWeaponToInventory(controller.createAxe());
          controller.addWeaponToInventory(controller.createBow());
          controller.addWeaponToInventory(controller.createStaff());

      }

      public void prepareToAttack() throws InvalidMovementException {
          if(!canPrepareToAttack){
              throw new InvalidMovementException("Can't prepare to attack on " + this.toString() + ".");
          }
          controller.addToQueue();
      }

      public void attack() throws InvalidMovementException {
          if(!canAttack){
              throw new InvalidMovementException("Can't attack on " + this.toString() + ".");
        }

         int large;
          Random rng = new Random();
          if(controller.getActualCharacter().isPlayerCharacter()){
            large = controller.getEnemyCharacterSize();
            controller.attack(controller.getEnemyCharacterElement(rng.nextInt(large)));

        }
        else{
            large = controller.getPlayerCharacterSize();
            controller.attack(controller.getPlayerCharacterElement(rng.nextInt(large)));
        }
  }

      public void getCharacter() throws InvalidMovementException {
          if(!canGetCharacter){
              throw new InvalidMovementException("Can't attack on " + this.toString() + ".");
        }
        controller.pollQueue();
  }

      public void toInitialPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException(
            "Can't change from " + this.toString() + " to initial phase");
      }

      public void toCreationPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException(
            "Can't change from " + this.toString() + " to creation phase ");
      }

      public void toPrepareToAttackPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException(
            "Can't change from " + this.toString() + " to prepare to attack phase");
      }

      public void toGetCharacterPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException(
            "Can't change from " + this.toString() + " to get character phase");
      }

      public void toAttackPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException(
            "Can't change from " + this.toString() + " to attack phase");
      }

      public void toFinalPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException(
            "Can't change from " + this.toString() + " to final phase");
      }

      public String toString(){
          return namePhase;
      }
}
