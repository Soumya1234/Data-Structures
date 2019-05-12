package linked_list;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class DoublyLinkedListTest {
	private DoublyLinkedList testList;

	// Method that will be executed before each test.
	// This together with the test for toArray() method will serve the purpose of
	// testing add(Object) method
	@BeforeEach
	void init() {
		testList = new DoublyLinkedList();
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
	}

	@Test
	void testSize() {
		assertEquals(4, testList.size());
	}

	@Test
	void testIsEmpty() {
		assertFalse(testList.isEmpty());
	}

	@Test
	void testClear() {
		testList.clear();
		assertTrue(testList.isEmpty());
	}

	@Test
	void testToArray() {
		Integer[] resulting_list = Arrays.copyOf(testList.toArray(), testList.toArray().length, Integer[].class);
		assertArrayEquals(new Integer[] { 1, 2, 3, 4 }, resulting_list);
	}

	@Test
	void testAddToHead() {
		testList.addToHead(23);
		Integer[] resulting_list = Arrays.copyOf(testList.toArray(), testList.toArray().length, Integer[].class);
		assertArrayEquals(new Integer[] { 23, 1, 2, 3, 4 }, resulting_list);

		DoublyLinkedList list = new DoublyLinkedList();
		list.addToHead(1);
		resulting_list = Arrays.copyOf(list.toArray(), list.toArray().length, Integer[].class);
		assertArrayEquals(new Integer[] { 1 }, resulting_list);

	}

	@Test
	void testRemoveFirstandLast() {
		testList.removeFirst();
		testList.removeLast();
		Integer[] resulting_list = Arrays.copyOf(testList.toArray(), testList.toArray().length, Integer[].class);
		assertArrayEquals(new Integer[] { 2, 3 }, resulting_list);
		testList.removeFirst();
		testList.removeLast();
		assertTrue(testList.isEmpty());
		assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				testList.removeFirst();

			}
		});
		assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				testList.removeLast();

			}
		});
	}

	@Test
	void testRemoveAt() {
		assertEquals(3, (int) testList.removeAt(2));
		Integer[] resulting_list = Arrays.copyOf(testList.toArray(), testList.toArray().length, Integer[].class);
		assertArrayEquals(new Integer[] { 1,2, 4 }, resulting_list);
		assertEquals(4, (int) testList.removeAt(2));
		resulting_list = Arrays.copyOf(testList.toArray(), testList.toArray().length, Integer[].class);
		assertArrayEquals(new Integer[] { 1, 2 }, resulting_list);
	}

	@Test
	void testIndexOf() {
		assertEquals(1, testList.indexOf(2));
		assertEquals(-1, testList.indexOf(22));

		DoublyLinkedList list = new DoublyLinkedList();
		assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				list.indexOf(2);

			}
		});
	}

}
