package linked_list;

public class DoublyLinkedList implements LinkedList {
	private int size;
	private Node head;
	private Node tail;

	public DoublyLinkedList() {
		size = 0;
		head = tail = null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		head = tail = null;
		size = 0;
	}

	@Override
	public void add(Object data) {
		if (isEmpty()) {
			head = tail = new Node(data, null, null);
			size++;
		} else {
			Node new_node = new Node(data, tail, null);
			tail.next = new_node;
			tail = tail.next;
			size++;
		}

	}

	@Override
	public Object[] toArray() {
		if (isEmpty()) {
			return null;
		} else {
			Object[] array = new Object[size];
			Node trav = head;
			int i = 0;
			while (trav != null) {
				array[i++] = trav.data;
				trav = trav.next;
			}
			return array;
		}

	}

	@Override
	public void addToHead(Object data) {
		if (isEmpty()) {
			head = tail = new Node(data, null, null);
			size++;
		} else {
			Node new_node = new Node(data, null, head);
			head = new_node;
			size++;
		}
	}

	@Override
	public Object peekFirst() {
		if (isEmpty()) {
			throw new RuntimeException("List is empty");
		}
		return head.data;
	}

	@Override
	public Object peekLast() {
		if (isEmpty()) {
			throw new RuntimeException("List is empty");
		}
		return tail.data;
	}

	@Override
	public Object removeFirst() {
		if (isEmpty()) {
			throw new RuntimeException("List is empty");
		}
		Object element = head.data;
		if (size == 1) {
			head = tail = null;
			size = 0;
			return element;
		} else {
			head.next.prev = null;
			head = head.next;
			size--;
			return element;
		}
	}

	@Override
	public Object removeLast() {
		if (isEmpty()) {
			throw new RuntimeException("List is empty");
		}
		Object element = tail.data;
		if (size == 1) {
			head = tail = null;
			size = 0;
			return element;
		} else {
			tail.prev.next = null;
			tail = tail.prev;
			size--;
			return element;
		}
	}

	@Override
	public boolean remove(Object element) {
		if (isEmpty()) {
			throw new RuntimeException("List is empty");
		}
		return false;
	}

	@Override
	public Object removeAt(int index) {
		if (isEmpty()) {
			throw new RuntimeException("List is empty");
		}
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
		int i = 0;
		Node trav = head;
		while(i!=index) {
			trav = trav.next;
			i++;
		}
		element = trav.data;
		trav.prev.next = trav.next;
		trav.next.prev = trav.prev;
		size--;
		return element;
	}

	@Override
	public int indexOf(Object element) {
		if (isEmpty()) {
			throw new RuntimeException("List is empty");
		}
		Node trav = head;
		int i = 0;
		while(trav!=null) {
			if(trav.data.equals(element)) {
				return i;
			}
			trav = trav.next;
			i++;
		}
		return -1;
	}

	@Override
	public void insert(int index, Object element) {
		// TODO Auto-generated method stub

	}

	private static class Node {
		private Object data;
		private Node prev;
		private Node next;

		Node(Object data, Node prev, Node next) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
	}

}
