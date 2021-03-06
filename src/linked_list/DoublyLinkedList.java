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
			size--;
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
			size--;
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
		if (indexOf(element) == -1) {
			return false;
		} else {
			removeAt(indexOf(element));
			return true;
		}
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
		// If the index is in between then go to that index and update the next and prev
		// references of previous and next element
		int i = 0;
		Node trav = head;
		while (i != index) {
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
		while (trav != null) {
			if (trav.data.equals(element)) {
				return i;
			}
			trav = trav.next;
			i++;
		}
		return -1;
	}

	@Override
	public void insert(int index, Object element) {
		if (isEmpty()) {
			throw new RuntimeException("List is empty");
		}
		if (index < 0 || index > size - 1) {
			throw new IllegalArgumentException("Index: " + index + " out of bounds");
		}
		Node new_node = new Node(element, null, null);
		if (index == 0) {
			addToHead(element);
		} else {
			int i = 0;
			Node trav = head;
			while (trav != null) {
				if (i == index) {
					trav.prev.next = new_node;
					new_node.prev = trav.prev;
					new_node.next = trav;
					size++;
				}
				trav = trav.next;
				i++;
			}
		}
	}
	
	public String toString() {
		if(isEmpty()) {
			return "[]";
		}
		Node trav = head;
		StringBuilder sb = new StringBuilder().append("[");
		while(trav!= null) {
			if(trav == tail) {
				sb.append(trav.data).append("]");
			}
			else {
			sb.append(trav.data).append(",");
			}
			trav = trav.next;
		}
		return sb.toString();
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

	/**
	 * @return true if the element is in the list else false
	 */
	@Override
	public boolean contains(Object element) {
		return !(indexOf(element) == -1);
	}

}
