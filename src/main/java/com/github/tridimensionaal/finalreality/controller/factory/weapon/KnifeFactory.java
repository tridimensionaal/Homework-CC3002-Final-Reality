package com.github.tridimensionaal.finalreality.controller.factory.weapon;

import com.github.tridimensionaal.finalreality.model.weapon.IWeapon;
import com.github.tridimensionaal.finalreality.model.weapon.normal.Knife;



public class KnifeFactory extends AbstractWeaponFactory{

    public KnifeFactory(){
        //10
        int damage = 12;
        //6
        int weight = 6;
        int extra_value = rng.nextInt(4);
        damage += extra_value;
        weight += extra_value;

        weapon = new Knife(damage,weight);

    }

}


