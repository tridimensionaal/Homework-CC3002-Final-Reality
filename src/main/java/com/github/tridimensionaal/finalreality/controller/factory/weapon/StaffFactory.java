package com.github.tridimensionaal.finalreality.controller.factory.weapon;

import com.github.tridimensionaal.finalreality.model.weapon.IWeapon;
import com.github.tridimensionaal.finalreality.model.weapon.normal.Staff;



public class StaffFactory extends AbstractWeaponFactory{

    public StaffFactory(){
        //22
        int damage = 22;
        //18
        int weight = 18;
        int extra_value = rng.nextInt(1);
        damage += extra_value;
        weight += extra_value;

        weapon = new Staff(damage,weight);
    }

}


