package utilities;

public class BSTreeNode<E extends Comparable<? super E>> {
	private E element;
	private BSTreeNode<E> left, right;
	
	/**
	 * Initializes a BSTreeNode object
	 */
	public BSTreeNode() {};
	
	/**
	 * Initializes a BSTreeNode object
	 * @param element
	 */
	public BSTreeNode(E element) {
		this.element = element;
		this.left = null;
		this.right = null;
	}
	
	/**
	 * Initializes a BSTreeNode object
	 * @param element
	 * @param left
	 * @param right
	 */
	public BSTreeNode(E element, BSTreeNode<E> left, BSTreeNode<E> right) {
		this.element = element;
		this.left = left;
		this.right = right;
	}
	
	/**
     * Get element
     * @return element
     */
	public E getElement() {
		return this.element;
	}
	
	/**
	 * Set the element
	 * @param element the element to set
	 */
	public void setElement(E element) {
		this.element = element;
	}

	/**
	 * Get left child
	 * @return the left
	 */
	public BSTreeNode<E> getLeft() {
		return left;
	}

	/**
	 * Set left child
	 * @param left 
	 */
	public void setLeft(BSTreeNode<E> left) {
		this.left = left;
	}

	/**
	 * Get right child
	 * @return the right
	 */
	public BSTreeNode<E> getRight() {
		return right;
	}

	/**
	 * Set right child
	 * @param right
	 */
	public void setRight(BSTreeNode<E> right) {
		this.right = right;
	}
    
	/**
	 * Adds a new element to the tree according to the natural ordering
	 * established by the Comparable implementation.
	 * @param node 
	 * @return true if the element is added. false if otherwise.
	 */
	public boolean add(BSTreeNode<E> node) {	
		if (node.element.compareTo(this.element) < 0) {
			if (left != null) left.add(node);					
			else left = node;				
		} else if (node.element.compareTo(this.element) > 0) {
			if (right != null) right.add(node);		
			else right = node;				
		} 
		return (node == null || node.element.equals(this.element)) ? false : true;	
	}
}
