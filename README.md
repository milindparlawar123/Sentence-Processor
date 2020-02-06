# CSX42: Assignment 1
## Name: Milind Keshav Parlawar

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in wordPlay/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile wordPlay/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile wordPlay/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile wordPlay/src/build.xml run -Darg0="input.txt" -Darg1="output.txt" -Darg2="metrics.txt"

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description:
 Flow of the project:
  1. Driver class takes 3 arguments as input file name, output file name and metrics file name.
  2.Validator classes validates whether all inputs files provided or not
  3.After that FileProcessor class starts opening the file if it is valid else throws exception and starts to read content of file till period.
  4.SentenceProcessor takes sentence as input from FileProcessor and starts processing like reversing words
  5.MatricCalculator takes sentence as input from SsntenceProcessor to process further like sentences counting, words counting and chars counting.
  6.Results class is to write reversed sentences to output file and AVG_NUMBER_WORDS_PER_SENTENCE,AVG_NUM_CHARS_PER_SENTENCE,      MAX_FREQ_WORD and LONGEST_WORD to metrics file
 
 Note: I am reading chars till period as sentence. Sentence can have new line character and it will be considered as one sentence.
 
 Data Structure: 
  I have used HashMap data structure in this assignemt to get max frequency word and longest word. Reason behind using HashMap 
  is best case time complexity is O(1).
  Hashmap best and average case for Search, Insert and Delete is O(1) and worst case is O(n).

 References: 

  https://javabypatel.blogspot.com/2015/10/time-complexity-of-hashmap-get-and-put-operation.html
  https://www.journaldev.com/20601/java-bufferedwriter
  https://www.journaldev.com/19879/java-bufferedreade


-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: 06/02/2020


