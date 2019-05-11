package linked_list;

public class SinglyLinkedList {
	private int size;
	private Node head;
	private Node tail;

	public SinglyLinkedList() {
		head = tail = null;
		size = 0;
	}
	/**
	 * Returns the size of the list
	 * @return int
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Returns true if list is empty else returns false
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
	 * @return
	 */
	public Object peekLast() {
		if (this.isEmpty()) {
			throw new RuntimeException("Empty List!!");
		}
		return tail.data;
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
