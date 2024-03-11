import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList <T> extends BasicDoubleLinkedList<T> {
	public int numOfEntries;
	private BasicDoubleLinkedList<T> list;
	private Comparator<T> comp;
	
	public SortedDoubleLinkedList(Comparator<T> compareableObject) {
		numOfEntries = 0;
		list = new BasicDoubleLinkedList<>();
		comp = compareableObject;
	}
	//
	public void add(T data) {
		Node temp = firstNode;
		for (int i = 0; i < getSize(); i++) {
			if (comp.compare(temp.data, data) == 0) {
				temp.prev.next = temp.next;
				temp.next.prev = temp.prev;
			}
			temp = temp.next;
		}
	}
	
	public void addToEnd(T data) throws UnsupportedOperationException {
		// Do not implement
		throw new UnsupportedOperationException();
	}
	
	public void addToFront(T data) throws UnsupportedOperationException {
		// Do not implement
		throw new UnsupportedOperationException();
	}
	
	//
	public ListIterator<T> iterator() {
		return super.iterator();
	}
	
	//
	public BasicDoubleLinkedList<T>.Node remove(T data, Comparator<T> comparator) {
		return super.remove(data, comparator);
	}
}
