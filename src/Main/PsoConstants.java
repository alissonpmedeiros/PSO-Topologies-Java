package Main;

public interface PsoConstants {
	int DIMENSIONS = 30;
	String FUNCTION = "Rastrigin";

	int ITERATIONS  = 10000;
	double CONSTRICTION_FACTOR = 0.7298;
	double phi1 = 2.05; //particle best accelaration coefficient
	double phi2 = 2.05; //global best acceleration coefficient
	
}
