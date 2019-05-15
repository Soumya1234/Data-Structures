package queue;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueTest {
	private Queue testQueue;
	@BeforeEach
	void init() {
		testQueue = new Queue();
		for(int i = 0;i<36;i++) {
			testQueue.add(i);
		}
		
	}
	@Test
	void testAdd() {
		Integer[] result = Arrays.copyOf(testQueue.toArray(), testQueue.toArray().length,Integer[].class);
		Integer[] expected = new Integer[36];
		for(int i = 0;i<36;i++) {
			expected[i] = i;
		}
		assertArrayEquals(expected,result);
	}
    
	
	
}
