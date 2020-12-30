package com.github.tridimensionaal.finalreality.controller.factory.weapon;

import com.github.tridimensionaal.finalreality.model.weapon.IWeapon;
import com.github.tridimensionaal.finalreality.model.weapon.normal.Bow;



public class BowFactory extends AbstractWeaponFactory{

    public BowFactory(){
        int damage = 8;
        int weight = 4;
        int extra_value = rng.nextInt(6);
        damage += extra_value;
        weight += extra_value;

        weapon = new Bow(damage,weight);

    }

}


