package net.joshuabrandes.primes.control;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MatrixHandler {

    public static final int MULTIPLICATION_LIMIT = 40;
    private final Random random = new Random();

    private double[][] generateMatrix(int size) {
        var matrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextDouble() * 1000;
            }
        }

        return matrix;
    }

    private double[][] multiplyMatrix(double[][] matrix1, double[][] matrix2) {
        // assume square and the same size
        var n = matrix1.length;
        var result = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                var sum = 0.0;
                for (int k = 0; k < n; k++) {
                    sum += matrix1[i][k] * matrix2[k][j];
                }
                result[i][j] = sum;
            }
        }

        return result;
    }

    private double reduceMatrix(double[][] matrix) {
        var sum = 0.0;
        for (double[] doubles : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                sum += doubles[j];
            }
        }

        return sum;
    }

    public double matrixStressTest(int size) {
        var matrix1 = generateMatrix(size);
        var matrix2 = generateMatrix(size);

        var multResult = matrix1;

        for (int i = 0; i < MULTIPLICATION_LIMIT; i++) {
            multResult = multiplyMatrix(multResult, matrix2);
        }

        return reduceMatrix(multResult);
    }

}
