package com.github.tridimensionaal.finalreality.controller.phases;

/**
 * A class that holds all the information of a creation phase of the game.
 *
 * @author Matías Salim Seda Auil
 */
public class CreationPhase extends Phase{
    public CreationPhase(){
        this.canCreateCharacters = true;
        this.namePhase = "Creation phase";
        this.text = "You have Knight, an Engineer, a Thief, a Black Mage and a White Mage to fight. \nThe CPU has 9 enemies to fight. \nEvery one of your characters has a initial weapon. \nYou have a inventory with 3 extra weapon.";


    }

    @Override
    public void createElements() throws InvalidMovementException {
        super.createElements();
        this.toPrepareToAttackPhase();
    }

    @Override
    public void toPrepareToAttackPhase(){
        changePhase(new PrepareToAttackPhase());
    }
}
