package stack;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.function.Executable;

class StackTest {
	private Stack testStack;

	@BeforeEach
	void init() {
		testStack = new Stack();
		testStack.push(1);
		testStack.push(2);
		testStack.push(3);
		testStack.push(4);
	}

	@Test
	void testIsEmpty() {
		Stack stack = new Stack();
		assertTrue(stack.isEmpty());
	}

	// This together with the init() method also tests the push() functionality
	@Test
	void testIsFull() {
		testStack.push(5);
		testStack.push(6);
		testStack.push(7);
		testStack.push(8);
		assertTrue(testStack.isFull());
		assertThrows(Exception.class, new Executable() {

			@Override
			public void execute() throws Throwable {
				testStack.push(9);

			}

		});
	}

	@Test
	void testLength() {
		assertEquals(4, testStack.length());
	}

	@Test
	void testPop() {
		assertEquals(4, (int) testStack.pop());
		testStack.clear();
		assertEquals(0, testStack.length());
		assertThrows(Exception.class, new Executable() {

			@Override
			public void execute() throws Throwable {
				testStack.pop();

			}

		});
	}

	@Test
	void testToArray() {
		Integer[] resulting_array = Arrays.copyOf(testStack.toArray(), testStack.toArray().length, Integer[].class);
		assertArrayEquals(new Integer[] { 4,3,2,1 }, resulting_array);
	}

}
