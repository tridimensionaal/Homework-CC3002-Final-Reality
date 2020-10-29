package com.github.tridimensionaal.finalreality.model.character;

import com.github.tridimensionaal.finalreality.model.character.player.IPlayerCharacter;
import com.github.tridimensionaal.finalreality.model.character.enemy.Enemy;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Matías Salim Seda Auil
 */
public abstract class AbstractCharacter implements ICharacter {

  private final BlockingQueue<ICharacter> turnsQueue;
  private final String name;
  private int health;
  private final int defense;
  private ScheduledExecutorService scheduledExecutor;

  /**
   * Creates a new abstract character.
   *
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   * @param name
   *     the character's name
   * @param health 
   *     the character's health 
   * @param defense
   *     the character's health 
   */

  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue, final String name, int health, final int defense) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.health = health;
    this.defense = defense;
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    if (this instanceof IPlayerCharacter) {
      var player = (IPlayerCharacter) this;
      scheduledExecutor
              .schedule(this::addToQueue, player.getEquippedWeapon().getWeight()/ 10, TimeUnit.SECONDS);

    } else {
      var enemy = (Enemy) this;
      scheduledExecutor
          .schedule(this::addToQueue, enemy.getWeight() / 10, TimeUnit.SECONDS);
    }
  }

  @Override
  public void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getHealth() {
    return health;
  }

  @Override
  public int getDefense() {
    return defense;
  }

  public void receiveDamage(int damage){
      if(health == 0){
          return;
      }
      health -= (damage - this.defense);
      if (health < 1){
          health = 0;
      }
  }

  @Override
  public boolean equals(final Object o) {
    /*if (this == o) {
      return true;
    }
    if (!(o instanceof ICharacter)) {
      return false;
    }
    */
    final ICharacter that = (ICharacter) o;
    return getName().equals(that.getName()) && getHealth() == that.getHealth() && getDefense() == that.getDefense(); 
  }
}

