/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eonsahead.swing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author bj.brassard
 * @version 8 April 2020
 */
public class VectorTest {
    
    private static final double EPSILON = 1E-8;
    
    public VectorTest() {
    } // VectorTest()
    
    /**
     * Test the get method of the Vector class
     * 
     * Should return first element of the 4D Vector
     */

    @Test
    public void testGet() {
        System.out.println("get");
        int num = 0;
        Vector instance = new Vector( 94.0, 0.0, 0.0);
        double expResult = 94.0;
        double result = instance.get(num);
        assertEquals(expResult, result, EPSILON);
    } // testGet()

    /**
     * Test Dot method of Vector class
     * 
     * Test the dot product of Vector v and u
     */
    
    @Test
    public void testDot() {
        Vector u = new Vector(0, 1, 0);
        Vector v = new Vector(1, 0, 0);
        double expResult = 0.0;
        double result = u.dot(v);
        assertEquals(expResult, result, EPSILON);
    } // testDot()

    /**
     * Test the magnitude method of the Vector class
     * 
     * Test the magnitude of the Vector instance
     */
    
    @Test
    public void testMagnitude() {
        Vector instance = new Vector(1, 0, 0);
        double expResult = 1;
        double result = instance.magnitude();
        assertEquals(expResult, result, EPSILON);
    } // testMagnitude()
    
    /**
     * Test the normalize method of the Vector Class
     * 
     * Test the normalization of the Vector (1, 0, 0)
     */

    @Test
    public void testNormalize() {
        Vector instance = new Vector(1, 0, 0);
        Vector expResult = new Vector(1, 0, 0);
        Vector result = instance.normalize();
        for(int i =0; i < 4; i++){
            assertEquals(expResult.get(i), result.get(i), EPSILON);
        } // for

    } // testNormalize()
    
    /**
     * Test the cross method of the Vector class
     * 
     * Test the two vectors v and instance
     */

    @Test
    public void testCross() {
        Vector v = new Vector(0, 1, 0);
        Vector instance = new Vector(1, 0, 0);
        Vector expResult = new Vector(0, 0, 1);
        Vector result = instance.cross(v);
        for(int i = 0; i < 4; i++){
            assertEquals(expResult.get(i), result.get(i), EPSILON);
        } // for

    } // testCross()
    
}
