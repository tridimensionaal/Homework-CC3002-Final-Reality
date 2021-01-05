package com.github.tridimensionaal.finalreality.controller.phases;

/**
 * A class that holds all the information of a get character phase of the game.
 *
 * @author Matías Salim Seda Auil
 */
public class GetCharacterPhase extends Phase{
    public GetCharacterPhase(){
        this.namePhase = "Get character phase";
        this.canGetCharacter = true;
    }

    @Override
    public void toAttackPhase(){
        changePhase(new AttackPhase());
    }

    @Override
    public void toEquipWeaponPhase(){
        changePhase(new EquipWeaponPhase());
    }


    @Override
    public void toPrepareToAttackPhase(){
        changePhase(new PrepareToAttackPhase());
    }


    @Override
    public void getCharacter() throws InvalidMovementException {
        if(controller.getQueueSize()>0){
            super.getCharacter();
            if(controller.getCurrentCharacter().isPlayerCharacter()) {
                this.toEquipWeaponPhase();
            }
            else{
                this.toAttackPhase();
            }
        }
        else{
            this.toPrepareToAttackPhase();
        }
    }
}
