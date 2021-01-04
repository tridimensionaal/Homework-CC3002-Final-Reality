package com.github.tridimensionaal.finalreality.controller.phases;

import com.github.tridimensionaal.finalreality.controller.GameController;
import com.github.tridimensionaal.finalreality.model.character.player.IPlayerCharacter;
import com.github.tridimensionaal.finalreality.model.weapon.IWeapon;

import java.util.Objects;

/**
 * A class that holds all the information of a phase of the game.
 *
 * @author Matías Salim Seda Auil
 */
public class Phase {
    protected GameController controller;
    protected boolean canCreateCharacters = false;
    protected boolean canAttack = false;
    protected boolean canPrepareToAttack = false;
    protected boolean canGetCharacter = false;
    protected boolean gameOver = false;
    protected boolean winner = false;
    protected String text = "";

    protected String namePhase;

    /**
     * Sets a new controller
     *
     * @param controller the new controller to be set
     */
    public void setController(GameController controller) {
        this.controller = controller;
    }

    /**
     * Changes the actual phase to a new phase
     *
     * @param phase the new
     */
    protected void changePhase(Phase phase) {
        controller.setPhase(phase);
    }

    /**
     * Creates player characters, enemies and weapons.
     */
    public void createElements() throws InvalidMovementException {
        if (!canCreateCharacters) {
            throw new InvalidMovementException("Can't create characters on " + this.toString());
        }

        for (int i = 1; i < 7; i++) {
            controller.addEnemy(controller.createEnemy("Enemy " + i));
        }

        IPlayerCharacter character1 = controller.createKnight("Knight");
        IWeapon sword = controller.createSword();
        character1.equipWeapon(sword);
        controller.addPlayerCharacter(character1);

        IPlayerCharacter character2 = controller.createEngineer("Engineer");
        IWeapon axe = controller.createAxe();
        character2.equipWeapon(axe);
        controller.addPlayerCharacter(character2);

        IPlayerCharacter character3 = controller.createThief("Thief");
        IWeapon bow = controller.createBow();
        character3.equipWeapon(bow);
        controller.addPlayerCharacter(character3);

        IPlayerCharacter character4 = controller.createBlackMage("Black mage");
        IWeapon knife = controller.createKnife();
        character4.equipWeapon(knife);
        controller.addPlayerCharacter(character4);

        IPlayerCharacter character5 = controller.createWhiteMage("White mage");
        IWeapon staff = controller.createStaff();
        character5.equipWeapon(staff);
        controller.addPlayerCharacter(character5);

        //Extra weapons
        controller.addWeaponToInventory(controller.createAxe());
        controller.addWeaponToInventory(controller.createBow());
        controller.addWeaponToInventory(controller.createStaff());

    }

    /**
     * Adds all player characters and enemies to the queue
     */
    public void prepareToAttack() throws InvalidMovementException {
        if (!canPrepareToAttack) {
            throw new InvalidMovementException("Can't prepare to attack on " + this.toString());
        }
        controller.addToQueue();
    }


    /**
     * Gets the first character of the queue
     */
    public void getCharacter() throws InvalidMovementException {
        if (!canGetCharacter) {
            throw new InvalidMovementException("Can't get character on " + this.toString());
        }
        controller.pollQueue();
    }


    /**
     * The current character attacks
     */
    public void attack(int i) throws InvalidMovementException {
        if (!canAttack) {
            throw new InvalidMovementException("Can't attack on " + this.toString());
        }
        if (controller.getCurrentCharacter().isPlayerCharacter()) {
            controller.attack(controller.getEnemyCharacterElement(i));

        } else {

            controller.attack(controller.getPlayerCharacterElement(i));
        }
    }

    /**
     * Changes the actual phase to the initial phase
     */
    public void toInitialPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException(
                "Can't change from " + this.toString() + " to initial phase");
    }

    /**
     * Changes the actual phase to the creation phase
     */
    public void toCreationPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException(
                "Can't change from " + this.toString() + " to creation phase");
    }

    /**
     * Changes the actual phase to the creation phase
     */
    public void toPrepareToAttackPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException(
                "Can't change from " + this.toString() + " to prepare to attack phase");
    }

    /**
     * Changes the actual phase to the get character phase.
     */
    public void toGetCharacterPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException(
                "Can't change from " + this.toString() + " to get character phase");
    }

    /**
     * Changes the actual phase to the equip weapon phase.
     */
    public void toEquipWeaponPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException(
                "Can't change from " + this.toString() + " to equip weapon phase");
    }

    /**
     * Changes the actual phase to the attack phase.
     */
    public void toAttackPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException(
                "Can't change from " + this.toString() + " to attack phase");
    }

    /**
     * Changes the actual phase to the final phase
     */
    public void toFinalPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException(
                "Can't change from " + this.toString() + " to final phase");
    }

    public String toString() {
        return namePhase;
    }

    public String getText() {
        return text;
    }

    public void gameOver() {
        this.gameOver = true;
    }

    public void playerWin() {
        this.winner = true;
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(this.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Phase)) {
            return false;
        }
        Phase that = (Phase) obj;
        return that.toString().equals(this.toString());
    }
}


