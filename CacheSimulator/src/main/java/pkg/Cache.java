package pkg;

public class Cache {

	final int BYTES_PER_LINE = 8;
	OrderedSet linesPerSet[];

	public Cache(int N, int K, String policy){
		if(policy.equals("FIFO")){
			linesPerSet = new FifoSet[N];
			for(int i = 0; i < linesPerSet.length; i++){
				linesPerSet[i] = new FifoSet(K);
			}

		} else {

		}

	}

	public boolean add(int addr) {
		return false;
	}

}
