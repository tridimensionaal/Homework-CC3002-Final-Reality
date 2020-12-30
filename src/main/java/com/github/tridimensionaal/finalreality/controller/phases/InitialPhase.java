package com.github.tridimensionaal.finalreality.controller.phases;


public class InitialPhase extends Phase{
    public InitialPhase(){
        this.namePhase = "Initial phase";
    }

    @Override
    public void toCreationPhase(){
        changePhase(new CreationPhase());
    }

}


