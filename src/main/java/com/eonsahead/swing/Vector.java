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
    
    public double get(int num){
        switch (num){
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

    
} // Vector
