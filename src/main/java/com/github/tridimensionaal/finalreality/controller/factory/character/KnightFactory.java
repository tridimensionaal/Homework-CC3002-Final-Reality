package com.github.tridimensionaal.finalreality.controller.factory.character;

import java.util.concurrent.BlockingQueue;

import com.github.tridimensionaal.finalreality.model.character.ICharacter;
import com.github.tridimensionaal.finalreality.model.character.player.normal.Knight;



public class KnightFactory extends AbstractCharacterFactory{
    public KnightFactory(String name, BlockingQueue<ICharacter> queue){
        character = new Knight(queue,name,health,defense);
    }

}


