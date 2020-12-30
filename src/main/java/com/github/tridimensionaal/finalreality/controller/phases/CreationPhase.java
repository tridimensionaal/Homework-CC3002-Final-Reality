package com.github.tridimensionaal.finalreality.controller.phases;

public class CreationPhase extends Phase{
    public CreationPhase(){
        this.canCreateCharacters = true;
        this.namePhase = "Creation phase";
    }

    @Override
    public void CreateElements() throws InvalidMovementException {
        super.CreateElements();
        this.toPrepareToAttackPhase();
    }

    @Override
    public void toPrepareToAttackPhase(){
        changePhase(new PrepareToAttackPhase());
    }
}
