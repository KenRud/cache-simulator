package pkg;

import java.util.LinkedList;
import java.util.Queue;

public class FifoSet implements OrderedSet {
	private Queue<Integer> tags = new LinkedList<>();

	@Override
	public boolean add(int tag) {
		return false;
	}

	@Override
	public boolean contains(int tag) {
		return false;
	}

	@Override
	public boolean remove(int tag) {
		return false;
	}

}
