package utilities;

import java.util.ArrayList;

public class WordLocation {
	private ArrayList<Integer> line = new ArrayList<>();
	private String fileName;
	
	/**
	 * Constructor
	 * @param line
	 * @param fileName
	 */
	public WordLocation(ArrayList<Integer> line, String fileName) {
		super();
		this.line = line;
		this.fileName = fileName;
	}
	/**
	 * Get the line
	 * @return the line
	 */
	public ArrayList<Integer> getLine() {
		return line;
	}
	/**
	 * Set the line
	 * @param line 
	 */
	public void setLine(ArrayList<Integer> line) {
		this.line = line;
	}
	/**
	 * Get the file name
	 * @return fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * Set the file name
	 * @param fileName 
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
