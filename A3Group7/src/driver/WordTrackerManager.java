package driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import exception.TreeException;
import problemDomain.BSTree;
import utilities.BSTreeNode;
import utilities.Iterator;
import utilities.Word;

public class WordTrackerManager {
	/**
	 * Build binary search tree
	 * @param wordsTree
	 * @param inputFileName
	 * @return wordsTree
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws TreeException
	 */
	static BSTree<Word> buildBSTree(BSTree<Word> wordsTree, String inputFileName) throws FileNotFoundException, IOException, TreeException {		
			Scanner scanner = new Scanner(new FileReader(new File(inputFileName)));
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("res/repository.ser"));
			int lineNumber = 0;
			
			//read file 
			while (scanner.hasNextLine()) {
				lineNumber++;				
				String[] wordsArray = scanner.nextLine().split("[^\\w']+");				
				// Loop through list of word and retrieve word when found
				for (String string : wordsArray) {
					if(wordsArray.length == 0) continue;										
					if (string != null) {
						BSTreeNode<Word> foundWords =  wordsTree.search(new Word(string.toUpperCase(), lineNumber, inputFileName));
						if (foundWords != null) foundWords.getElement().wordCounter(lineNumber, inputFileName);							
						else wordsTree.add(new Word(string.toUpperCase(), lineNumber, inputFileName));																															
					}
				}
			}
			Iterator<Word> iterator = wordsTree.inorderIterator();
			while (iterator.hasNext()) oos.writeObject((Word) iterator.next());						  			  			
			scanner.close();
			oos.close();		
			return wordsTree;
	}
	
	/**
	 * Execute user command
	 * @param wordsTree
	 * @param option
	 * @param ouputFileName
	 * @throws TreeException
	 * @throws FileNotFoundException
	 */
	static void executeCommand(BSTree<Word> wordsTree, String option, String ouputFileName) throws TreeException, FileNotFoundException {
		PrintWriter pw = new PrintWriter(ouputFileName);
		switch (option) {
			case "-pf": 						
					inOrder(wordsTree.getRoot(), pw, "-pf");
					pw.flush();			
				    break;		
			case "-pl": 					
					inOrder(wordsTree.getRoot(), pw, "-pl");
					pw.flush();
					break;	
			case "-po":			
					inOrder(wordsTree.getRoot(), pw, "-po");
					pw.flush();		
					break;		
			default:
					pw.close();
					throw new IllegalArgumentException("Unexpected input: " + option);
		}
	}
	
	/**
	 * Print the word in alphabetical order, file name 
	 * @param node
	 * @param pw
	 */
	public static void inOrder(BSTreeNode<Word> node, PrintWriter pw, String option) {
		if (node == null) return; 		
	    inOrder(node.getLeft(), pw, option);	    	    
	    printResult(node, pw, option);
	    inOrder(node.getRight(), pw, option);
	}
	
	public static void printResult(BSTreeNode<Word> node, PrintWriter pw, String type) {
		String result;
		switch (type) {
			case "-pf": 						
					result = String.format("Word: %s %nFile Name: %s %n", 
			    		node.getElement().getWord(), node.getElement().getFileName());
					System.out.println(result);
				    pw.println(result);
				    break;		
			case "-pl": 					
					result = String.format("Word: %s %nFile Name: %s %nLine Number: %s %n", 
			    		node.getElement().getWord(), node.getElement().getFileName(), node.getElement().getLine());
					System.out.println(result);
				    pw.println(result);
					break;	
			case "-po":			
					result = String.format("Word: %s %nFile Name: %s %nLine Number: %s %nWord Count: %s %n", 
							node.getElement().getWord(), node.getElement().getFileName(), node.getElement().getLine(), node.getElement().getWordCount());
					System.out.println(result);
				    pw.println(result);
					break;		
			default:
					pw.close();
					throw new IllegalArgumentException("Unexpected input: " + type);
		}	        
	}
}


