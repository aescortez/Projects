package org.academiadecodigo.GameWeek;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Screen {

    private Rectangle rectangle;
    private Picture picture;
    private int width = 500;
    private int length = 800;
    private int PADDING = 10;

    public Screen() {
        picture = new Picture(10, 10, "resources/fundospace.jpg");
        picture.draw();

        rectangle = new Rectangle(PADDING, PADDING, width, length);
        rectangle.setColor(Color.BLUE);
        rectangle.draw();

    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

}

