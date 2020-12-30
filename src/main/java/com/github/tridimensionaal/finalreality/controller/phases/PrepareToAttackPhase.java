package com.github.tridimensionaal.finalreality.controller.phases;

public class PrepareToAttackPhase extends Phase{
    public PrepareToAttackPhase(){
        this.namePhase = "Prepare to attack phase";
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
