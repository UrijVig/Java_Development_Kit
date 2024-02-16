package two.lesson.java.main.circles;

import two.lesson.java.main.common.CanvasRepaintListener;
import two.lesson.java.main.common.MainCanvas;
import two.lesson.java.main.common.Sprite;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame implements CanvasRepaintListener {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    public final Sprite[] sprites = new Sprite[10];

    public MainWindow() throws HeadlessException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");

        sprites[0] = new Background();
        for (int i = 1; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }

        MainCanvas canvas = new MainCanvas(this);
        add(canvas);

        setVisible(true);
    }
    public static void main(String[] args) {
        new MainWindow();
    }

    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    public void update(MainCanvas canvas, float deltaTime) {
        for (Sprite sprite : sprites) {
            sprite.update(canvas, deltaTime);
        }
    }

    public void render(MainCanvas canvas, Graphics g) {
        for (Sprite sprite : sprites) {
            sprite.render(canvas, g);
        }
    }
}
