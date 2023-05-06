package driver;

import java.io.*;

import exception.TreeException;
import problemDomain.BSTree;
import utilities.*;

/**
 * A program that keep track of every word.
 * The program requires the user to run via command line
 * @author Phi N
 *
 */
public class WordTracker {
	public static void main(String[] args) throws TreeException, IOException {
		BSTree<Word> wordsTree = new BSTree<Word>();
		String inputFileName = null;
		String option = null;
		String outputFileName = null ;
		
		if (args.length >= 2) {
			inputFileName = args[0];
			option = args[1];					
			outputFileName = args.length == 4 ? args[3] : null;				
		} 			
		
		WordTrackerManager.buildBSTree(wordsTree, inputFileName);
		WordTrackerManager.executeCommand(wordsTree, option, outputFileName);	
		//WordTrackerManager.buildBSTree(wordsTree, "res/textfile.txt");
		//WordTrackerManager.executeCommand(wordsTree, "-po", "res/output.txt");
	} 
}
	
	