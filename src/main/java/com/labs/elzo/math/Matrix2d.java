package com.labs.elzo.math;

public class Matrix2d {
	public static double[][] tahn(double [][] a)
	{
		return a;
		
	}
	
	public static double[][] add(double[][] a, double[][] b) {
		int rows = a.length;
		int columns = a[0].length;
		double[][] result = new double[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				result[i][j] = a[i][j] + b[i][j];
			}
		}
		return result;
	}
	
	public static double[][] subtract(double[][] a, double[][] b) {
		int rows = a.length;
		int columns = a[0].length;
		double[][] result = new double[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				result[i][j] = a[i][j] - b[j][i];
			}
		}
		return result;
	}

	public static double[][] multiply(double[][] a, double[][] b) {
		int aRows = a.length;
		int aCols = a[0].length;
		int bRows = b.length;
		int bCols = b[0].length;

		if (aCols != bRows) {
			throw new IllegalArgumentException("A:cols: " + a[0].length + " did not match B:rows " + b.length + ".");
		}

		double[][] c = new double[aCols][aRows];

		for (int i = 0; i < aRows; i++) {
			for (int j = 0; j < aCols; j++) {
				c[j][i] = a[i][j] * b[j][i];
			}
		}

		return c;
	}

	public static double[][] transposeMatrix(double[][] x) {
		int rows = x.length;
		int cols = x[0].length;
		double[][] c = new double[cols][rows];

		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				c[j][i] = x[i][j];
		return c;
	}

	public static double[][] dot(double[][] a, double[][] b) {
		int aRows = a.length;
		int aCols = a[0].length;
		int bRows = b.length;
		int bCols = b[0].length;

		if (aCols != bRows) {
			throw new IllegalArgumentException("A:cols: " + a[0].length + " did not match B:rows " + b.length + ".");
		}

		double[][] c = new double[aRows][bCols];

		for (int i = 0; i < aRows; i++) {
			for (int j = 0; j < bCols; j++) {
				for (int k = 0; k < aCols; k++) {
					c[i][j] += ((a[i][k]) * b[k][j]);
				}
			}
		}

		return c;
	}
	
	public static double[][] sigmoidDerivative(double[][] x) {
		int rows = x.length;
		int cols = x[0].length;
		double[][] c = new double[rows][cols];
		for (int j = 0; j < rows; j++) {
			for (int k = 0; k < cols; k++) {
				c[j][k] = sigmoidDerivative(x[j][k]);
			}
		}
		return c;
	}

	private static double sigmoidDerivative(double x) {
		return x * (1 - x);
	}

	public static double[][] sigmoid(double[][] x) {
		int rows = x.length;
		int cols = x[0].length;
		double[][] c = new double[rows][cols];
		for (int j = 0; j < rows; j++) {
			for (int k = 0; k < cols; k++) {
				c[j][k] = sigmoid(x[j][k]);
			}
		}
		return c;
	}

	private static double sigmoid(double x) {
		return 1 / (1 + Math.exp(-x));
	}
}
