import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> extends Object implements Iterable<T> {
	private int numOfEntries = 0;
	public Node firstNode = null;
	public Node lastNode = null;
	public class Node {
		T data;
		Node prev;
		Node next;
		
		public Node(T dataNode) {
			data = dataNode;
			
		}
	}
		
	public class DoubleLinkedListIterator extends Object implements ListIterator<T> {
		Node head; 
		public DoubleLinkedListIterator() {
			head = firstNode;
		}
		
		public boolean hasNext() {
			return head.next != null;
		}
		
		public T next() throws NoSuchElementException {
			T data;
			data = head.data;
			head = head.next;
			return(data);
		}
		
		public boolean hasPrevious() {
			return head.prev != null;
		}
		
		public T previous() throws NoSuchElementException {
			T data;
			if (hasPrevious()) {
				data = head.data;
				head = head.prev;
				return(data);
			} else
				throw new NoSuchElementException();
		}
		
		public void remove() throws UnsupportedOperationException {
			// Do not implement
			throw new UnsupportedOperationException();
		}
		
		public void add(T arg0) throws UnsupportedOperationException {
			// Do not implement
			throw new UnsupportedOperationException();
		}
		
		public int nextIndex() throws UnsupportedOperationException {
			// Do not implement
			throw new UnsupportedOperationException();
		}
		
		public int previousIndex() throws UnsupportedOperationException {
			// Do not implement
			throw new UnsupportedOperationException();
		}
		
		public void set(T arg0) throws UnsupportedOperationException {
			// Do not implement
			throw new UnsupportedOperationException();
		}
	}
	
	public int getSize() {
		return numOfEntries;
	}
	
	public void addToEnd(T data) {
		Node newNode = new Node(data);
		if (lastNode != null) {
			if (lastNode.prev == null) {
				firstNode = lastNode;
			}
			newNode.prev = lastNode;
			lastNode = newNode;
		} else {
			lastNode = newNode;
		}
		numOfEntries++;
	}
	
	public void addToFront(T data) {
		Node newNode = new Node(data);
		if (firstNode != null) {
			newNode.next = firstNode;
			firstNode.prev = newNode;
			firstNode = newNode;
		} else {
			firstNode = newNode;
		}
		numOfEntries++;
	}
	
	public T getFirst() {
		return firstNode.data;
	}
	
	public T getLast() {
		return lastNode.data;
	}
	
	public ListIterator<T> iterator() {
		return new DoubleLinkedListIterator();
	}
	
	public BasicDoubleLinkedList<T>.Node remove(T targetData, Comparator<T> comparator) {
		Node temp = firstNode;
		for (int i = 0; i < getSize(); i++) {
			if (comparator.compare(temp.data, targetData) == 0) {
				if (temp.prev != null) {
					temp.prev.next = temp.next;
				}
				if (temp.next != null) {
					temp.next.prev = temp.prev;
				}
				numOfEntries--;
				return temp;
			}
			temp = temp.next;
		}
		return null;
	}
	
	public T retrieveFirstElement() {
		T temp = firstNode.data;
		firstNode = firstNode.next;
		return temp;
	}
	
	public T retrieveLastElement() {
		T temp = lastNode.data;
		lastNode = lastNode.prev;
		return temp;
	}
	
	public ArrayList<T> toArrayList() {
		ListIterator<T> x = iterator();
		ArrayList<T> temp = new ArrayList<>();
		for (int i = 0; i < getSize(); i++) {
			temp.add(x.next());
		}
		return temp;
	}
}
