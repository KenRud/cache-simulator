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
	public boolean contains(int tag) {
		return false;
	}

	@Override
	public boolean remove(int tag) {
		return false;
	}

}
