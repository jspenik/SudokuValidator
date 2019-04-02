package org.sudoku.validator;

import org.sudoku.validator.loaders.FileLoader;
import org.sudoku.validator.loaders.SudokuLoadingException;

/**
 *
 */
public class ValidatorCLI {

    public static void main(String[] args) {
        checkArguments(args);
        try {
            final SudokuValidator sudokuValidator = new SudokuValidator();
            final FileLoader sudokuLoader = new FileLoader();

            int[][] sudoku = sudokuLoader.load(args[0]);
            if (sudokuValidator.validate(sudoku)) {
                System.exit(0);
            } else {
                exitWithError(-2, "invalid solution");
            }
        } catch (SudokuLoadingException e) {
            exitWithError(-3, e.getMessage());
        }
    }

    private static void checkArguments(String... args) {
        if (args == null || args.length != 1) {
            exitWithError(-1, "missing input file or too many arguments");
        }
    }

    private static void exitWithError(int errorCode, String errorMessaage) {
        System.err.println(errorMessaage);
        System.exit(errorCode);
    }
}
