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
