package com.github.tridimensionaal.finalreality.controller.factory.character;

import com.github.tridimensionaal.finalreality.model.character.ICharacter;


public abstract class AbstractCharacterFactory{
    protected final int health = 25;
    protected final int defense = 5;

    ICharacter character;

    public ICharacter createCharacter(){
        return character;
    }
}


