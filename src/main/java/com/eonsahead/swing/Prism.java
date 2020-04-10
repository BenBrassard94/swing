package com.eonsahead.swing;

import java.util.ArrayList;
import java.util.List;

public class Prism {

    private final List<Polygon3D> faces;
    private final List<Vector> points;

    /**
     * Creates the prism
     * 
     * @param sides The number of the sides
     * @param radius The radius of the prism
     * @param height The height of the prism
     */
    
    public Prism(int sides, double radius, double height) {
        this.faces = new ArrayList<>();
        this.points = new ArrayList<>();

        double z = height / 2;
        int mode = Polygon3D.CCW;
        Polygon3D top = new Polygon3D(sides, radius, z, mode);

        z = -height / 2;
        mode = Polygon3D.CW;
        Polygon3D bottom = new Polygon3D(sides, radius, z, mode);

        this.faces.add(top);
        this.faces.add(bottom);
        this.faces.addAll(top.makeSleeve(bottom));

        this.points.addAll(top.getVertices());
        this.points.addAll(bottom.getVertices());
    } // Prism()

    /**
     * Multiplies the matrix and the vector
     * 
     * @param m The matrix to be multiplied with
     */
    
    public void transform(Matrix m) {
        for (Vector u : this.points) {
            u.set(m.multiply(u));
        } // for 
    } // transform( Matrix )

    /**
     * Grabs the faces from the system
     * 
     * @return The faces of the prism
     */
    
    public List<Polygon3D> getFaces() {
        return this.faces;
    } // getFaces()

} // Prism
