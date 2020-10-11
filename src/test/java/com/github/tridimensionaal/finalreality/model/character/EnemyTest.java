package com.github.tridimensionaal.finalreality.model.character;

import com.github.tridimensionaal.finalreality.model.character.enemy.*;
import com.github.tridimensionaal.finalreality.model.character.player.normal.Thief;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class EnemyTest extends AbstractCharacterTest {

  private static final String ENEMY_NAME = "Goblin";
  private static final int ENEMY_HEALTH = 10;
  private static final int ENEMY_DEFENSE = 10;
  private static final int ENEMY_WEIGHT = 10;
  private static final int ENEMY_DAMAGE = 10;

  @BeforeEach
  void setUp() {
    basicSetUp();
    testCharacters.add(new Enemy(turns, ENEMY_NAME, ENEMY_HEALTH,ENEMY_DEFENSE, ENEMY_WEIGHT, ENEMY_DAMAGE));
  }

  @Test
  void constructorTest() {
    checkConstruction(new Enemy(turns, ENEMY_NAME, ENEMY_HEALTH,ENEMY_DEFENSE, ENEMY_WEIGHT, ENEMY_DAMAGE),
        testCharacters.get(0),
        new Enemy(turns, ENEMY_NAME, 11,11,11,11),
        new Thief(turns, ENEMY_NAME, 10, 10));
  }
}
