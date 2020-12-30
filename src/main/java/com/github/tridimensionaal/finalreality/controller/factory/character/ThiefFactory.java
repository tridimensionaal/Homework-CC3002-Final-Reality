package com.github.tridimensionaal.finalreality.controller.factory.character;

import java.util.concurrent.BlockingQueue;

import com.github.tridimensionaal.finalreality.model.character.ICharacter;
import com.github.tridimensionaal.finalreality.model.character.player.normal.Thief;



public class ThiefFactory extends AbstractCharacterFactory{
    public ThiefFactory(String name, BlockingQueue<ICharacter> queue){
        character = new Thief(queue,name,health,defense);
    }

}


