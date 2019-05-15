package stack;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.function.Executable;

class Stack2Test {
	private Stack2 testStack2;

	@BeforeEach
	void init() {
		testStack2 = new Stack2();
		testStack2.push(1);
		testStack2.push(2);
		testStack2.push(3);
		testStack2.push(4);
	}

	@Test
	void testIsEmpty() {
		Stack2 stack = new Stack2();
		assertTrue(stack.isEmpty());
	}

	// This together with the init() method also tests the push() functionality
	@Test
	void testIsFull() {
		testStack2.push(5);
		testStack2.push(6);
		testStack2.push(7);
		testStack2.push(8);
		assertTrue(testStack2.isFull());
		assertThrows(Exception.class, new Executable() {

			@Override
			public void execute() throws Throwable {
				testStack2.push(9);

			}

		});
	}

	@Test
	void testLength() {
		assertEquals(4, testStack2.size());
	}

	@Test
	void testPop() {
		assertEquals(4, (int) testStack2.pop());
		testStack2.clear();
		assertEquals(0, testStack2.size());
		assertThrows(Exception.class, new Executable() {

			@Override
			public void execute() throws Throwable {
				testStack2.pop();

			}

		});
	}

	@Test
	void testToArray() {
		Integer[] resulting_array = Arrays.copyOf(testStack2.toArray(), testStack2.toArray().length, Integer[].class);
		assertArrayEquals(new Integer[] { 1,2,3,4 }, resulting_array);
	}

}
