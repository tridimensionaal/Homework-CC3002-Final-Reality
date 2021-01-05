package com.github.tridimensionaal.finalreality.controller.factory.character;


import com.github.tridimensionaal.finalreality.model.character.ICharacter;
import com.github.tridimensionaal.finalreality.model.character.enemy.Enemy;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class EnemyFactory extends AbstractCharacterFactory{


    public EnemyFactory(String name, BlockingQueue<ICharacter> queue){
        Random rng = new Random();
        int extra_value = rng.nextInt(5);
        int damage = 12 + extra_value*2;
        int weight = 10 + extra_value;
        character = new Enemy(queue,name,health,defense,weight,damage);
    }

}


