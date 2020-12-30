package com.github.tridimensionaal.finalreality.controller.phases;


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
    public void attack() throws InvalidMovementException {
        super.attack();
        this.toGetCharacterPhase();
    }
}
