
package com.eonsahead.swing;

import com.eonsahead.swing.Matrix;
import com.eonsahead.swing.Vector;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;

public class Polygon3D {
    
    private final List<Vector> points = new ArrayList<>();
    
    public Polygon3D(int sides, double radius){
        for (int i = 0; i < sides; i++){
            double fraction = ((double) i) / sides;
            double angle = fraction * 2.0 * Math.PI;
            double x = radius * Math.cos(angle);
            double y = radius * Math.sin(angle);
            Vector v = new Vector(x, y, 0.0);
            this.points.add(v);
        } // for
        
    } // Polygon3D(int, double)
    
    public void transform(Matrix m){
        for(Vector u : this.points){
            u.set(m.multiply(u));
        } // for
    } // transform(Matrix)
    
    public Shape getShape(){
        GeneralPath path = new GeneralPath();
        
        Vector v = this.points.get(0);
        double x = v.get(0);
        double y = v.get(1);
        path.moveTo(x, y);
        
        for (int i = 1; i < this.points.size(); i++){
            v = this.points.get(i);
            x = v.get(0);
            y = v.get(1);
            path.lineTo(x,y);
        } // for
        path.closePath();
        return path;
    } // getShape()
    
} // Polygon3D
