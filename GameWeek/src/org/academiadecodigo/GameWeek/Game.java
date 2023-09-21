package org.academiadecodigo.GameWeek;

public class Game {
    private Ship ship;
    private Enemies enemies;
    private Bullet bullet;

    private CollisionDetector collisionDetector;



    public Game() {
        ship = new Ship();
        enemies = new Enemies();
        bullet = null;
        collisionDetector = new CollisionDetector();
    }

    public void start() {
        while (true) {
            if (bullet != null) {
                if (collisionDetector.checkCollision(bullet.getBulletPic(), enemies.getEnemiesPic())) {
                    enemies.collidedEnemy();
                    bullet.collidedBullet();
                    bullet = null;

                }
                }
            }

        }
    }


