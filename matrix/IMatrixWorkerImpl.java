package ru.netcracker.edu.karpov.matrix;

import ru.netcracker.edu.karpov.matrix.IMatrixWorker;

public class IMatrixWorkerImpl implements IMatrixWorker {
    @Override
    public void print(double[][] m) throws IllegalArgumentException {
        if (m.length == 0 || m[0].length == 0) {
            throw new IllegalArgumentException("Matrix is empty");
        }
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.printf("%7.1f", m[i][j]);
            }
            System.out.println();
        }
    }

    @Override
    public boolean haveSameDimension(double[][] m1, double[][] m2) throws IllegalArgumentException {
        if (m1.length == 0 || m1[0].length == 0 || m2.length == 0 || m2[0].length == 0) {
            throw new IllegalArgumentException("One of the matrices is empty");
        }
        if (m1.length == m2.length && m1[0].length == m2[0].length) {
            return true;
        } else
            return false;
    }

    @Override
    public double[][] add(double[][] m1, double[][] m2) throws IllegalArgumentException {
        if (m1.length == 0 || m1[0].length == 0 || m2.length == 0 || m2[0].length == 0) {
            throw new IllegalArgumentException("One of the matrices is empty");
        }
        if (!this.haveSameDimension(m1, m2)) {
            throw new IllegalArgumentException("Matrices have different dimensions");
        }
        double[][] result = new double[m1.length][m1[0].length];
        for (int i = 0; i < m1.length; i++)
            for (int j = 0; j < m1[0].length; j++)
                result[i][j] = m1[i][j] + m2[i][j];
        return result;
    }

    @Override
    public double[][] subtract(double[][] m1, double[][] m2) throws IllegalArgumentException {
        if (m1.length == 0 || m1[0].length == 0 || m2.length == 0 || m2[0].length == 0) {
            throw new IllegalArgumentException("One of the matrices is empty");
        }
        if (!this.haveSameDimension(m1, m2)) {
            throw new IllegalArgumentException("Matrices have different dimensions");
        }
        double[][] result = new double[m1.length][m1[0].length];
        for (int i = 0; i < m1.length; i++)
            for (int j = 0; j < m1[0].length; j++)
                result[i][j] = m1[i][j] - m2[i][j];
        return result;
    }

    @Override
    public double[][] multiply(double[][] m1, double[][] m2) throws IllegalArgumentException {
        if (m1.length == 0 || m1[0].length == 0 || m2.length == 0 || m2[0].length == 0) {
            throw new IllegalArgumentException("One of the matrices is empty");
        }
        if (m1[0].length != m2.length) {
            throw new IllegalArgumentException("The number of columns of first matrix is different from the number of rows of second matrix");
        }
        double[][] result = new double[m1.length][m2[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                for (int k = 0; k < m1[0].length; k++)
                    result[i][j] += m1[i][k] * m2[k][j];
            }
        }
        return result;
    }

    @Override
    public double determinant(double[][] m1) throws IllegalArgumentException {
        if (m1.length == 0 || m1[0].length == 0) {
            throw new IllegalArgumentException("Matrix is empty");
        }
        if (m1.length != m1[0].length) {
            throw new IllegalArgumentException("Matrix isn't square");
        }
        int size = m1.length;
        double det = 0;
        if (size == 1) {
            det = m1[0][0];
        } else {
            for (int i = 0; i < size; i++) {
                double[][] m2 = new double[size - 1][size - 1];
                for (int j = 1; j < size; j++) {
                    int l = 0;
                    for (int k = 0; k < size; k++) {
                        if (k == i)
                            continue;
                        m2[j - 1][l] = m1[j][k];
                        l++;
                    }
                }
                det += Math.pow(-1, 1 + i + 1) * m1[0][i] * determinant(m2);
            }
        }
        return det;
    }
}
