package com.eonsahead.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SwingPanel extends JPanel implements ActionListener {

    private double centerX = 0.0;
    private double centerY = 0.0;
    private double radius = 0.5;
    private final double[] direction = new double[2];
    private Color color = Color.red;
    private String shapeDraw = "Circle";
    Random rng = new Random();

    public SwingPanel() {
        Timer timer = new Timer(50, this);
        timer.start();
        direction[0] = 0.01 + (rng.nextDouble() / 30);
        direction[1] = 0.01 + (rng.nextDouble() / 30);
    } // SwingPanel()

    public double getCenterX() {
        return this.centerX;
    } // getCenterX()

    public void setCenterX(double x) {
        this.centerX = x;
    } // setCenterX( double )

    public double getCenterY() {
        return this.centerY;
    } // getCenterY()

    public void setCenterY(double y) {
        this.centerY = y;
    } // setCenterY( double )

    public double getRadius() {
        return this.radius;
    } // getRadius()

    public void setRadius(double r) {
        this.radius = r;
    } // setRadius( double )

    public Color getColor() {
        return this.color;
    } // getColor()

    public void setColor(Color c) {
        this.color = c;
    } // setColor( Color )

    public void setShape(String s) {
        this.shapeDraw = s;
    } // setShape(String)

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        int w = this.getWidth();
        int h = this.getHeight();

        AffineTransform transform = new AffineTransform();
        AffineTransform scaling = new AffineTransform();
        scaling.setToScale(w / 2, h / 2);
        AffineTransform translation = new AffineTransform();
        translation.setToTranslation(1.0, 1.0);

        transform.concatenate(scaling);
        transform.concatenate(translation);

        if (shapeDraw == "Circle") {
            double d = 2 * this.radius;
            double ulx = this.centerX;
            double uly = this.centerY;
            Ellipse2D.Double circle = new Ellipse2D.Double(ulx, uly, d, d);
            Shape shape = transform.createTransformedShape(circle);
            g2D.setColor(Color.red);
            g2D.fill(shape);
        } // if

    } // paintComponent( Graphics )

    @Override
    public void actionPerformed(ActionEvent event) {

        this.centerY = this.centerY + (direction[0]);
        this.centerX = this.centerX + (direction[1]);
        if (Math.abs(this.centerY + radius) > 1) {
            direction[0] = -direction[0];
        } // if
        if (Math.abs(this.centerX + radius) > 1) {
            direction[1] = -direction[1];
        } // if

        this.repaint();
    } // actionPerformed( ActionEvent )
    
    public static void main(String[] args){
        System.out.println("Color");
    } // main

} // SwingPanel
