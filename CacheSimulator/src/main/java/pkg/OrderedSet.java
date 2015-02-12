package pkg;

public interface OrderedSet {
	/**
	 * Adds a tag to the set if it is not already in the set. Returns TRUE for a
	 * hit and FALSE for a miss.
	 * 
	 * @param tag
	 *            The tag to be added to set.
	 * @return Whether or not the set already contains this tag.
	 */
	boolean add(int tag);

	Integer[] toArray();
}
