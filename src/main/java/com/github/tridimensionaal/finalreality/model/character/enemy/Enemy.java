package com.github.tridimensionaal.finalreality.model.character.enemy;

import com.github.tridimensionaal.finalreality.model.character.AbstractCharacter;
import com.github.tridimensionaal.finalreality.model.character.ICharacter;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author Matías Salim Seda Auil
 */
public class Enemy extends AbstractCharacter {

  /**
   * Creates a new enemy with a name, a health, a defense, a health, a weight, a damage and the queue with the characters ready to play.
   *
   * @param weight
   *     the enemy's weight
   * @param damage
   *     the enemy's damage
   * 
   */
  private final int weight;
  private final int damage;

  public Enemy(@NotNull final BlockingQueue<ICharacter> turnsQueue, @NotNull String name, int health, int defense, int weight, int damage) {
    super(turnsQueue, name, health,defense );
    this.weight = weight;
    this.damage = damage;
  }

  /**
   * Returns the weight of this enemy.
   */
  public int getWeight() {
    return weight;
  }
  /**
   * Returns the damage of this enemy.
   */
  public int getDamage() {
    return damage;
  }

  public void attack(ICharacter character){
      character.receiveDamage(this.getDamage());
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Enemy)) {
      return false;
    }
    final Enemy enemy = (Enemy) o;
    return super.equals(o) && getWeight() == enemy.getWeight() && getDamage() == enemy.getDamage();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getHealth(), getDefense(), getWeight(),getDamage());
  }
}
