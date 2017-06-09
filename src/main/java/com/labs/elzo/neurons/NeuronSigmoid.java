package com.labs.elzo.neurons;

import com.labs.elzo.math.Matrix2d;

public class NeuronSigmoid implements Neuron {
	
	@Override
	public double[][] think(double[][] input,double[][] weights) {
		double[][] dot = Matrix2d.dot(input, weights);
		return Matrix2d.sigmoid(dot);
	}

}
