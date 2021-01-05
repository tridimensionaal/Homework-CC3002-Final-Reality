package com.github.tridimensionaal.finalreality.controller.phases;

/**
 * A class that holds all the information of a equip weapon phase of the game.
 *
 * @author Matías Salim Seda Auil
 */
public class EquipWeaponPhase extends Phase{
    public EquipWeaponPhase(){
        this.namePhase = "Equip weapon phase";
        this.canChangeWeapon= true;
    }

    @Override
    public void toAttackPhase(){
        changePhase(new AttackPhase());
    }

    @Override
    public void equipWeapon(int i) throws InvalidMovementException {
        super.equipWeapon(i);
        if(changeWeapon){
            this.toAttackPhase();
        }
    }
}
