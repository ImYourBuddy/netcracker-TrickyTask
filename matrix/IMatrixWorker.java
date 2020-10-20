package ru.netcracker.edu.karpov.matrix;

/**
 * @author Alexander Karpov
 */

public interface IMatrixWorker {
    /**
     * Prints matrix <code>m</code>
     * @param m Matrix
     * @throws IllegalArgumentException if matrix is empty
     */
    public void print(double[][] m);

    /**
     * Comparison of the dimensions of matrices
     * @param m1
     * @param m2
     * @return Returns true if matrices have the same dimension
     * @throws IllegalArgumentException if any matrix is empty
     */
    public boolean haveSameDimension(double[][] m1, double[][] m2);

    /**
     * Adds 2 matrices
     * @param m1
     * @param m2
     * @return Matrix addition result
     * @throws IllegalArgumentException if matrices have different dimensions or any matrix is empty
     */
    public double[][] add(double[][] m1, double[][] m2);

    /**
     *  Subtracts matrix <code>m2</code> from matrix <code>m1</code>
     * @param m1
     * @param m2
     * @return Subtraction result
     * @throws IllegalArgumentException if matrices have different dimensions or any matrix is empty
     */
    public double[][] subtract(double[][] m1, double[][] m2);

    /**
     * Multiplies matrix <code>m1</code> by matrix <code>m2</code>
     * @param m1
     * @param m2
     * @return Result of matrix multiplication
     * @throws IllegalArgumentException if the number of columns of <code>m1</code> matrix is different from the number
     * of rows of <code>m2</code> matrix or any matrix is empty
     */
    public double[][] multiply(double[][] m1, double[][] m2);

    /**
     * Calculates the determinant of matrix <code>m1</code>
     * @param m1
     * @return determinant of matrix
     * @throws IllegalArgumentException if matrix is not square or matrix is empty
     */
    public double determinant(double[][] m1);

}
