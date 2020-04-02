package com.eonsahead.swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Swing extends JFrame implements ActionListener {

    private final int FRAME_WIDTH = 512;
    private final int FRAME_HEIGHT = 512;
    private final String FRAME_TITLE = "Swing";
    private final int NUMBER_OF_COLORS = 10;
    private final List<Color> palette = new ArrayList<>();
    private final JPanel panel;

    public Swing() {
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle(FRAME_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = this.getContentPane();
        this.panel = new SwingPanel();
        pane.add(panel);

        Random rng = new Random();
        for (int i = 0; i < NUMBER_OF_COLORS; i++) {
            int red = 64 + rng.nextInt(128);
            int green = 64 + rng.nextInt(128);
            int blue = 64 + rng.nextInt(128);
            Color color = new Color(red, green, blue);
            palette.add(color);
        } // for
        this.panel.setBackground(palette.get(0));

        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        JMenu colorMenu = new JMenu("Color ");
        menuBar.add(colorMenu);

        for (int i = 0; i < NUMBER_OF_COLORS; i++) {
            String label = "Color " + i;
            JMenuItem item = new JMenuItem(label);
            item.addActionListener(this);
            item.setActionCommand(label);
            colorMenu.add(item);
        } // for

        this.setVisible(true);
    } // Swing()

    @Override
    public void actionPerformed(ActionEvent event) {
        String actionCommand = event.getActionCommand();
        String suffix = actionCommand.substring(5).trim();
        int index = Integer.parseInt( suffix );
        this.panel.setBackground( palette.get(index));
    } // actionPerformed( ActionEvent )

    public static void main(String[] args) {
        Swing swing = new Swing();
    } // main( String [] )

} // Swing