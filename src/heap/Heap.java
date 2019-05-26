package heap;

import arrays.IntDynamicArray;

/**
 * integer Heap implementation using a IntDynamicArray
 * 
 * @author Soumyadeep
 *
 */
public class Heap {
	private IntDynamicArray list = new IntDynamicArray();

	public void add(int element) {
		list.add(element);
		shiftUp();
	}

	//This method applies the heap invariant after adding an element to the heap
	private void shiftUp() {
		int k = list.size() - 1;
		while (k > 0) {
			int item = list.get(k);
			int p = (k - 1) / 2;
			int parent = list.get(p);
			if (parent < item) {
				// swap
				int temp = item;
				list.set(k, parent);
				list.set(p, temp);
				// move up one level
				k = p;
			} else {
				break;
			}
		}
	}
	
	public int poll() {
		int result = list.get(0);
		list.set(0, list.get(list.size()-1));
		list.removeAt(list.size()-1);
		shiftDown();
		return result;
		
	}

	//This method applies the heap invariant after polling an element from the heap
	private void shiftDown() {
		int p = 0;
		int l = 2*p+1;
		while(l<list.size()) {
			int max =l,r = l+1;
			//if the right child exists
			if(r<list.size()) {
				if(list.get(r)>list.get(max)) {
					max++;
				}
			}
			if(list.get(p)<list.get(max)) {
				//swap
				int temp = list.get(p);
				list.set(p, list.get(max));
				list.set(max, temp);
				p = max;
				l = 2*p+1;
			}
			else {
				break;
			}
		}
	}

	public int[] toArray() {
		if(isEmpty()) {
			return null;
		}
		return list.toStaticArray();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
}
