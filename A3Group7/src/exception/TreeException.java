package exception;

public class TreeException extends Throwable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Default constructor
	 */
	public TreeException() {
		super("Tree is empty.");
	}
}
