package it.unibo.es3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

/**
 * GUI for the game.
 */
public final class GUI extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;
    private final List<JButton> cells = new ArrayList<>();
    private final Logics logics;
    private Pair<Integer, Integer> buttonPosition;

    /**
     * Constructor.
     *
     * @param width the size of the grid
     */
    public GUI(final int width) {
        this.logics = new LogicsImpl(width);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        final JPanel panel = new JPanel(new BorderLayout());
        final JPanel panelDown = new JPanel(new BorderLayout());
        // Create a panel with a grid layout
        this.getContentPane().add(panel);
        final JPanel panelUp = new JPanel(new GridLayout(width, width));
        panel.add(panelUp, BorderLayout.CENTER);
        panel.add(panelDown, BorderLayout.SOUTH);
        // Create buttons and add them to the panel
        final JButton hitButton = new JButton(">");
        panelDown.add(hitButton, BorderLayout.SOUTH);
        // hitButton.addActionListener(e -> {
        //     if (logics.toQuit()) {
        //         dispose();
        //     }
        // });
        //creo la griglia vuota
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                final var pos = new Pair<>(j, i);
                final JButton button = new JButton(" ");
                this.cells.add(button);
                panelUp.add(button);
            }
        }
        //genero i tre *
        for (int i = 0; i < 3; i++){
            buttonPosition = logics.random();
            int index = buttonPosition.y()*10 + buttonPosition.x();
            this.cells.get(index).setText(logics.star(buttonPosition));
        }
        hitButton.addActionListener(e -> {
            if(logics.toQuit()){
                dispose();
            } else {
                List<Pair<Integer, Integer>> listPosition = new ArrayList<>();
                listPosition = logics.fill();
                for (Pair<Integer, Integer> pair : listPosition){
                    int index = pair.y()*10 + pair.x();
                    this.cells.get(index).setText(logics.star(pair));
                }
            }
        });
        pack();
        this.setVisible(true);
    }
}
