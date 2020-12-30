package com.github.tridimensionaal.finalreality.controller.phases;


public class AttackPhase extends Phase{
    public AttackPhase(){
        this.canAttack = true;
        this.namePhase = "Attack phase";
    }


    @Override
    public void toPrepareToAttackPhase(){
        changePhase(new PrepareToAttackPhase());
    }

    @Override
    public void toFinalPhase(){
        changePhase(new FinalPhase());
    }

    @Override
    public void attack() throws InvalidMovementException {
        if(this.canAttack) {
            super.attack();
            this.attack();
        }
        else {
            this.toPrepareToAttackPhase();
        }
    }
}
