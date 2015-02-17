package pkg;

public class Cache {

	private static final int BYTES_PER_LINE = 8;
	private static final double LOG2 = Math.log(2);
	private static final int BYTE_OFFSET = log2(BYTES_PER_LINE);
	
	OrderedSet linesPerSet[];
	private final int tagMask;
	private final int setOffset;

	/**
	 * Creates a new Cache instance.
	 * @param N Number of sets
	 * @param K Number of lines per set
	 * @param policy The replacement policy for capacity misses.
	 */
	public Cache(int N, int K, String policy){
		// Sets up the array of sets
		linesPerSet = new OrderedSet[N];
		if(policy.equals(Simulation.FIFO)){
			for(int i = 0; i < linesPerSet.length; i++){
				linesPerSet[i] = new FifoSet(K);
			}
		} else {
			for(int i = 0; i < linesPerSet.length; i++){
				linesPerSet[i] = new LruSet(K);
			}
		}
		
		// Determines the tag mask for the addresses
		setOffset = log2(N);
		tagMask = 0xFFFFFFFF << setOffset + BYTE_OFFSET;
//		System.out.println(String.format("N: %d, K: %d", N, K));
//		System.out.println(String.format(
//				"Tag Mask: %s, Set Offset: %d, Byte Offset: %d",
//				Integer.toBinaryString(tagMask), setOffset, BYTE_OFFSET));
	}

	public boolean add(int addr) {
		int setIndex = getSetIndex(addr);
		OrderedSet set = linesPerSet[setIndex];
		int tag = getTag(addr);
		return set.add(tag);
	}
	
	private static int log2(int n) {
		return (int) Math.round(Math.log(n) / LOG2);
	}
	
	private int getSetIndex(int addr) {
		return (~tagMask & addr) >> BYTE_OFFSET;
	}
	
	private int getTag(int addr) {
		return (addr & tagMask) >> setOffset + BYTE_OFFSET;
	}
}
