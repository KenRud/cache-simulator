package pkg;

import java.util.LinkedList;

public class LruSet implements OrderedSet {
	private final int numLines;
	private LinkedList<Integer> tags = new LinkedList<Integer>();

	public LruSet(int numLines) {
		this.numLines = numLines;
	}

	@Override
	public boolean add(int tag) {
		if (tags.contains(tag)) {
			tags.removeFirstOccurrence(tag);
			tags.add(tag);
			return true;
		}
		
		if (tags.size() == numLines) {
			tags.removeFirst();
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
