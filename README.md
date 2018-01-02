# csc207assignment3

Welcome to the final CSC 207 programming assignment. You are free to use any IDE that you wish. This assignment is intended to help you practice basic Java Programming skills, navigate a bit of Java API and understand regular expressions better.

The main problem statement is more of a text analysis and you will learn how to read the contents of a webpage by building a Java application. The assignment requires you to write a program, which reads and analyzes the contents of the Google Scholar Page of an author.




In this assignment, you need to build a web scrapper for Google Scholar pages. Your program will read a list of Google Scholar URL?S, extract specific information and return the following information. At the end of the handout you can find a screenshot (see last page of this handout) with the location of all these information in a Google Scholar publication page of an Author:
vii. The total number of co-authors and all the co-authors? names in alphabetical order ? one name per line. Co-authors from each Author should be stored in a data structure (check Java Collection). Every time your program finds a co-author, the name of the co-author should be added in your data structure. You should avoid duplicates. If the name of the co-author already exists in your structure, you should not add it again. After visiting all the links from the input file, your program should print the total number of co-authors followed by a list of all the co-authors name in alphabetical order. You should print one co-authors name per line.

The program should receive two arguments at its command line: