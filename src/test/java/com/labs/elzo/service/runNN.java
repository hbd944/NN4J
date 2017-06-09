package com.labs.elzo.service;

public class runNN {

	public static void main(String[] args) {

		double[][] input = { { -1.0, -1.0},
							 { -1.0, 1.0},
							 { 1.0, -1.0},
							 { 1.0, 1.0}
							};
//		double[][] output = { { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, } };
//		double[][] output = { { 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, } };	
//		double[][] output = { { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, } };	
//		double[][] output = { { 0.0, 1.0, 1.0, 0.0,} };
//		double[][] output = { { 1.0, 1.0, 1.0, 1.0,} };
		double[][] output = { { 0.0, 1.0, 1.0, 0.0,} };
		double[][] weights = { { 1.0 }, { 1.0 }};
//		for (int i = 0; i < output.length; i++) {
//			for (int j = 0; j < output[i].length; j++) {
//				System.out.print(input[j][i] + "," + input[j][i + 1] + "," + input[j][i + 2] + " = " + output[0][j]
//						+ " = " + (output[0][j] > 0.9));
//				System.out.println();
//			}
//
//		}
		System.out.println();
		NuralNetwork nn = new NuralNetwork(7, 2, 1)
							  .setInput(input)
							  .setOutput(output)
							  .setWeights(weights)
							  ;

		nn.train(1);

		double[][] weightsPostTrain = nn.getWeights();
		for (int i = 0; i < weightsPostTrain.length; i++) {
			for (int j = 0; j < weightsPostTrain[i].length; j++) {
				System.out.print(weightsPostTrain[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println();
		
		double[][] test =  { { -1.0, -1.0},
							 { -1.0, -1.0},
							 { -1.0, 1.0},
							 { -1.0, 1.0},
							};
		test=input;
		double[][] result = nn.predict(test);

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(test[i][j] + "," + test[i][j + 1]  + " = " + result[i][j] + " = "
						+ (result[i][j] > 0.9) +" Correct:" +((result[i][j] > 0.9)==(output[0][i] > 0.9)));
			}
			System.out.println();
		}

	}

}
