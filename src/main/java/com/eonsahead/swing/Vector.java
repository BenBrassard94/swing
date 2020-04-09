package com.eonsahead.swing;

/**
 * Models a 4 component vector that will be used to model a 3D 
 * object.
 * 
 * @author bj.brassard
 * @version 5 April 2020
 */

public class Vector {

    /**
     * Each  variable is self explanatory but h is the homogeneous 
     */
    
    private double x;
    private double y;
    private double z;
    private double h;

    /**
     * Constructor that sets x, y, and z components to the vector
     * The homogeneous is set to 1.
     * 
     * @param x The x component of the vector
     * @param y The y component of the vector
     * @param z The z component of the vector
     */
    
    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.h = 1.0;

    } // Vector(double, double, double)

    /**
     * Constructor that accepts all four parameters of the vector
     * 
     * @param x The x component of the vector
     * @param y The y component of the vector
     * @param z The z component of the vector
     * @param h The homogeneous component of the vector
     */
    
    public Vector(double x, double y, double z, double h) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.h = h;

    } // Vector(double, double, double, double)

    /**
     * Returns the given component of the vector
     * 
     * @param num The component that will be returned
     * @return The vector component
     */
    
    public double get(int num) {
        switch (num) {
            case 0:
                return this.x;
            case 1:
                return this.y;
            case 2:
                return this.z;
            case 3:
                return this.h;
            default:
                return this.x;

        } // switch
    } // get()

    /**
     * Multiply components of the vector with another vector
     * 
     * @param v The other vector
     * @return The dot product
     */
    
    public double dot(Vector v) {
        double xP = this.get(0) * v.get(0);
        double yP = this.get(1) * v.get(1);
        double zP = this.get(2) * v.get(2);
        double hP = this.get(3) * v.get(3);
        return xP + yP + zP + hP;

    } // dot(Vector)

    /**
     * Returns the magnitude of the given vector
     * 
     * @return The magnitude of the vector
     */
    
    public double magnitude() {
        return Math.sqrt(this.dot(this));
    } // magnitude()

    /**
     * Normalizes the vector
     * 
     * @return The normalized vector
     */
    
    public Vector normalize() {
        double m = this.magnitude();
        return new Vector(this.get(0) / m, this.get(1) / m, this.get(2) / m,
                this.get(3) / m);
    } // normalize()
    
    /** 
     * Cross product between two vectors
     * 
     * @param v The other vector
     * @return The cross multiplied vectors
     */
    
    public Vector cross(Vector v){
        double xC = this.get(1) * v.get(2) - this.get(2) * v.get(1);
        double yC = this.get(2) * v.get(0) - this.get(0) * v.get(2);
        double zC = this.get(0) * v.get(1) - this.get(1) * v.get(0);
        return new Vector(xC, yC, zC);
        
    } // cross(Vector)
    
    public void set(Vector v){
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
        this.h = v.h;
        
    } // set(Vector)
} // Vector
