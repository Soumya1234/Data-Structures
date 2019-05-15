package stack;

/**
 * A custom implementation of Stack with linked list
 * @author Soumyadeep
 *
 */
public class Stack {
	private Node top;
	private int size;
	private int length;
	private static final int DEFAULT_SIZE = 8;
	
	public Stack() {
		this.top =null;
		this.size = DEFAULT_SIZE;
		this.length = 0;
	}
	
	public Stack(int size) {
		this.top = null;
		this.size = size;
		this.length = 0;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public boolean isFull() {
		return length == size;
	}
	
	public int length() {
		return this.length;
	}
	
	public void push(Object element) {
		if(isFull()) {
			throw new RuntimeException("Stack Overflow!!");
		}
		Node  new_node = new Node(element,null);
		new_node.next = top;
		top = new_node;
		length++;
	}
	
	public Object pop() {
		if(isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		Object element = top.data;
		top  = top.next;
		length--;
		return element;
	}
	
	public Object[] toArray() {
		if(isEmpty()) {
			return null;
		}
		Object[] array = new Object[length];
		int i = 0;
		while(top!=null) {
			array[i++] = top.data;
			top = top.next;
		}
		return array;
	}
	
	public void clear() {
		this.top = null;
		this.length = 0;
	}
	
	private static class Node{
		private Object data;
		private Node next;
		
		Node(Object data,Node next){
			this.data = data;
			this.next = next;
		}
	}
}
