package com.github.tridimensionaal.finalreality.controller.phases;

import com.github.tridimensionaal.finalreality.controller.GameController;

public class Phase{
    protected GameController controller;
    protected boolean canCreateCharacters = false;
    protected boolean canAttack = false;
    protected boolean canPrepareToAttack= false;
    protected boolean gameOver = false;
    protected boolean enemiesHasWon = false;
    protected boolean playerHasWon = false;

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
          //controller.CreateElements();
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
  }
      public void gameOver() throws InvalidMovementException {
          if (!canAttack) {
              throw new InvalidMovementException("Can't attack on " + this.toString() + ".");
          }
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

      public void toAttackPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException(
            "Can't change from " + this.toString() + " to prepare to attack phase");
      }

      public void toFinalPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException(
            "Can't change from " + this.toString() + " to prepare to attack phase");
      }

    public String toString(){
        return namePhase;
    }
}
