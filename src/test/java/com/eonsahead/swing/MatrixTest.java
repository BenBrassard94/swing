package com.eonsahead.swing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author bj.brassard
 * @version 8 April 2020
 */
public class MatrixTest {

    public MatrixTest() {
    }

    /**
     * Test the get method of Matrix
     *
     * Test retrieval of the element in the last row and last column
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int row = 0;
        int column = 0;
        Matrix instance = new Matrix();
        double expResult = 1.0;
        double result = instance.get(row, column);
        assertEquals(expResult, result, 1E-8);

    } // testGet()

    /**
     * Test the set method of the Matrix class
     *
     * Test setting 1 to the first row and first column
     */
    @Test
    public void testSet() {
        System.out.println("set");
        int row = 0;
        int column = 0;
        double value = 1;
        Matrix instance = new Matrix();
        double expresult = 1;
        instance.set(row, column, value);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 0 && j == 0) {
                    assertEquals(instance.get(i, j), expresult);
                }// if
                else if (i == j) {
                    assertEquals(instance.get(i, j), 1);
                }// else if
                else {
                    assertEquals(instance.get(i, j), 0);
                }// else
            }// for
        }// for

    } // testSet

    /**
     * Test identity method of the Matrix class
     *
     * Test conversions with first row of elements (1,2,3,4)
     */
    
    @Test
    public void testIdentity() {
        System.out.println("identity");
        Matrix instance = new Matrix();
        instance.set(0, 0, 1);
        instance.set(0, 1, 2);
        instance.set(0, 2, 3);
        instance.set(0, 3, 4);
        instance.identity();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    assertEquals(instance.get(i, j), 1);
                } // if
                else {
                    assertEquals(instance.get(i, j), 0);
                } // else
            } // for
        } // for
    } // testIdentity()
    
    /** 
     * Test the rotationZ method of the Matrix class
     * 
     * Test with an angle of 2 PI radians
     */

    @Test
    public void testRotationZ() {
        System.out.println("rotateZ");
        double angle = 2 * Math.PI;
        Matrix instance = new Matrix();
        instance.rotateZ(angle);
        Matrix expResult = new Matrix();
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(instance.get(i, j), expResult.get(i, j), 1E-8);
            }// for
        }// for
    } // testRotationZ()
    
    /**
     * Test the rotateY method of the Matrix class
     * 
     * Test with an angle of 2 PI radians
     */

    @Test
    public void testRotationY() {
        System.out.println("rotateY");
        double angle = 2 * Math.PI;
        Matrix instance = new Matrix();
        instance.rotateY(angle);
        Matrix expResult = new Matrix();
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(instance.get(i, j), expResult.get(i, j), 1E-8);
            }// for
        }// for
    } // testRotateY()
    
    /**
     * Test the rotateX method in the Matrix class
     * 
     * Test with an angle of 2 PI radians
     */

    @Test
    public void testRotationX() {
        System.out.println("rotateX");
        double angle = 2 * Math.PI;
        Matrix instance = new Matrix();
        instance.rotateX(angle);
        Matrix expResult = new Matrix();
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(instance.get(i, j), expResult.get(i, j), 1E-8);
            }// for
        }// for
    } // testRotationX()
    
    /**
     * Test the scale method of the Matrix class
     *
     */

    @Test
    public void testScale() {
        System.out.println("scale");
        double xScale = 0.0;
        double yScale = 0.0;
        double zScale = 0.0;
        Matrix instance = new Matrix();
        instance.scale(xScale, yScale, zScale);
        fail("The test case is a prototype.");
    }

    @Test
    public void testTranslate() {
        System.out.println("translate");
        double deltaX = 0.0;
        double deltaY = 0.0;
        double deltaZ = 0.0;
        Matrix instance = new Matrix();
        instance.translate(deltaX, deltaY, deltaZ);
        fail("The test case is a prototype.");
    }

    @Test
    public void testMultiply_Matrix() {
        System.out.println("multiply");
        Matrix otherMatrix = null;
        Matrix instance = new Matrix();
        Matrix expResult = null;
        Matrix result = instance.multiply(otherMatrix);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testMultiply_Vector() {
        System.out.println("multiply");
        Vector vector = null;
        Matrix instance = new Matrix();
        Vector expResult = null;
        Vector result = instance.multiply(vector);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Matrix instance = new Matrix();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Matrix.main(args);
        fail("The test case is a prototype.");
    }

}
