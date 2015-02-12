package pkg;

import java.util.LinkedList;
import java.util.List;

public class LruSet implements OrderedSet {
	private List<Integer> tags = new LinkedList<>();

	@Override
	public boolean add(int tag) {
		return false;
	}

	@Override
	public Integer[] toArray() {
		return null;
	}
}
