package org.academiadecodigo.GameWeek;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;

class Bullet {
    private static final int BULLET_SPEED = 10;
    private Picture bullet;
    private  Enemies enemies;
    private CollisionDetector collisionDetector;

    public Bullet(int x, int y) {
        bullet = new Picture(x, y, "resources/bullets.png");
       // bullet = new Rectangle(x, y, 5, 10);
        // bullet.setColor(Color.RED);
        bullet.draw();
    }

    public void setEnemies(Enemies enemies) {
        this.enemies = enemies;
    }

    public Picture getBullet() {
        return bullet;
    }

    public void collidedBullet() {
        bullet.delete();
    }

    public void fire() {
        while (bullet.getY() > 0) {
            bullet.translate(0, -BULLET_SPEED);
            if (collisionDetector.checkCollision(bullet, enemies.getEnemiesPic())) {
                // Collision occurred, remove the bullet and the enemy
                collidedBullet();
                enemies.collidedEnemy();
                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            bullet.delete();
        }


    }

}





