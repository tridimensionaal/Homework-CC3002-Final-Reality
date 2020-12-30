package com.github.tridimensionaal.finalreality.controller.factory.character;

import com.github.tridimensionaal.finalreality.model.character.ICharacter;
import com.github.tridimensionaal.finalreality.model.character.player.normal.BlackMage;

import java.util.concurrent.BlockingQueue;


public class BlackMageFactory extends AbstractCharacterFactory {
    public BlackMageFactory(String name, BlockingQueue<ICharacter> queue){
        character = new BlackMage(queue,name,health,defense);
    }
}


