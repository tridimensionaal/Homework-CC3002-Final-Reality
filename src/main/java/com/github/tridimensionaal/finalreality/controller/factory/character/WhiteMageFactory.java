package com.github.tridimensionaal.finalreality.controller.factory.character;

import java.util.concurrent.BlockingQueue;

import com.github.tridimensionaal.finalreality.model.character.ICharacter;
import com.github.tridimensionaal.finalreality.model.character.player.normal.WhiteMage;


public class WhiteMageFactory extends AbstractCharacterFactory{
    public WhiteMageFactory(String name, BlockingQueue<ICharacter> queue){
        character = new WhiteMage(queue,name,health,defense);
    }

}


