package com.labs.elzo.nurons;

import com.labs.elzo.math.Matrix2d;

public class NuronSigmoid implements Nuron {
	
	@Override
	public double[][] think(double[][] input,double[][] weights) {
		double[][] dot = Matrix2d.dot(input, weights);
		return Matrix2d.sigmoid(dot);
	}

}
