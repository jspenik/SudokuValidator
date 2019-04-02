@ECHO off

SET SUDOKU_HOME=%~dp0\..

java -cp "%SUDOKU_HOME%"\lib\* org.sudoku.validator.ValidatorCLI %1
