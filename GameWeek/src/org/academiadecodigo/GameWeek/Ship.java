package org.academiadecodigo.GameWeek;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Ship implements KeyboardHandler {

    private Picture ship;
    private Position pos;

    private Bullet bullet;
    private Enemies enemies;

    public Ship() {
        ship = new Picture(260, 700, "resources/nave.png");
        pos = new Position(ship.getX(), ship.getY());
       // ship.setColor(Color.BLUE);
        bullet = new Bullet(ship.getX() + ship.getWidth() / 2, ship.getY());
        enemies = new Enemies();
        bullet.setEnemies(enemies);
        enemies.setBullet(bullet);
        ship.draw();
        keyboardInit();
    }

    public void keyboardInit () {

        Keyboard keyboard = new Keyboard(this);

        //Right key
        KeyboardEvent rightPress = new KeyboardEvent();
        rightPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        rightPress.setKey(KeyboardEvent.KEY_RIGHT);

        KeyboardEvent leftPress = new KeyboardEvent();
        leftPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        leftPress.setKey(KeyboardEvent.KEY_LEFT);

        KeyboardEvent spacePress = new KeyboardEvent();
        spacePress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        spacePress.setKey(KeyboardEvent.KEY_SPACE);

        keyboard.addEventListener(rightPress);
        keyboard.addEventListener(leftPress);
        keyboard.addEventListener(spacePress);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:

                if (ship.getX() < 480) {
                    ship.translate(10, 0);
                }
                break;

            case KeyboardEvent.KEY_LEFT:

                if (ship.getX() > 20) {
                    ship.translate(-10, 0);
                }
                break;

            case KeyboardEvent.KEY_SPACE:

                shootBullet();
                break;

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    private void shootBullet() {
        Bullet bullet = new Bullet(ship.getX() + ship.getWidth() / 2, ship.getY());
        new Thread(bullet::fire).start();
        System.out.println("PEW PEW");

    }


}


