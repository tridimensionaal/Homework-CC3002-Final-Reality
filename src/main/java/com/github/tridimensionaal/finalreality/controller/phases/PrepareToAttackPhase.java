package com.github.tridimensionaal.finalreality.controller.phases;

/**
 * A class that holds all the information of a prepare to attack phase of the game.
 *
 * @author Matías Salim Seda Auil
 */
public class PrepareToAttackPhase extends Phase{
    public PrepareToAttackPhase(){
        this.namePhase = "Prepare to attack phase";
        this.canPrepareToAttack = true;
        this.text = "Preparing to fight";
    }

    @Override
    public void toGetCharacterPhase(){
        changePhase(new GetCharacterPhase());
    }

    @Override
    public void prepareToAttack () throws InvalidMovementException {
        super.prepareToAttack();
        this.toGetCharacterPhase();
    }

}
