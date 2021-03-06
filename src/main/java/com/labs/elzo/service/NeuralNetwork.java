package com.labs.elzo.service;
import java.util.Random;

import com.labs.elzo.math.Matrix2d;
import com.labs.elzo.neurons.Neuron;
import com.labs.elzo.neurons.NeuronSigmoid;

public class NeuralNetwork {
	long seed;
	Random rand;
	double[][] weights;
	double[][] input;
	double[][] output;

	public NeuralNetwork(int inputs, int outputs) {
		rand = new Random();
		seed = rand.nextInt();
		rand = new Random(seed);
		weightMatrixGen(inputs, inputs);
	}

	public NeuralNetwork(long seed, int inputs, int outputs) {
		this.seed = seed;
		rand = new Random();
		 weights = weightMatrixGen(inputs, outputs);
	}
	
	

	private double[][] weightMatrixGen(int x, int y) {
		double[][] matrix = new double[x][y];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = 2 * rand.nextDouble() - 1;
			}
		}
		return matrix;
	}

	public void train(int iterations) {
		// for iteration in xrange(number_of_training_iterations)
		Neuron n = new NeuronSigmoid();
		
		for (int i = 0; i < iterations; i++) {
			System.out.print("Epoch: " +(i+1));
			double[][] localOutput = n.think(this.input,this.weights);

			double[][] error = Matrix2d.subtract(output, localOutput);
			System.out.print(" Error: "+calcOverallError(error));
			double[][] sigDeriv = Matrix2d.sigmoidDerivative(localOutput);
			double[][] prod = Matrix2d.multiply(error, sigDeriv);
			double[][] transInput = Matrix2d.transposeMatrix(input);
			double[][] adjustment = Matrix2d.dot(transInput, prod);

			weights = Matrix2d.add(adjustment, weights);
			System.out.println("");
		}
	}
	
	public double[][] predict(double[][] input)
	{
		Neuron n = new NeuronSigmoid();
		double[][] output = n.think(input,this.weights);
		
		return output;
	}
	
	
	public double calcOverallError(double[][] errors)
    {
		double RMSerror = 0.0;
     
	    for(int i = 0;i<errors.length;i++)
	    {
	    	for (int j=0; j<errors[0].length;j++)
		 	RMSerror = RMSerror + (errors[i][j] * errors[i][j]);
	    }
	     RMSerror = RMSerror/errors.length;
	     RMSerror = java.lang.Math.sqrt(RMSerror);
	     return RMSerror;
    }

	
	public long getSeed() {
		return seed;
	}

	public NeuralNetwork setSeed(long seed) {
		this.seed = seed;
		return this;
	}

	public Random getRand() {
		return rand;
	}

	public NeuralNetwork setRand(Random rand) {
		this.rand = rand;
		return this;
	}

	public double[][] getInput() {
		return input;
	}

	public NeuralNetwork setInput(double[][] input) {
		this.input = input;
		return this;
	}

	public double[][] getOutput() {
		return output;
	}

	public NeuralNetwork setOutput(double[][] output) {
		this.output = output;
		return this;
	}
	
	public double[][] getWeights() {
		return weights;
	}

	public NeuralNetwork setWeights(double[][] weights) {
		this.weights = weights;
		return this;
	}
}
