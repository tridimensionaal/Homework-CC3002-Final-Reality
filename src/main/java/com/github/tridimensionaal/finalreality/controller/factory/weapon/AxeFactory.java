package com.github.tridimensionaal.finalreality.controller.factory.weapon;

import com.github.tridimensionaal.finalreality.model.weapon.normal.Axe;

public class AxeFactory extends AbstractWeaponFactory{

    public AxeFactory(){
        int damage = 20;
        int weight = 13;
        int extra_value = rng.nextInt(3);
        damage += extra_value;
        weight += extra_value*3;

        weapon = new Axe(damage,weight);

    }

}


