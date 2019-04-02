package org.sudoku.validator.validators;

import java.util.Arrays;
import org.sudoku.validator.SudokuConstants;

/**
 * Checks if all the cell values are within range
 *
 */
public class ValueRangeValidator implements SudokuModelValidator {

    @Override
    public boolean validate(int[][] sudoku) {
        if (sudoku == null || sudoku.length == 0) {
            return false;
        }

        return Arrays.stream(sudoku)
                .flatMapToInt(Arrays::stream)
                .allMatch(n -> n >= SudokuConstants.MIN_VALUE && n <= SudokuConstants.MAX_VALUE);
    }
}
