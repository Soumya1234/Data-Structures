package stack;

import linked_list.DoublyLinkedList;

/**
 * Stack implemented using DoublyLinkedList
 * @author Soumyadeep
 *
 */
public class Stack2 {
	private DoublyLinkedList list  = new DoublyLinkedList();
	private int capacity;
	private static int DEFAULT_CAPACITY = 8;
	public Stack2() {
		this.capacity = DEFAULT_CAPACITY;
	}
	
	public Stack2(Object element) {
		list.add(element);
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public void push(Object element) {
		if(isFull()) {
			throw new RuntimeException("Stack is full");
		}
		list.add(element);
	}
	
	public Object pop() {
		if(isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return list.removeLast();
	}
	
	public Object peek() {
		if(isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return list.peekLast();
	}
	
	public Object[] toArray() {
		return list.toArray();
	}
	
	public void clear() {
		list.clear();
	}
	
	public boolean isFull() {
		return list.size() == capacity;
	}
}

