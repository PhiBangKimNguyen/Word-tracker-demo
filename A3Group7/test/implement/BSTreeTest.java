package implement;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exception.TreeException;
import problemDomain.BSTree;
import utilities.Iterator;

class BSTreeTest {
	BSTree<Integer> tree = new BSTree<Integer>();
	BSTree<Integer> intBST = new BSTree<Integer>();
	BSTree<String> strBST = new BSTree<String>();	
	@BeforeEach
	void setUp() throws Exception {
		intBST.add(2);
		intBST.add(1);
		intBST.add(3);
		strBST.add("a");
		strBST.add("b");
		strBST.add("c");
	}

	@AfterEach
	void tearDown() throws Exception {
		intBST.clear();
		strBST.clear();
	}

	@Test
	public void testGetRoot() throws TreeException {
		assertEquals("a", strBST.getRoot().getElement());
		assertEquals(2, intBST.getRoot().getElement());
	}

	@Test
	public void testGetHeight() {				
		tree.add(5);
		tree.add(3);
		tree.add(7);
		
		assertEquals(tree.getHeight(), 2);		
	}

	@Test
	public void testSize() {
		tree.add(4);
		tree.add(2);
		tree.add(3);

		assertNotEquals(tree.size(), 5);
		assertEquals(tree.size(), 3);
	}

	@Test
	public void testIsEmpty() {
		assertTrue(tree.isEmpty());
	}

	@Test
	public void testClear() {
		strBST.clear();
		assertEquals(0, strBST.size());
	}

	@Test
	public void testContains() throws TreeException {
		tree.add(1);			
		assertTrue(tree.contains(1));
		assertFalse(tree.contains(100));
	}
	
	@Test
	public void testSearch() throws TreeException {
		tree.add(1);
		tree.add(2);
		
		assertEquals(tree.search(1).getElement(), 1);
		assertEquals(tree.search(2).getElement(), 2);
		// 50 not in tree
		assertEquals(tree.search(50), null);
	}

	@Test
	public void testAdd() {
		tree.add(1);
		tree.add(2);

		try {
			assertEquals(tree.getRoot().getElement(), 1);
		} catch (TreeException e) {
			fail(e);
		}
	}

	@Test
	public void testInorderIterator() {
		Iterator<Integer> intIterator = intBST.inorderIterator();	
		assertEquals(1, intIterator.next());
		assertEquals(2, intIterator.next());
		assertEquals(3, intIterator.next());
	}

	@Test
	public void testPreorderIterator() {
		Iterator<Integer> intIterator = intBST.preorderIterator();	
		assertEquals(2, intIterator.next());
		assertEquals(1, intIterator.next());
		assertEquals(3, intIterator.next());
	}

	@Test
	public void testPostorderIterator() {
		Iterator<Integer> intIterator = intBST.postorderIterator();
		assertEquals(1, intIterator.next());
		assertEquals(3, intIterator.next());
		assertEquals(2, intIterator.next());
	}
}
