package problemDomain;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

import exception.TreeException;
import utilities.*;

/**
 * @param <E>
 *
 */
public class BSTree<E extends Comparable<? super E>> implements BSTreeADT<E> {
	private static final long serialVersionUID = 1L;
	private BSTreeNode<E> root;
	private int size = 0;

	/**
	 * Default constructor
	 */
	public BSTree() {
		this.root = null;
	}

	/**
	 * Constructor
	 * @param element
	 */
	public BSTree(E element) {
		this.root = new BSTreeNode<E>(element);
	}
	
	@Override
	public BSTreeNode<E> getRoot() throws TreeException {
		if (this.root == null) 
			throw new TreeException();
		return this.root;
	}
	
	/**
	 * Get height of tree
	 * @return 0 or height 
	 */
	public int getHeight() {
		return (this.root == null) ? 0 : getHeight(root);
	}
	
	/**
	 * Get height of tree
	 * @param node
	 * @return height left or height right
	 */
	private int getHeight(BSTreeNode<E> node) {
		if (node == null) 
			return 0;
		
		int leftHeight = getHeight(node.getLeft());
		int rightHeight = getHeight(node.getRight());
	
		return (leftHeight > rightHeight) ? (leftHeight + 1) : (rightHeight + 1);			
		
	}
	
	@Override
	public int size() {
		return this.size;
	}
	
	@Override
	public boolean isEmpty() {
		return root == null;
	}
	
	@Override
	public void clear() {
		this.root = null;
		this.size = 0;
	}

	@Override
	public boolean contains(E entry) throws TreeException {
		if (this.root == null) 
			throw new TreeException();			
		return search(entry) != null;
	}

	@Override
	public BSTreeNode<E> search(E entry) throws TreeException {
		if(root == null) 
			return null;
				
		BSTreeNode<E> curr = root;
		while(true) {
			if(entry.compareTo(curr.getElement()) < 0) {
				if(curr.getLeft() != null) 
					curr = curr.getLeft();
				else return null;				
			} else if(entry.compareTo(curr.getElement()) > 0) {
				if(curr.getRight() != null) 
					curr = curr.getRight(); 
				else return null;			
			} else return curr;			
		}	
	}
	

	@Override
	public boolean add(E newEntry) {
		if (newEntry == null) 
			throw new NullPointerException();
		
		BSTreeNode<E> newNode = new BSTreeNode<E>(newEntry, null, null);
		
		size++;
			
		if (root == null) {
			root = newNode;		
			return true;
		} else return root.add(newNode);		
	}
	

	@Override
	public Iterator<E> inorderIterator() {
		Queue<E> iteratorQueue = new LinkedList<>();
		inorderIterator(root, iteratorQueue);

		Iterator<E> iterator = new Iterator<E>() {
			@Override
			public boolean hasNext() {			
				return (iteratorQueue.peek() != null);			
			}
			@Override
			public E next() throws NoSuchElementException {
				return (!this.hasNext()) ? null : (E) iteratorQueue.remove();
			}
		};
		return iterator;
	}
	
	/**
	 * Iterating using in-order
	 * @param node
	 * @param queue
	 */
	private void inorderIterator(BSTreeNode<E> node, Queue<E> queue) {
		if (node == null) return;
			
		inorderIterator(node.getLeft(), queue);
		queue.add((E) node.getElement());
		inorderIterator(node.getRight(), queue);
	}

	@Override
	public Iterator<E> preorderIterator() {
		Queue<E> iteratorQueue = new LinkedList<>();
		preorderIterator(root, iteratorQueue);

		Iterator<E> iterator = new Iterator<E>() {
			@Override
			public boolean hasNext() {
				return (iteratorQueue.peek() != null);
			}
			@Override
			public E next() throws NoSuchElementException {		
				return (!this.hasNext()) ? null : (E) iteratorQueue.remove();
			}
		};
		return iterator;
	}
	
	/**
	 * Iterating using pre-order
	 * @param node
	 * @param queue
	 */
	private void preorderIterator(BSTreeNode<E> node, Queue<E> queue) {
		if (node == null) return;
			
		queue.add((E) node.getElement());
		preorderIterator(node.getLeft(), queue);
		preorderIterator(node.getRight(), queue);
	}

	@Override
	public Iterator<E> postorderIterator() {
		Queue<E> iteratorQueue = new LinkedList<>();
		postorderIterator(root, iteratorQueue);

		Iterator<E> iterator = new Iterator<E>() {
			@Override
			public boolean hasNext() {
				return (iteratorQueue.peek() != null);
			}
			@Override
			public E next() throws NoSuchElementException {		
				return (!this.hasNext()) ? null : (E) iteratorQueue.remove();
			}
		};
		return iterator;
	}
	
	/**
	 * Iterating using post-order
	 * @param node
	 * @param queue
	 */
	private void postorderIterator(BSTreeNode<E> node, Queue<E> queue) {
		if (node == null) return;	
		postorderIterator(node.getLeft(), queue);
		postorderIterator(node.getRight(), queue);
		queue.add((E) node.getElement());
	}
}
