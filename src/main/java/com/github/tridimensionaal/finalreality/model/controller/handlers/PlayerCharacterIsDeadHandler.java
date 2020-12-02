package com.github.tridimensionaal.finalreality.model.controller.handlers;

import com.github.tridimensionaal.finalreality.model.controller.GameController;
import java.beans.PropertyChangeEvent;
import com.github.tridimensionaal.finalreality.model.character.player.IPlayerCharacter;


public class PlayerCharacterIsDeadHandler implements IEventHandler {
  private final GameController controller;

  public PlayerCharacterIsDeadHandler(GameController controller) {
    this.controller = controller;
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    controller.onPlayerCharacterHasDied((IPlayerCharacter) evt.getNewValue());
  }
}
