package com.github.tridimensionaal.finalreality.controller.factory.weapon;

import com.github.tridimensionaal.finalreality.model.weapon.IWeapon;

import java.util.Random;


public abstract class AbstractWeaponFactory{
    protected IWeapon weapon;
    protected Random rng = new Random();

    public IWeapon createWeapon() {
        return weapon;
    }
}


