package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import pkg.FifoSet;
import pkg.OrderedSet;

public class OrderedSetTest {
	private static final Integer[] EMPTY = new Integer[0];

	@Test
	public void fifoSet() {
		OrderedSet set = new FifoSet(5);
		assertArrayEquals(EMPTY, set.toArray());
		
		assertEquals(false, set.add(4));
		assertEquals(false, set.add(9));
		
		set.add(7);
		assertArrayEquals(new Integer[]{4, 9, 7}, set.toArray());
		
		set.add(1);
		set.add(134);
		assertArrayEquals(new Integer[]{4, 9, 7, 1, 134}, set.toArray());
		
		set.add(23);
		assertArrayEquals(new Integer[]{9, 7, 1, 134, 23}, set.toArray());
		
		assertEquals(true, set.add(1));
		assertArrayEquals(new Integer[]{9, 7, 1, 134, 23}, set.toArray());
		
		assertEquals(false, set.add(54));
		assertArrayEquals(new Integer[]{7, 1, 134, 23, 54}, set.toArray());
	}

}
