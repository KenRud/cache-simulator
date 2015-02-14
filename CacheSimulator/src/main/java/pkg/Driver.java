package pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class Driver {

	public final static String firstTrace = "TRACE1.DAT";
	public final static String secondTrace = "TRACE2.DAT";

	public static void main(String[] args) throws IOException {
		int K = 1;
		int KN = 64;


		PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
		writer.println("Simulation Results\n");
		writer.println("Simulation:\tMisses:\tAddresses:\tMiss Rate:\n");

		while(K <= 4){

			Simulation sim = new Simulation(KN, 2^K, Simulation.FIFO);
			sim.run(firstTrace);
			writer.println(Simulation.FIFO + " KN: " + KN + " K: " + K + "\t");
			writer.println(sim.getMisses() + "\t" + sim.getAdresses() + "\t" + (100f * sim.getMisses() / sim.getAdresses()));

			if(KN == 64 && K == 4){
				KN = 256;
				K = 1;
			}

			K++;
		}

	}
}
