package com.github.tridimensionaal.finalreality.controller.phases;

public class PrepareToAttackPhase extends Phase{
    public PrepareToAttackPhase(){
        this.namePhase = "Prepare to attack phase";
    }

    @Override
    public void toAttackPhase(){
        changePhase(new AttackPhase());
    }

    @Override
    public void prepareToAttack () throws InvalidMovementException {
        super.prepareToAttack();
        this.toAttackPhase();
    }

}
