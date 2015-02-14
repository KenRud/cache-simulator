package pkg;

import java.util.LinkedList;
import java.util.Queue;

public class FifoSet implements OrderedSet {
	private final int numLines;
	private Queue<Integer> tags = new LinkedList<Integer>();

	public FifoSet(int numLines) {
		this.numLines = numLines;
	}
	
	@Override
	public boolean add(int tag) {
		if (tags.contains(tag)) {
			return true;
		}
		
		if (tags.size() == numLines) {
			tags.remove();
		}
		
		tags.add(tag);
		
		return false;
	}

	@Override
	public Integer[] toArray() {
		Integer[] array = new Integer[tags.size()];
		tags.toArray(array);
		return array;
	}
}
