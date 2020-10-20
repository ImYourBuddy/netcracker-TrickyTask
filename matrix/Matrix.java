package ru.netcracker.edu.karpov.matrix;

/**
 * Class describing a matrix as an entity
 */
public class Matrix {
    private double[][] matrix;

    public Matrix() {

    }

    /**
     * Create a new zero initialized matrix
     *
     * @param a number of rows
     * @param b number of columns
     */
    public Matrix(int a, int b) {
        this.matrix = new double[a][b];
    }

    /**
     * @return The current matrix
     * @throws IllegalStateException If no matrix is specified
     */
    public double[][] getMatrix() throws IllegalStateException {
        if (this.matrix == null) {
            throw new IllegalStateException();
        } else
            return this.matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * Create a new zero initialized matrix if default constructor was used
     *
     * @param a number of rows
     * @param b number of columns
     */
    public void create(int a, int b) {
        this.matrix = new double[a][b];
    }

    /**
     *
     * @return
     * @throws IllegalStateException If no matrix is specified
     */
    public boolean isEmpty () throws IllegalStateException{
        if (this.matrix == null) {
            throw new IllegalStateException();
        }
        boolean isEmpty = false;
        if (this.matrix.length == 0 || this.matrix[0].length == 0) {
            isEmpty = true;
        }
        return isEmpty;
    }

    /**
     * Copies elements of matrix <code>matrix</code>. If the current matrix isn't specified or has a different dimension,
     * then a new matrix of the required dimension is created.
     * @param matrix
     */
    public void clone(double[][] matrix) {
        if (this.matrix == null || this.matrix.length != matrix.length || this.matrix[0].length != matrix.length) {
            this.matrix = new double[matrix.length][matrix[0].length];
        }
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                this.matrix[i][j] = matrix[i][j];
    }


}
