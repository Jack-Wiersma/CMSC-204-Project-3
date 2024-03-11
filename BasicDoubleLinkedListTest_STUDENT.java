
/**
 * You must implement the following test case methods
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasicDoubleLinkedListTest_STUDENT {

	BasicDoubleLinkedList<String> test;
	
	@BeforeEach
	void setUp() throws Exception {
		test = new BasicDoubleLinkedList<>();
	}

	@AfterEach
	void tearDown() throws Exception {
		test = null;
	}

	@Test
	void testGetSize() {
		test.addToFront("Entry 1");
		test.addToFront("Entry 2");
		test.addToFront("Entry 3");
		assertEquals(test.getSize(), 3);
	}

	@Test
	void testAddToEnd() {
		test.addToEnd("Entry 1");
	}

	@Test
	void testAddToFront() {
		test.addToFront("Entry 1");
	}

	@Test
	void testGetFirst() {
		test.addToEnd("Entry 1");
		assertTrue(test.getLast().equals("Entry 1"));
	}

	@Test
	void testGetLast() {
		test.addToEnd("Entry 1");
		assertTrue(test.getLast().equals("Entry 1"));
	}

	@Test
	void testIterator() {
		test.addToFront("Entry 3");
		test.addToFront("Entry 2");
		test.addToFront("Entry 1");
		ListIterator<String> x = test.iterator();
		assertEquals(x.next(), "Entry 1");
		assertEquals(x.next(), "Entry 2");
		assertEquals(x.next(), "Entry 3");
	}

	@Test
	void testRemove() {
		 class StringComparator implements Comparator<String> {
			public int compare(String x, String y) {
				if (x.equals(y)) {
					return 0;
				} else {
					return -1;
				}
			}
		}
		Comparator<String> x = new StringComparator();
		test.addToFront("Entry 1");
		assertEquals(test.remove("Entry 1", x).data, "Entry 1");
		
	}

	@Test
	void testRetrieveFirstElement() {
		test.addToFront("Entry 3");
		test.addToFront("Entry 2");
		test.addToFront("Entry 1");
		assertEquals(test.retrieveFirstElement(), "Entry 1");
		assertEquals(test.retrieveFirstElement(), "Entry 2");
		assertEquals(test.retrieveFirstElement(), "Entry 3");
	}

	@Test
	void testRetrieveLastElement() {
		test.addToEnd("Entry 1");
		test.addToEnd("Entry 2");
		test.addToEnd("Entry 3");
		assertEquals(test.retrieveLastElement(), "Entry 3");
		assertEquals(test.retrieveLastElement(), "Entry 2");
		assertEquals(test.retrieveLastElement(), "Entry 1");
	}

	@Test
	void testToArrayList() {
		test.addToFront("Entry 3");
		test.addToFront("Entry 2");
		test.addToFront("Entry 1");
		ArrayList<String> x = test.toArrayList();
		assertEquals(x.get(0), "Entry 1");
		assertEquals(x.get(1), "Entry 2");
		assertEquals(x.get(2), "Entry 3");
	}

}
