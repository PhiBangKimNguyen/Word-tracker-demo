package utilities;

import java.io.Serializable;
import java.util.ArrayList;

public class Word implements Comparable<Word>, Serializable{

	private static final long serialVersionUID = 299023280854310934L;
	private String word;
	private ArrayList<Integer> line = new ArrayList<>();
	private ArrayList<String> fileName = new ArrayList<>();
	private int wordCount = 0;
	
	/**
	 * Constructor
	 * @param word
	 * @param line
	 * @param fileName
	 */
	public Word(String word, int line, String fileName) {
		super();
		this.word = word;
		this.line.add(line);
		this.fileName.add(fileName);
		wordCount++;
	}
		
	/**
	 * Get the word
	 * @return word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * Set the word
	 * @param word 
	 */
	public void setWord(String word) {
		this.word = word;
	}

	/**
	 * Get line
	 * @return line
	 */
	public ArrayList<Integer> getLine() {
		return line;
	}


	/**
	 * the line to set
	 * @param line 
	 */
	public void setLine(ArrayList<Integer> line) {
		this.line = line;
	}

	/**
	 * get file name
	 * @return fileName
	 */
	public ArrayList<String> getFileName() {
		return fileName;
	}

	/**
	 * the fileName to set
	 * @param fileName 
	 */
	public void setFileName(ArrayList<String> fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * Return the number of occurrence of word
	 * @return wordCount
	 */
	public int getWordCount() {
		return wordCount;
	}

	/**
	 * the wordCount to set
	 * @param wordCount 
	 */
	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}
	
	/**
	 * Counting word
	 * @param wordLine
	 * @param wordFileName
	 */
	public void wordCounter(int wordLine, String wordFileName) {
		// If file name already not found yet, just add line number and file name 
		if (!fileName.contains(wordFileName)) {
			fileName.add(wordFileName);
		}
		line.add(wordLine);			
		wordCount++;
	}

	/**
	 * Compare the word
	 * 
	 * @param word to be compared
	 * @return -1 if this object is less than the compared object, 
	 * 			0 if this object is equal to the compared object, 
	 * 			1 this object is greater than the compared object.
	 */
	@Override
	public int compareTo(Word word) {
		return this.word.compareTo(word.getWord());
	}	
}
