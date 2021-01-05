package com.github.tridimensionaal.finalreality.controller.phases;

/**
 * A class that holds all the information of a attack phase of the game.
 *
 * @author Matías Salim Seda Auil
 */
public class AttackPhase extends Phase{
    public AttackPhase(){
        this.canAttack = true;
        this.namePhase = "Attack phase";
    }

    @Override
    public void toGetCharacterPhase(){
        changePhase(new GetCharacterPhase());
    }

    @Override
    public void toFinalPhase(){
        changePhase(new FinalPhase());
    }


    @Override
    public void attack(int i) throws InvalidMovementException {
        super.attack(i);
        if(!this.gameOver){
            this.toGetCharacterPhase();
        }
        else{
            this.toFinalPhase();

        }

    }
}
