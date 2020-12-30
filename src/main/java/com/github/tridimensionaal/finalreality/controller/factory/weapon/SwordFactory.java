package com.github.tridimensionaal.finalreality.controller.factory.weapon;

import com.github.tridimensionaal.finalreality.model.weapon.IWeapon;
import com.github.tridimensionaal.finalreality.model.weapon.normal.Sword;



public class SwordFactory extends AbstractWeaponFactory{

    public SwordFactory(){
        int damage = 18;
        int weight = 10;
        int extra_value = rng.nextInt(2);
        damage += extra_value;
        weight += extra_value*2;

        weapon = new Sword(damage,weight);

    }

}


