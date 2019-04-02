package org.sudoku.validator;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.sudoku.validator.loaders.FileLoader;
import org.sudoku.validator.loaders.SudokuLoadingException;
import org.sudoku.validator.validators.ColumnLengthValidator;
import org.sudoku.validator.validators.ColumnValidator;
import org.sudoku.validator.validators.RegionValidator;
import org.sudoku.validator.validators.RowLengthValidator;
import org.sudoku.validator.validators.RowValidator;
import org.sudoku.validator.validators.ValueRangeValidator;

/**
 *
 */
public class ValidatorCLI {

    public static void main(String[] args) {
        checkArguments(args);
        try {
            final SudokuValidator sudokuValidator = new SudokuValidator(Stream.of(
                    new RowLengthValidator(),
                    new ColumnLengthValidator(),
                    new ValueRangeValidator(),
                    new RowValidator(),
                    new ColumnValidator(),
                    new RegionValidator())
                    .collect(Collectors.toSet()));
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
