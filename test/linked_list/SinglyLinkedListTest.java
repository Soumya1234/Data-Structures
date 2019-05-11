package linked_list;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
		assertEquals(0,list.size());
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
		Integer[] resulting_list = Arrays.copyOf(list.toArray(),list.toArray().length,Integer[].class);
		assertArrayEquals(new Integer[] {1,23,45,44},resulting_list);
	}
	
	@Test
	void testAddToHead() {
		testList.addToHead(99);
		testList.addToHead(199);
		Integer[] resulting_list = Arrays.copyOf(testList.toArray(),testList.toArray().length,Integer[].class);
		assertArrayEquals(new Integer[] {199,99,1,23,45,44},resulting_list);
	}
	
	@Test
	void testPeekFirstAndLast() {
		assertEquals(1,(int)testList.peekFirst());
		assertEquals(44,(int)testList.peekLast());
	}
}
