package com.eonsahead.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * 
 * @author bj.brassard
 * @version 9 April 2020
 */

public class SwingPanel extends JPanel implements ActionListener {

    private final int points = 8;
    private double centerX = 0.0;
    private double centerY = 0.0;
    private final double minorRadius = 0.2;
    private final double majorRadius = 0.3;

    private double deltaX = Math.random() / 20;
    private double deltaY = Math.random() / 20;
    private double deltaAngle = 2 * Math.PI / 180;

    private Shape shape;

    private Color color = Color.red;
    private Prism prism;
    private Matrix spinner;
    
    private final Vector illumination;

    // Borrowed from Leon Tabak
    
    /**
     * Creates the whole process of printing the prism
     * and make it rotate in a 3D plane
     */
    
    public SwingPanel() {
        Timer timer = new Timer(20, this);
        timer.start();

        this.prism = new Prism(3, 0.5, 0.5);
        Matrix a = new Matrix();
        a.rotationX(Math.PI / 400);

        Matrix b = new Matrix();
        b.rotationY(Math.PI / 400);

        Matrix c = new Matrix();
        c.rotationZ(Math.PI / 400);

        this.spinner = a.multiply(b).multiply(c);

        this.illumination = (new Vector(1.0, 2.0, 3.0)).normalize();

    } // SwingPanel()

    /**
     * Grabs the wanted color
     * 
     * @return The desired color 
     */
    
    public Color getColor() {
        return this.color;
    } // getColor()

    /**
     * Sets the color to the value of c
     * 
     * @param c The desired color value
     */
    
    public void setColor(Color c) {
        this.color = c;
    } // setColor( Color )

    /**
     * Creates the prism and prints it
     * 
     * @param g The graphic matrix
     */
    
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
        double cx = 1.0;
        double cy = 1.0;
        translation.setToTranslation(cx, cy);

        transform.concatenate(scaling);
        transform.concatenate(translation);

        List<Polygon3D> faces = this.prism.getFaces();
        for (Polygon3D p : faces) {
            Shape s = transform.createTransformedShape(p.getShape());

            Vector normal = p.getNormal();
            if (normal.get(2) > 0) {
                double brightness = normal.dot(illumination);

                Color c = this.getColor();

                double ambient = 0.5;
                int red;
                int green;
                int blue;
                if (brightness > 0) {
                    red = (int) (brightness * c.getRed());
                    green = (int) (brightness * c.getGreen());
                    blue = (int) (brightness * c.getBlue());

                } // if
                else {
                    red = (int) (ambient * c.getRed());
                    green = (int) (ambient * c.getGreen());
                    blue = (int) (ambient * c.getBlue());

                } // else
                Color shade = new Color(red, green, blue);

                g2D.setColor(shade);
                g2D.fill(s);
            } // if

        } // for

    } // paintComponent( Graphics )

//    private Shape makeStar(int points,
//            double centerX, double centerY,
//            double minorRadius, double majorRadius) {
//
//        GeneralPath star = new GeneralPath();
//
//        double x = centerX + majorRadius * Math.cos(0.0);
//        double y = centerY + majorRadius * Math.sin(0.0);
//        star.moveTo(x, y);
//        for (int i = 1; i < 2 * points; i++) {
//            double fraction = ((double) i) / (2 * points);
//            double angle = 2.0 * Math.PI * fraction;
//
//            if (i % 2 == 0) {
//                x = centerX + majorRadius * Math.cos(angle);
//                y = centerY + majorRadius * Math.sin(angle);
//            } // if
//            else {
//                x = centerX + minorRadius * Math.cos(angle);
//                y = centerY + minorRadius * Math.sin(angle);
//            } // else
//            star.lineTo(x, y);
//        } // for
//        star.closePath();
//
//        return star;
//    } // makeStar()

    /**
     * Performs the movement of the prism and reprints it 
     * fast to add the animation
     * 
     * @param event The wanted movement of the prism
     */
    
    @Override
    public void actionPerformed(ActionEvent event) {

        this.prism.transform(spinner);
        this.repaint();
    } // actionPerformed( ActionEvent )

} // SwingPanel
