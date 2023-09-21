package org.academiadecodigo.GameWeek;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CollisionDetector {

    private Picture picture;
    private Picture[] pictures;
    private Enemies enemies;
    private Bullet bullet;




    public boolean checkCollision(Picture bullet, Picture[] enemy) {
        for (int i = 0; i < enemy.length; i++) {
            int bulletX = bullet.getX();
            int bulletY = bullet.getY();
            int bulletWidth = bullet.getWidth();
            int bulletHeight = bullet.getHeight();

            int enemyX = enemy[i].getX();
            int enemyY = enemy[i].getY();
            int enemyWidth = enemy[i].getWidth();
            int enemyHeight = enemy[i].getHeight();

            boolean check = bulletX + bulletWidth > enemyX &&
                    bulletX < enemyX + enemyWidth &&
                    bulletY + bulletHeight > enemyY &&
                    bulletY < enemyY + enemyHeight;


            if (check) {
                System.out.printf("Poof");
                return true;

            }
        }
        return false;
    }
}
