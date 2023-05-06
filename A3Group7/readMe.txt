# Word tracker

## Date
Dec 09, 2022

## Author
Phi N

## INTRODUCTION

### What the program does.
The program takes a user input from the command line.
Then, it creates a Binary Tree of word objects in the provided file, they will be serialized in a repository.ser file.
Users have 3 options for printing information:
	1. Users can print all the words in alphabetic order along with the list of files that contain the word
	2. Users can print all the words in alphabetic order along with the list of files and numbers of the lines that contain the word
	3. Users can print all the words in alphabetic order along with the list of files, number of lines, and the occurence of the words

### REQUIREMENTS

Requires JDK 1.8 installed on the computer.

## INSTRUCTIONS

### How to run the program

1. Open command line and go the folder where WordTracker.jar file is located. Using cd .\ command

2. The program requires 3 arguments. 
	a. argument 1 is for the input file path
	b. argument 2 is for the type of processing of the words either 'pf', 'pl', or 'po'
		-pf: prints all the words in alphabetic order along with list of files that contain the word
		-pl: prints all the words in alphabetic order along with list of files and numbers of the lines that contain the word
		-po: prints all the words in alphabetic order along with list of files, numbers of the lines, and the occurrence of the words.
	c. argument 3 is for output file path

3. The input format is as follows:	

	java -jar WordTracker.jar <input.txt> -pf/-pl/-po [-f <output.txt>]

4. Example of valid input for the program:

	java -jar WordTracker.jar res/textfile.txt -pf -f res/output.txt

## TESTS

Various JUnit tests can be performed with this program.

## Completeness 
	100% 
	No deficiencies known by authors.
