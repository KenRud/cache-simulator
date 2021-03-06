package pkg;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Simulation {
	public static final String FIFO = "FIFO";
	public static final String LRU = "LRU";

	private int misses = 0;
	private int addressAdded = 0;
	private Cache cache;

	public Simulation(int KN, int K, String policy){
		int N = KN/K;
		cache = new Cache(N, K, policy);
	}

	public void run(String fileName) throws IOException{


		DataInputStream input = new DataInputStream(new FileInputStream(fileName));
		byte[] bs = new byte[3];
		while(input.available() > 0){
			addressAdded++;
			input.read(bs);

			int address = (bs[2] << 16) & 0x00ff0000 | 
					(bs[1] << 8) & 0x0000ff00 | 
					(bs[0] << 0) & 0x000000ff;

			if (!cache.add(address)) {
				misses++;
			};

		}
		input.close();
	}

	public int getMisses(){
		return misses;
	}
	
	public int getAdresses(){
		return addressAdded;
	}

}
