# Final Reality

## What's this project about?
This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com)
enemies controlled by the computer.

## Game's logic
The game consists of fighting between the player's characters and the CPU's characters. 

The user (player) owns a set of different characters that they can control. The player's character types are engineer, knight, thief, black mage and white mage. The player's characters can equip weapons but a particular type of character can only equip a specific weapons.

- Engineers can only equip axes and bows.
- Knights can only equip axes, knifes and swords.
- Thiefs can only equip bows, staffs and swords.
- Blacks Mages can only equip knifes and staffs.
- Whites Mages can only equip staffs.

The CPU owns a set enemies that they can control. Only exists one type of CPU's characters. The enemies can't equip weapons

A player's characters can attack a enemies and enemies can attack player's characters. Every player's character and enemy have a turn to do things like attack or equip a weapon and then attack (in the case of a player character). In the game, player's characters and enemies have one turn or more. The game ends when all the player's characters have died or when all the enemys have died. If all the player's characters have died then the CPU win and if all the enemies have died then the user wins.


## Versions
- **Version 0.1**: Models of player's characters, enemies and weapons.
    - Implements the models of the all the player's characters, enemies and weapons.
- **Version 0.2**: Interaction between player's characters, enemies and weapons.
    - Complements the models of the all the player's characters, enemies and weapons.
    - Implements the game controller to implements the interaction between the player's characters, enemies and weapons.

    

=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a 
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)


