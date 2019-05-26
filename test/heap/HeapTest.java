package heap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HeapTest {
	private Heap h = new Heap();

	@BeforeEach
	void init() {
		h.add(1);
		h.add(34);
		h.add(87);
		h.add(87);
		h.add(23);
		h.add(7);
		h.add(6);
		h.add(8);
	}

	@Test
	void testAdd() {
		assertArrayEquals(new int[] { 87, 87, 34, 8, 23, 7, 6,1 }, h.toArray());
	}

	@Test
	void testPoll() {
		assertEquals(87, h.poll());
		assertArrayEquals(new int[] { 87, 23, 34, 8, 8, 7,6 }, h.toArray());
	}

}
