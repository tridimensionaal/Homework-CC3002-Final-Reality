package com.github.tridimensionaal.finalreality.controller.handlers;

import com.github.tridimensionaal.finalreality.model.character.ICharacter;
import com.github.tridimensionaal.finalreality.controller.GameController;
import java.beans.PropertyChangeEvent;


public class EnemyIsDeadHandler implements IEventHandler {
  private final GameController controller;

  public EnemyIsDeadHandler(GameController controller) {
    this.controller = controller;
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    controller.onEnemyHasDied((ICharacter) evt.getNewValue());
  }
}
