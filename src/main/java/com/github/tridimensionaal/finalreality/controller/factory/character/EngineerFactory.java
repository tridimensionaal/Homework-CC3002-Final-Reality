package com.github.tridimensionaal.finalreality.controller.factory.character;

import java.util.concurrent.BlockingQueue;

import com.github.tridimensionaal.finalreality.model.character.ICharacter;
import com.github.tridimensionaal.finalreality.model.character.player.normal.Engineer;



public class EngineerFactory extends AbstractCharacterFactory{
    public EngineerFactory(String name, BlockingQueue<ICharacter> queue){
        character = new Engineer(queue,name,health,defense);
    }
}


