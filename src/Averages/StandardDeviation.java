package Averages;

import java.math.BigDecimal;
import java.math.RoundingMode;

import Main.Pso;
import Main.PsoConstants;

public class StandardDeviation implements PsoConstants {	
	
	private double[] arrayToPrintGraph;
	private Pso pso;
	private double averageHelper;
	private double averages[];
	private double average;
	private double deviation[];
	int iterations = 5;
	
	
	
	
	public StandardDeviation(int swarmSize, String topology){
		arrayToPrintGraph = new double[ITERATIONS];
		pso = new Pso(swarmSize, topology);
		averageHelper = 0;
		averages= new double[iterations];
		average = 0;
		initArrayToPrintGraph();
		deviation = new double[iterations];
	}
	
	
	
	
	public void sD(){
		for(int i = 0; i < iterations; i++){
			pso.runWithArgs();
			averages[i] = pso.getBestSoFar();
			for(int j = 0; j < arrayToPrintGraph.length; j++){
				arrayToPrintGraph[j] += pso.getArrayToGraphic()[j];
			}
		}
		calculateAverageArrayToGraph();
		
		for(int i = 0; i < iterations; i++){
			averageHelper += averages[i];
		}
		average = averageHelper/iterations;
		
		
		for(int i = 0; i < iterations; i++){
			deviation[i] = averages[i] - average;
		}
		
		double deviationSquared[] = new double[iterations];
		for(int i = 0; i < iterations; i++){
			deviationSquared[i] = deviation[i] * deviation[i];
		}
		
		double sumDeviationSquared = 0;
		for(int i = 0; i < iterations; i++){
			sumDeviationSquared += deviationSquared[i];
		}
		
		double averageSumDeviationSquared = sumDeviationSquared / iterations;
		
		double standardDeviation = Math.sqrt(averageSumDeviationSquared);
		
		double av = average;
		BigDecimal avp = new BigDecimal(av).setScale(5, RoundingMode.HALF_EVEN);
		
		
		double sd = standardDeviation;
		BigDecimal sdp = new BigDecimal(sd).setScale(5, RoundingMode.HALF_EVEN);

		
		System.out.println("----------------------------------");
		System.out.println("TOPOLOGY:" + pso.getTopology());
		System.out.println("AVERAGE:" + avp.doubleValue());
		System.out.println("STANDARD VARIATION:" + sdp.doubleValue());
	
		System.out.println();
	}
	
	public void initArrayToPrintGraph(){
		for(int i = 0; i < ITERATIONS; i++)
			arrayToPrintGraph[i] = 0;
	}
	
	public void calculateAverageArrayToGraph(){
		for(int i = 0; i < ITERATIONS; i++){
			double result = arrayToPrintGraph[i];
			arrayToPrintGraph[i] = Math.log1p(result / iterations);
		}
	}
	
	public double[] getArrayToGraph(){
		return this.arrayToPrintGraph;
	}
	
}
