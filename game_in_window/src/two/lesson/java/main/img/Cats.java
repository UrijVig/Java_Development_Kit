package two.lesson.java.main.img;

import two.lesson.java.main.common.MainCanvas;
import two.lesson.java.main.common.Sprite;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Cats extends Sprite {
    private static final Random rnd = new Random();
    private final Color color;
    private float vX, vY;
    private Image img;

    public Cats() {
        halfHeight = 20 + (float) (Math.random() * 50f);
        halfWidth = halfHeight;
        color = new Color(rnd.nextInt());
        vX = 100f + (float) (Math.random() * 200f);
        vY = 100f + (float) (Math.random() * 200f);
        img = new ImageIcon("./src/two/lesson/java/main/img/cat.png").getImage();
    }

    @Override
    public void render(MainCanvas canvas, Graphics g) {
        g.setColor(color);
        g.drawImage( img,(int) getLeft(), (int) getTop(), (int) getWidth(), (int) getWHeight(), null);
    }

    @Override
    public void update(MainCanvas canvas, float deltaTime) {
        x += vX * deltaTime / 2;
        y += vY * deltaTime / 2;

        if (getLeft() < canvas.getLeft()) {
            setLeft(canvas.getLeft());
            vX = -vX;
        }
        if (getRight() > canvas.getRight()) {
            setRight(canvas.getRight());
            vX = -vX;
        }
        if (getTop() < canvas.getTop()) {
            setTop(canvas.getTop());
            vY = -vY;
        }
        if (getBottom() > canvas.getBottom()) {
            setBottom(canvas.getBottom());
            vY = -vY;
        }
    }
}
