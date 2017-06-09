package com.labs.elzo.service;

public class runNN {

	public static void main(String[] args) {

		double[][] input = { { -1.0, -1.0},
							 { -1.0, 1.0},
							 { 1.0, -1.0},
							 { 1.0, 1.0}
							};
		double[][] output = { { 0.0, 1.0, 1.0, 0.0,} };
		double[][] weights = { { 1.0 }, { 1.0 }};
		
		System.out.println();
		NeuralNetwork nn = new NeuralNetwork(7, 2, 1)
							  .setInput(input)
							  .setOutput(output)
							  .setWeights(weights)
							  ;

		nn.train(1);

		

		double[][] result = nn.predict(input);

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(input[i][j] + "," + input[i][j + 1]  + " = " + result[i][j] + " = "
						+ (result[i][j] > 0.9) +" Correct:" +((result[i][j] > 0.9)==(output[0][i] > 0.9)));
			}
			System.out.println();
		}

	}

}
