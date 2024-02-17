package two.lesson.java.main.circles;

import two.lesson.java.main.common.CanvasRepaintListener;
import two.lesson.java.main.common.MainCanvas;
import two.lesson.java.main.common.SearchEngine;
import two.lesson.java.main.common.Sprite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame implements CanvasRepaintListener, SearchEngine<Sprite>, Thread.UncaughtExceptionHandler {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    public final Sprite[] sprites = new Sprite[15];

    public MainWindow() throws HeadlessException {
        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");

        sprites[0] = new Background();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1){
                    if (!insertElement(sprites,new Ball()))
                        throw new ArrayIndexOutOfBoundsException("Нельзя создать больше 15-ти шаров!");
                } else if (e.getButton() == 3){
                    removeElement(sprites);
                }
            }
        });
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
            if ( sprite!= null) sprite.update(canvas, deltaTime);
        }
    }

    public void render(MainCanvas canvas, Graphics g) {
        for (Sprite sprite : sprites) {
            if ( sprite!= null) sprite.render(canvas, g);
        }
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        JOptionPane.showMessageDialog(
                null, e.getMessage(),
                "Exception", JOptionPane.ERROR_MESSAGE);
    }
}
