package arrays;

public class IntDynamicArray {
	private int[] array;
	private int length; // the length of the array the user thinks it has
	private int capacity; // actual length of the underlying array
	private static final int DEFAULT_CAPACITY = 6;

	/**
	 * Constructor to create a dynamic array with a specified initial capacity
	 * 
	 * @param capacity
	 */
	public IntDynamicArray(int capacity) {
		if (capacity < 0)
			throw new IllegalArgumentException("Invalid Capacity: " + capacity);
		this.capacity = capacity;
		this.length = 0;
		array = new int[capacity];
	}

	/**
	 * Constructor to create a dynamic array with default capacity
	 */
	public IntDynamicArray() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Constructor to create a dynamic array with the specified static array
	 * 
	 * @param staticArray
	 */
	public IntDynamicArray(int[] staticArray) {
		this.length = staticArray.length;
		this.array = staticArray;
		if (staticArray.length <= DEFAULT_CAPACITY) {
			this.capacity = DEFAULT_CAPACITY;
		} else {
			this.capacity = staticArray.length;
		}
	}

	/**
	 * @return length of the array
	 */
	public int size() {
		return length;
	}

	/**
	 * @return true if the array is empty else false
	 */
	public boolean isEmpty() {
		return length == 0;
	}

	/**
	 * Returns the element in the specified index position of the array
	 * 
	 * @param index
	 * @return
	 */
	public int get(int index) {
		return this.array[index];
	}

	/**
	 * Replaces the element at the specified index position with the input element
	 * 
	 * @param index
	 * @param element
	 */
	public void set(int index, int element) {
		this.array[index] = element;
	}

	/**
	 * Clears the contents of the array
	 */
	/*
	 * This is achieved by pointing the array variable to a new int array. Another
	 * way is to loop through the existing array and set all elements to zero but
	 * that would be slow
	 */
	public void clear() {
		array = new int[capacity];
		length = 0;
	}

	/**
	 * Appends @param element to the end of the array
	 * 
	 * @param element
	 */
	public void add(int element) {
		if (length == capacity) {
			/*
			 * create a new array with twice the initial capacity and copy the original
			 * elements into it then add the input element
			 */
			int[] new_array = new int[capacity *= 2];
			int i = 0;
			for (int j : this.array) {
				new_array[i++] = j;
			}
			new_array[i] = element;
			this.length++;
			array = new_array;

		} else {
			array[this.length++] = element;
		}
	}

	/**
	 * Inserts the input @param element into the specified @param index
	 * 
	 * @param element
	 * @param index
	 */
	public void insert(int element, int index) {
		if(length == 0) {
			throw new IllegalArgumentException("Insertion not possible into empty array");
		}
		if (index > this.length - 1 || index < 0) {
			throw new IllegalArgumentException("Illegal Index: " + index);
		}
		if (length == capacity) {
			/*
			 * create a new array with twice the initial capacity and copy the original
			 * elements into it then add the input element at the specified index
			 */
			int[] new_array = new int[capacity *= 2];
			int i = 0;
			for (int j : this.array) {
				new_array[i++] = j;
			}
			i = this.length - 1;
			while (i >= index) {
				new_array[i + 1] = new_array[i];
				i--;
			}
			new_array[index] = element;
			this.length++;
			array = new_array;
		} else {
			int i = this.length - 1;
			while (i >= index) {
				this.array[i + 1] = this.array[i];
				i--;
			}
			this.array[index] = element;
			this.length++;
		}
	}

	/**
	 * Returns the first index of the specified element if exists, else returns -1
	 * 
	 * @param element
	 * @return
	 */
	public int indexOf(int element) {
		int i = 0;
		while (i < length) {
			if (array[i] == element) {
				return i;
			}
			i++;
		}
		return -1;
	}

	/**
	 * Returns true if the element is in the array, else returns false
	 * 
	 * @param element
	 * @return
	 */
	public boolean contains(int element) {
		return indexOf(element) != -1;
	}

	/**
	 * Removes the element at the specified index and returns the removed element
	 * 
	 * @param index
	 * @return
	 */
	/*
	 * Removes the element at specified index by shifting elements to the left to
	 * fill the gap and then copying the array elements into a new array
	 */
	public int removeAt(int index) {
		if (index < 0 || index > length - 1) {
			throw new IllegalArgumentException("Index: " + index + " out of bounds");
		} else {
			int value = array[index];
			int i = index;
			while (i < length - 1) {
				array[i] = array[i + 1];
				i++;
			}
			array[i] = 0;
			length = length - 1;
			int[] new_array = new int[length];
			i = 0;
			int j = 0;
			while (i < length) {
				new_array[i++] = array[j++];
			}
			array = new_array;
			return value;
		}
	}

	/**
	 * Removes the specified element if exists and returns true otherwise returns
	 * false
	 * 
	 * @param element
	 * @return
	 * @throws Exception
	 */
	public boolean remove(int element) {
		int index = indexOf(element);
		if (index == -1) {
			return false;
		}
		removeAt(index);
		return true;
	}

	/**
	 * Returns the array as a static array
	 * 
	 * @return
	 */
	public int[] toStaticArray() {
		if(length == 0) {
			return null;
		}
		int[] result = new int[length];
		int i =0;
		int j =0;
		while(i<length) {
			result[i++] = array[j++];
		}
		return result;
	}

	@Override
	public String toString() {
		if (length == 0) {
			return "[]";
		}
		StringBuilder sb = new StringBuilder(length).append("[");
		for (int j = 0; j < length; j++) {
			if (j == length - 1) {
				sb.append(array[j]);
			} else {
				sb.append(array[j] + ",");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	/*
	 * Non static member class representing an iterator for iterating through the
	 * elements of the dynamic array
	 */
	private class IntDynamicArrayIterator implements DynamicArrayIterator {
		private int index = 0;

		@Override
		public boolean hasNext() {
			return index < length;
		}

		@Override
		public Object next() {
			return IntDynamicArray.this.array[index++];
		}

	}

	/**
	 * Returns an iterator for the IntDynamicArray
	 * 
	 * @return
	 */
	public DynamicArrayIterator iterator() {
		return new IntDynamicArrayIterator();
	}

}
