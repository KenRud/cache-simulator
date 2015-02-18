package pkg;

import java.io.IOException;
import java.io.PrintWriter;

public class Driver {

	public final static String firstTrace = "TRACE1.DAT";
	public final static String secondTrace = "TRACE2.DAT";

	public static void main(String[] args) throws IOException {
		int K = 1;
		int KN = 64;


		PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
		writer.println("Simulation Results\n");
		writer.println("Using " + firstTrace);
		writer.println("Simulation:\tMisses:\tAddresses:\tMiss Rate:\n");
		while(K <= 4){

			Simulation sim = new Simulation(KN, (int) Math.pow(2,  K), Simulation.FIFO);
			sim.run(firstTrace);
			writer.println(Simulation.FIFO + "\tKN: " + KN + "\tK: " + Math.pow(2,  K) + "\t");
			writer.print(sim.getMisses() + "\t" + sim.getAdresses() + "\t" + (100f * sim.getMisses() / sim.getAdresses()) + "\n");

			K++;
			
			if(KN == 64 && K == 5){
				KN = 256;
				K = 1;
			}
		}
		
		K = 1;
		KN = 64;
		
		while(K <= 4){

			Simulation sim = new Simulation(KN, (int) Math.pow(2,  K), Simulation.LRU);
			sim.run(firstTrace);
			writer.println(Simulation.LRU + "\tKN: " + KN + "\tK: " + Math.pow(2,  K) + "\t");
			writer.print(sim.getMisses() + "\t" + sim.getAdresses() + "\t" + (100f * sim.getMisses() / sim.getAdresses()) + "\n");

			K++;
			
			if(KN == 64 && K == 5){
				KN = 256;
				K = 1;
			}
		}

		K = 1;
		KN = 64;
		writer.println("Using " + secondTrace);

		while(K <= 4){

			Simulation sim = new Simulation(KN, (int) Math.pow(2,  K), Simulation.FIFO);
			sim.run(secondTrace);
			writer.println(Simulation.FIFO + "\tKN: " + KN + "\tK: " + Math.pow(2,  K) + "\t");
			writer.print(sim.getMisses() + "\t" + sim.getAdresses() + "\t" + (100f * sim.getMisses() / sim.getAdresses()) + "\n");

			K++;
			
			if(KN == 64 && K == 5){
				KN = 256;
				K = 1;
			}
		}
		
		K = 1;
		KN = 64;
		
		while(K <= 4){

			Simulation sim = new Simulation(KN, (int) Math.pow(2,  K), Simulation.LRU);
			sim.run(secondTrace);
			writer.println(Simulation.LRU + "\tKN: " + KN + "\tK: " + Math.pow(2,  K) + "\t");
			writer.print(sim.getMisses() + "\t" + sim.getAdresses() + "\t" + (100f * sim.getMisses() / sim.getAdresses()) + "\n");

			K++;
			
			if(KN == 64 && K == 5){
				KN = 256;
				K = 1;
			}
		}




		writer.flush();
		writer.close();
		System.out.println("Simulations complete.");
	}
}
