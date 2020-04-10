package com.eonsahead.swing;

import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * 
 * @author bj.brassard
 * @version 9 April 2020
 */

public class Swing extends JFrame {

    private final int FRAME_WIDTH = 700;
    private final int FRAME_HEIGHT = 700;
    private final String FRAME_TITLE = "Graded Assignment 1";
    private final int NUMBER_OF_COLORS = 12;
    private final String BG_COLOR = "Background Color";
    private final String FG_COLOR = "Shape Color";

    private final List<Color> bgPalette = new ArrayList<>();
    private final List<Color> sPalette = new ArrayList<>();
    private final SwingPanel panel;
    private final Random rng = new Random();

    /**
     * Creates the window and the menus for the project
     */
    
    public Swing() {
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle(FRAME_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = this.getContentPane();
        this.panel = new SwingPanel();
        pane.add(panel);

        for (int i = 0; i < NUMBER_OF_COLORS; i++) {
            Color color = makeColor(32, 224);
            bgPalette.add(color);

        } // for
        this.panel.setBackground(bgPalette.get(0));

        for (int i = 0; i < NUMBER_OF_COLORS; i++) {
            Color color = makeColor(32, 224);
            sPalette.add(color);

        } // for
        this.panel.setColor(sPalette.get(0));

        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        JMenu bgColorMenu = new JMenu(BG_COLOR);
        menuBar.add(bgColorMenu);

        MenuListener bgListener = new MenuListener(MenuListener.BG_MODE,
                this.BG_COLOR, this.bgPalette, this.panel);

        for (int i = 0; i < NUMBER_OF_COLORS; i++) {
            makeMenuItem(BG_COLOR, i, bgListener, bgColorMenu);

        } // for

        JMenu fgColorMenu = new JMenu(FG_COLOR);
        menuBar.add(fgColorMenu);

        MenuListener fgListener = new MenuListener(MenuListener.FG_MODE,
                this.FG_COLOR, this.sPalette, this.panel);

        for (int i = 0; i < NUMBER_OF_COLORS; i++) {
            makeMenuItem(FG_COLOR, i, fgListener, fgColorMenu);
        } // for
        this.setVisible(true);

    } // Swing()
    
    /**
     * Made to refractor the code and make the color method 
     * cleaner above
     * 
     * @param low The lowest color sequence
     * @param high The highest color sequence
     * @return The newest color
     */

    public final Color makeColor(int low, int high) {
        int red = low + this.rng.nextInt(high);
        int green = low + this.rng.nextInt(high);
        int blue = low + this.rng.nextInt(high);
        Color color = new Color(red, green, blue);
        return color;
    } // makeColor(int, int)
    
    /**
     * Creates menus above in cleaner code, also a refractor
     * 
     * @param prefix The start of the string
     * @param index The end of the string
     * @param listener The listener of the certain menu
     * @param menu The menu that is being created
     */

    public final void makeMenuItem(String prefix, int index,
            MenuListener listener, JMenu menu) {
        String label = prefix + " " + index;
        JMenuItem item = new JMenuItem(label);
        item.addActionListener(listener);
        item.setActionCommand(label);
        menu.add(item);

    } // makeMenuItem

    public static void main(String[] args) {
        Swing swing = new Swing();
    } // main

} // Swing
