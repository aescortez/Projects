package org.academiadecodigo.GameWeek;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Enemies {

    private final int enemySize = 20;
    private final int gap = 20;
    private final int numEnemies = 10;
    private Picture[] enemies;

    private CollisionDetector collisionDetector;

    private Bullet bullet;
    private Picture enemy;

    public Enemies() {
        enemies = new Picture[numEnemies];

        createEnemies();
        moveEnemies();

    }

    public Picture[] getEnemiesPic() {
        return enemies;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }



    private void createEnemies() {

        int initialX = 75;
        for (int i = 0; i < numEnemies; i++) {
            int x = initialX + i * (enemySize + gap);
            int y = 75;
            enemies[i] = new Picture(x, y, "resources/alien.png");
            enemies[i].translate(0, 35);
            enemies[i].draw();
            enemy = enemies[i];

        }
    }
    public void collidedEnemy () {
        for (int i = 0; i < numEnemies; i++)
            enemies[i].delete();
    }

    //TODO: Bug!!!
    public void moveEnemies() {
        while (true) {
            for (int i = 0; i < numEnemies; i++) {
                if (enemies[i] != null && enemies[i].getY() < 680) {
                    enemies[i].translate(0, 10);
                    System.out.println(enemies[i].getY());

                    if (bullet != null && collisionDetector.checkCollision(bullet.getBullet(), enemies[i])) {
                        System.out.println("POOF");
                        enemies[i].delete();
                        enemies[i] = null;
                    }

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }


        //TODO: check!!!!!!!!


    }





