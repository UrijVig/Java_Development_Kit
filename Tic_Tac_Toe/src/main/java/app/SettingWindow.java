package src.main.java.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SettingWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;
    private int gameMode, fieldSize, victoryLength;
    JButton btnStart = new JButton("Start new game");
    JPanel mainPanel = createMainPanel();
    SettingWindow(GameWindow gameWindow){
        setLocationRelativeTo(gameWindow);
        setLocation(getX() - WINDOW_WIDTH/2, getY() - WINDOW_HEIGHT/2);

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        btnStart.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                gameWindow.startNewGame(gameMode,fieldSize,fieldSize,victoryLength);
            }
        });
        add(mainPanel);
        add(btnStart, BorderLayout.SOUTH);
    }
    private JPanel createModePanel(){
        JPanel jPanel = new JPanel(new GridLayout(3,1));
        JLabel jLabel = new JLabel("Выберите режим игры! ");
        JRadioButton rb1 = new JRadioButton("Человек Против компьютера");
        JRadioButton rb2 = new JRadioButton("Человек против челвека");
        ButtonGroup bg = new ButtonGroup();
        rb1.setSelected(true);
        rb1.addActionListener(e -> gameMode = 0);
        rb2.addActionListener(e -> gameMode = 1);
        bg.add(rb1);
        bg.add(rb2);
        jPanel.add(jLabel);
        jPanel.add(rb1);
        jPanel.add(rb2);
        return jPanel;
    }
    private JPanel createFieldPanel(){
        JPanel jPanel = new JPanel(new GridLayout(3,1));
        JLabel jLabel = new JLabel("Выберите размеры поля! ");
        JSlider jSlider = new JSlider(3,10,3);
        fieldSize = 3;
        JLabel jSubLabel = new JLabel(String.format("Установленный размер поля %d", fieldSize));
        jSlider.addChangeListener(e -> {
            fieldSize = jSlider.getValue();
            jSubLabel.setText(String.format("Установленный размер поля %d", fieldSize));

        });
        jPanel.add(jLabel);
        jPanel.add(jSubLabel);
        jPanel.add(jSlider);
        return jPanel;
    }

    private JPanel createVictoryPanel(){
        JPanel jPanel = new JPanel(new GridLayout(3,1));
        JLabel jLabel = new JLabel("Выберите длинну для победы");
        JSlider jSlider = new JSlider(3,10,3);
        victoryLength = jSlider.getValue();
        JLabel jSubLabel = new JLabel(String.format("установленная длинна %d", victoryLength));
        jSlider.addChangeListener(e -> {
            victoryLength = jSlider.getValue();
            if (fieldSize < victoryLength){
                victoryLength = fieldSize;
                jSlider.setValue(victoryLength);
//                    jSlider.setMaximum(fieldSize);
            }
            jSubLabel.setText(String.format("установленная длинна %d", victoryLength));
        });
        jPanel.add(jLabel);
        jPanel.add(jSubLabel);
        jPanel.add(jSlider);
        return jPanel;
    }

    private JPanel createMainPanel(){
        JPanel mainPanel = new JPanel(new GridLayout(3,1));
        mainPanel.add(createModePanel());
        mainPanel.add(createFieldPanel());
        mainPanel.add(createVictoryPanel());
        return  mainPanel;
    }
}
