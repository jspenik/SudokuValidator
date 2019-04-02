Sudoku Validator
================
This simple application's aim is to validate an input file and write to stdout
whether the content is a valid 9x9 Sudoku puzzle or not.

How to use the program
----------------------
In the bin folder there are two files for starting the program:
- sudokuValidator.sh
- sudokuValidator.bat

Note: you need to either make sure that the java command-line executable is on
the PATH, or modify the files above to point to it. The Java version has to be 
8+

Expected input arguments
------------------------
The program expects one and only one argument: the file to be tested. The format
of the input file has be the following:

1,2,3,4,5,6,7,8,9
1,2,3,4,5,6,7,8,9
1,2,3,4,5,6,7,8,9
1,2,3,4,5,6,7,8,9
1,2,3,4,5,6,7,8,9
1,2,3,4,5,6,7,8,9
1,2,3,4,5,6,7,8,9
1,2,3,4,5,6,7,8,9
1,2,3,4,5,6,7,8,9

Output
------
- If the solution is good, the program will not emit any messages, but returns
  with 0 as the exit code

- If the mandatory input file argument is missing or too many arguments are given,
  the exit code is -1, the displayed message is:
  missing input file or too many arguments

- In case the input file does not contain a valid Sudoku puzzle format or the
  solution is invalid, the exit code is -2 and the dislayed message is
  invalid solution

- If any kind of exception is thrown, the exit code is -3 and the error message
  itself will be shown

Sample files
------------
There are some sample files in the folder named 'samples' which can be used for
testing purposes.
- valid.csv: a completely valid Sudoku solution
- invalid.csv: a not valid Sudoku solution
- invalidNumber1.csv: the first number is missing. Should be used for testing invalid
  input file format
- invalidNumber2.csv: one of the numbers is replaced with an 'i'. Should be used
  for test with invalid input file format