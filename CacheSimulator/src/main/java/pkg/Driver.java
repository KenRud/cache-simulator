package pkg;

import java.io.IOException;

public class Driver {
	public static void main(String[] args) throws IOException {
		Simulation sim = new Simulation(256, 8, Simulation.FIFO);
		sim.run();
		System.out.println("Number of misses: " + sim.getMisses());
		System.out.println("Number of addresses: " + sim.getAdresses());
		System.out.println("Miss Rate: " + (100f * sim.getMisses() / sim.getAdresses()));
	}
}
