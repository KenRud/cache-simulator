package pkg;

public class Cache {

	final int BYTES_PER_LINE = 8;
	FifoSet linesPerSet[N];

	public Cache(int N, int K, String policy){

		if(policy.equals('FIFO')){

			for(int i = 0; i < linesPerSet.length; i++){
				linesPerSet[i] = new FifoSet(K);
			}

		}else {

		}

	}

}
