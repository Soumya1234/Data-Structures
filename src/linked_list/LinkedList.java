package linked_list;

public interface LinkedList {
	int size();
	boolean isEmpty();
	void clear();
	void add(Object data);
	Object[] toArray();
	void addToHead(Object data);
	Object peekFirst();
	Object peekLast();
	Object removeFirst();
	Object removeLast();
	boolean remove(Object element);
	Object removeAt(int index);
	int indexOf(Object element);
	
	
}
