package linked_list;

public class SinglyLinkedList implements LinkedList{
	private int size;
	private Node head;
	private Node tail;

	public SinglyLinkedList() {
		head = tail = null;
		size = 0;
	}

	/**
	 * Returns the size of the list
	 * 
	 * @return int
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Returns true if list is empty else returns false
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Clears the list
	 */
	public void clear() {
		head = tail = null;
		size = 0;
	}

	/**
	 * Adds an element to the tail of the list
	 * 
	 * @param data
	 */
	public void add(Object data) {
		Node node = new Node(data, null);
		if (this.isEmpty()) {
			head = tail = node;
			size++;
		} else {
			tail.next = node;
			tail = node;
			size++;
		}
	}

	/**
	 * Convenience method to get an array of the elements in the list
	 * 
	 * @return Object[]
	 */
	public Object[] toArray() {
		if (this.isEmpty()) {
			return null;
		}
		Object[] array = new Object[size];
		int i = 0;
		Node trav = head;
		while (trav != null) {
			array[i++] = trav.data;
			trav = trav.next;
		}
		return array;
	}

	/**
	 * Adds an element to the head of the list
	 * 
	 * @param data
	 */
	public void addToHead(Object data) {
		Node node = new Node(data, null);
		if (this.isEmpty()) {
			head = tail = node;
			size++;
		} else {
			node.next = head;
			head = node;
			size++;
		}
	}

	/**
	 * Returns the head element of the list
	 * 
	 * @return
	 */
	public Object peekFirst() {
		if (this.isEmpty()) {
			throw new RuntimeException("Empty List!!");
		}
		return head.data;
	}

	/**
	 * Returns the last element of the list
	 * 
	 * @return
	 */
	public Object peekLast() {
		if (this.isEmpty()) {
			throw new RuntimeException("Empty List!!");
		}
		return tail.data;
	}

	/**
	 * Removes the head element from the list and returns the object
	 * 
	 * @return Object
	 */
	public Object removeFirst() {
		if (this.isEmpty()) {
			throw new RuntimeException("Empty List!!");
		}
		Object element = head.data;
		head = head.next;
		size--;
		if (this.isEmpty()) {
			tail = null;
		}
		return element;
	}

	/**
	 * Removes the tail of the element from the list and returns the object
	 * 
	 * @return Object
	 */
	public Object removeLast() {
		if (this.isEmpty()) {
			throw new RuntimeException("Empty List!!");
		}
		Object element = tail.data;
		// If the list contains only one element
		// then head and tail point to the same element
		// So remove the element and assign null to head and tail
		// now the list will be empty
		if (this.size == 1) {
			element = head;
			head = tail = null;
			size--;
			return element;
		} else {
			Node trav = head;
			while (trav != null) {
				if (trav.next.next == null) {
					tail = trav;
					tail.next = null;
					break;
				}
				trav = trav.next;
			}
			size--;
			return element;
		}
	}

	/**
	 * Removes the specified element  
	 * @throws RuntimeException if invoked on an empty list
	 * @param element
	 * @return true if the element was removed else returns false
	 */
	public boolean remove(Object element) {
		// If the list is empty then throw exception
		if (this.isEmpty()) {
			throw new RuntimeException("Empty List!!");
		}
		if(indexOf(element)!= -1) {
			removeAt(indexOf(element));
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Removes the node at the specified index and returns the element
	 * 
	 * @throws RuntimeException        if the list is empty
	 * @throws IlegalArgumentException if index is out of bounds
	 * @param index
	 * @return
	 */
	public Object removeAt(int index) {
		// If the list is empty then throw exception
		if (this.isEmpty()) {
			throw new RuntimeException("Empty List!!");
		}
		// If the index if out of bounds then throw exception
		if (index < 0 || index > size - 1) {
			throw new IllegalArgumentException("Index: " + index + " out of bounds");
		}
		Object element = null;
		// If the index is that of the last element then invoke removeLast()
		// This also covers the case when size==1 and index==0
		if (index == size - 1) {
			return this.removeLast();
		}
		// If the index is that of the first element then invoke removeFirst()
		if (index == 0) {
			return this.removeFirst();
		}
		// If the index is in between then traverse to the previous node at (index-1)
		// and update its next reference
		int i = 0;
		Node trav = head;
		while (i < index - 1) {
			trav = trav.next;
			i++;
		}
		element = trav.next.data;
		Node temp = trav.next.next;
		trav.next = temp;
		size--;
		return element;
	}

	/**
	 * Returns the index of the input element if exists else returns false
	 * 
	 * @param Object element to be searched
	 * @return int
	 */
	public int indexOf(Object element) {
		int i = 0;
		Node trav = head;
		while (trav != null) {
			if (trav.data.equals(element)) {
				return i;
			}
			trav = trav.next;
			i++;
		}
		return -1;
	}

	/*
	 * Static member class to represent a node in the list
	 */
	private static class Node {
		private Object data;
		private Node next;

		Node(Object data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
}
