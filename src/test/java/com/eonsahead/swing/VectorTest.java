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
 */
public class VectorTest {
    
    public VectorTest() {
    }

    @org.junit.jupiter.api.Test
    public void testGet() {
        System.out.println("get");
        int num = 0;
        Vector instance = null;
        double expResult = 0.0;
        double result = instance.get(num);
        assertEquals(expResult, result, 0.0);
        fail("The test case is a prototype.");
    }

    @org.junit.jupiter.api.Test
    public void testDot() {
        System.out.println("dot");
        Vector v = null;
        Vector instance = null;
        double expResult = 0.0;
        double result = instance.dot(v);
        assertEquals(expResult, result, 0.0);
        fail("The test case is a prototype.");
    }

    @org.junit.jupiter.api.Test
    public void testMagnitude() {
        System.out.println("magnitude");
        Vector instance = null;
        double expResult = 0.0;
        double result = instance.magnitude();
        assertEquals(expResult, result, 0.0);
        fail("The test case is a prototype.");
    }

    @org.junit.jupiter.api.Test
    public void testNormalize() {
        System.out.println("normalize");
        Vector instance = null;
        Vector expResult = null;
        Vector result = instance.normalize();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.jupiter.api.Test
    public void testCross() {
        System.out.println("cross");
        Vector v = null;
        Vector instance = null;
        Vector expResult = null;
        Vector result = instance.cross(v);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
