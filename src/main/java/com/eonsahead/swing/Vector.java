
package com.eonsahead.swing;


public class Vector {
    
    private double x;
    private double y;
    private double z;
   
    
    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        
    } // Vector(double, double, double
    
    public double get( int value) {
        value = 0;
        if (value == 0){
            return this.x;
        } // if
        else if (value == 1){
            return this.y;
        } // else if
        else if (value == 2){
            return this.z;
        } // else if
        // else (value == 3){
        
       // } // else
       return value;
    } // get(int)
    
        public double dot( Vector v ) {
        double xP = this.x * v.x;
        double yP = this.y * v.y;
        double zP = this.z * v.z;
        return xP + yP + zP;
    } // dot( Vector2D )
} // Vector
