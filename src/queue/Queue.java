package queue;

import linked_list.DoublyLinkedList;

public class Queue {
	private DoublyLinkedList list = new DoublyLinkedList();
	
	public Queue() {
		
	}
	
	public void add(Object element) {
		list.add(element);
	}
	
	public Object poll() {
		if(isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		return list.removeFirst();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean contains(Object element) {
		return list.contains(element);
	}
	
	public Object peek() {
		if(isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		return list.peekFirst();
	}
	
	public Object[] toArray() {
		return list.toArray();
	}
}
