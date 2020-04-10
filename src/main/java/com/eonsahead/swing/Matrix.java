package com.eonsahead.swing;

/**
 * Models a 4x4 vector
 *
 * @author Ben Brassard
 * @version 5 April 2020
 */
public class Matrix {

    private final double[][] elements;

    /**
     * Creates a 4x4 identity Matrix
     */
    public Matrix() {
        this.elements = new double[4][4];
        this.identity();
    } // Matrix()

    /**
     * Returns certain value in the element
     * 
     * @param row The row of elements
     * @param column The column of elements
     * @return The value wanted in the element
     */
    public double get(int row, int column) {
        return this.elements[row][column];
    } // get( int, int )

    /**
     * 
     * @param row The row of elements
     * @param column The column of elements
     * @param value The value of the set
     */
    public void set(int row, int column, double value) {
        this.elements[row][column] = value;
    } // set( int, int, double )

    /**
     * Sets matrix to the identity matrix
     */
    public final void identity() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    this.set(i, j, 1.0);
                } // if
                else {
                    this.set(i, j, 0.0);
                } // else
            } // for
        } // for
    } // identity()

    /**
     * Rotates around z axis by the angle given
     * 
     * @param angle The angle given to rotate
     */
    public void rotationZ(double angle) {
        this.identity();
        this.set(0, 0, Math.cos(angle));
        this.set(0, 1, Math.sin(angle));
        this.set(1, 0, -Math.sin(angle));
        this.set(1, 1, Math.cos(angle));
    } // rotationZ( double )

    /**
     * Rotates around y axis by the angle given
     * 
     * @param angle The angle given to rotate
     */
    public void rotationY(double angle) {
        this.identity();
        this.set(0, 0, Math.cos(angle));
        this.set(0, 2, -Math.sin(angle));
        this.set(2, 0, Math.sin(angle));
        this.set(2, 2, Math.cos(angle));
    } // rotationY(double)

    /**
     * Rotates around x axis by the angle given
     * 
     * @param angle The angle given to rotate
     */
    public void rotationX(double angle) {
        this.identity();
        this.set(1, 1, Math.cos(angle));
        this.set(1, 2, -Math.sin(angle));
        this.set(2, 1, Math.sin(angle));
        this.set(2, 2, Math.cos(angle));
    } // rotationX(double)

    /**
     * Adds scaling method to the matrix
     * 
     * @param xScale The x scale factor
     * @param yScale The y scale factor
     * @param zScale The z scale factor
     */
    
    public void scale(double xScale, double yScale, double zScale) {
        this.identity();
        this.set(0, 0, xScale);
        this.set(1, 1, yScale);
        this.set(2, 2, zScale);

    } // scale(double, double, double)
    
    /**
     * Adds a translation method to the matrix
     * 
     * @param deltaX Translation in x direction
     * @param deltaY Translation in y direction
     * @param deltaZ Translation in z direction
     */
   
    public void translate(double deltaX, double deltaY, double deltaZ ){
        this.identity();
        this.set(0, 3, deltaX);
        this.set(1, 3, deltaY);
        this.set(2, 3, deltaZ);
    } // translate(double, double, double)

    /**
     * Multiplies two Matrices together
     * 
     * @param otherMatrix The separate matrix to multiply with
     * @return The product
     */
    
    public Matrix multiply(Matrix otherMatrix) {
        Matrix product = new Matrix();
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                double sum = 0.0;
                for (int k = 0; k < 4; k++) {
                    sum += this.elements[row][k]
                            * otherMatrix.elements[k][column];
                } // for
                product.set(row, column, sum);
            } // for
        } // for
        return product;
    } // multiply( Matrix )
    
    /**
     * Multiply the Matrix with the Vector
     * 
     * @param vector The vector that is being multiplied
     * @return The product vector
     */
    
    public Vector multiply(Vector vector) {
        double[] vectorV = new double[4];
        for(int i = 0; i < 4; i++){
            double sum = 0.0;
            for(int k = 0; k < 4; k++){
                sum += this.get(i,k) * vector.get(k);
                
            } // for
            vectorV[i] = sum;
        } // for
        return new Vector(vectorV[0], vectorV[1], vectorV[2], vectorV[3]);
    } // multiply(Vector)

    /**
     * Prints the wanted row in string form
     * 
     * @param row The row to convert into string
     * @return The row in string form
     */
    
    private String rowToString(int row) {
        StringBuilder result = new StringBuilder();
        result.append("( ");
        for (int i = 0; i < 3; i++) {
            result.append(this.get(row, i));
            result.append(",");
        } // for
        result.append(this.get(row, 3));
        result.append(" )");
        return result.toString();
    } // rowToString( int )

    /**
     * Prints the Matrix in string form
     * 
     * @return The matrix in string form
     */
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[ ");
        for (int i = 0; i < 4; i++) {
            result.append(rowToString(i));
        } //
        result.append(" ]");
        return result.toString();
    } // toString()

    public static void main(String[] args) {
        Matrix identity = new Matrix();
        System.out.println("identity = " + identity);

        Matrix product = identity.multiply(identity);
        System.out.println("product = " + product);

        Matrix ccw = new Matrix();
        ccw.rotationZ(Math.PI / 4);
        System.out.println("counter-clockwise rotation = " + ccw);

        Matrix cw = new Matrix();
        cw.rotationZ(-Math.PI / 4);
        System.out.println("clockwise rotation = " + cw);

        Matrix netRotation = ccw.multiply(cw);
        System.out.println("net rotation = " + netRotation);
    } // main( String [] )

} // Matrix
