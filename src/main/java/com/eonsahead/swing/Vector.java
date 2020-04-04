package com.eonsahead.swing;

public class Vector {

    private double x;
    private double y;
    private double z;
    private double h;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.h = 1.0;

    } // Vector(double, double, double)

    public Vector(double x, double y, double z, double h) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.h = h;

    } // Vector(double, double, double, double)

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

    public double dot(Vector v) {
        double xP = this.get(0) * v.get(0);
        double yP = this.get(1) * v.get(1);
        double zP = this.get(2) * v.get(2);
        double hP = this.get(3) * v.get(3);
        return xP + yP + zP + hP;

    } // dot(Vector)

    public double magnitude() {
        return Math.sqrt(this.dot(this));
    } // magnitude()

    public Vector normalize() {
        double m = this.magnitude();
        return new Vector(this.get(0) / m, this.get(1) / m, this.get(2) / m,
                this.get(3) / m);
    } // normalize()
    
    public Vector cross(Vector v){
        double xC = this.get(1) * v.get(2) - this.get(2) * v.get(1);
        double yC = this.get(2) * v.get(0) - this.get(0) * v.get(2);
        double zC = this.get(0) * v.get(1) - this.get(1) * v.get(0);
        return new Vector(xC, yC, zC);
        
    } // cross(Vector)
} // Vector
