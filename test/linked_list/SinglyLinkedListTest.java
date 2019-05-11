package linked_list;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class SinglyLinkedListTest {
	private SinglyLinkedList testList;

	@BeforeEach
	void init() {
		testList = new SinglyLinkedList();
		testList.add(1);
		testList.add(23);
		testList.add(45);
		testList.add(44);
	}

	@Test
	void testSize() {
		SinglyLinkedList list = new SinglyLinkedList();
		assertEquals(0, list.size());
	}

	@Test
	void testIsEmpty() {
		SinglyLinkedList list = new SinglyLinkedList();
		assertTrue(list.isEmpty());
	}

	@Test
	void testAdd() {
		SinglyLinkedList list = new SinglyLinkedList();
		list.add(1);
		list.add(23);
		list.add(45);
		list.add(44);
		Integer[] resulting_list = Arrays.copyOf(list.toArray(), list.toArray().length, Integer[].class);
		assertArrayEquals(new Integer[] { 1, 23, 45, 44 }, resulting_list);
	}

	@Test
	void testAddToHead() {
		testList.addToHead(99);
		testList.addToHead(199);
		Integer[] resulting_list = Arrays.copyOf(testList.toArray(), testList.toArray().length, Integer[].class);
		assertArrayEquals(new Integer[] { 199, 99, 1, 23, 45, 44 }, resulting_list);
	}

	@Test
	void testPeekFirstAndLast() {
		assertEquals(1, (int) testList.peekFirst());
		assertEquals(44, (int) testList.peekLast());
	}

	@Test
	void testRemoveFirst() {
		testList.removeFirst();
		Integer[] resulting_list = Arrays.copyOf(testList.toArray(), testList.toArray().length, Integer[].class);
		assertArrayEquals(new Integer[] { 23, 45, 44 }, resulting_list);
		testList.removeFirst();
		testList.removeFirst();
		resulting_list = Arrays.copyOf(testList.toArray(), testList.toArray().length, Integer[].class);
		assertArrayEquals(new Integer[] { 44 }, resulting_list);
		testList.removeFirst();
		assertTrue(testList.isEmpty());
	}

	@Test
	void testRemoveLast() {
		testList.removeLast();
		assertEquals(3, testList.size());
		Integer[] resulting_list = Arrays.copyOf(testList.toArray(), testList.toArray().length, Integer[].class);
		assertArrayEquals(new Integer[] { 1, 23, 45 }, resulting_list);
		testList.removeFirst();
		testList.removeLast();
		testList.removeFirst();
		assertTrue(testList.isEmpty());
	}

	@Test
	void testIndexOf() {
		assertEquals(0, testList.indexOf(1));
		assertEquals(3, testList.indexOf(44));
		assertEquals(-1, testList.indexOf(74));
	}

	@Test
	void testRemoveAt() {
		testList.removeAt(0);
		Integer[] resulting_list = Arrays.copyOf(testList.toArray(), testList.toArray().length, Integer[].class);
		assertArrayEquals(new Integer[] { 23, 45, 44 }, resulting_list);

		testList.removeAt(2);
		resulting_list = Arrays.copyOf(testList.toArray(), testList.toArray().length, Integer[].class);
		assertArrayEquals(new Integer[] { 23, 45 }, resulting_list);

		testList.removeAt(1);
		resulting_list = Arrays.copyOf(testList.toArray(), testList.toArray().length, Integer[].class);
		assertArrayEquals(new Integer[] { 23 }, resulting_list);

		assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				testList.removeAt(1);
			}
		});
		
		testList.removeAt(0);
		assertTrue(testList.isEmpty());
		assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				testList.removeAt(0);

			}
		});
	}
	
	@Test
	void testRemove() {
		assertTrue(testList.remove(45));
		Integer[] resulting_list = Arrays.copyOf(testList.toArray(), testList.toArray().length, Integer[].class);
		assertArrayEquals(new Integer[] {1, 23,44 }, resulting_list);
		assertEquals(3,testList.size());
		assertFalse(testList.remove(88));
		assertEquals(3,testList.size());
		assertTrue(testList.remove(1));
		assertTrue(testList.remove(23));
		assertTrue(testList.remove(44));
		assertTrue(testList.isEmpty());
		assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				testList.remove(0);

			}
		});
	}
}
