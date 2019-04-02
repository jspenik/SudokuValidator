package org.sudoku.validator.validators;

import java.util.Arrays;
import java.util.stream.IntStream;
import org.sudoku.validator.SudokuConstants;

/**
 * Checks if the length of the rows are proper
 *
 */
public class RowLengthValidator implements SudokuModelValidator {

    @Override
    public boolean validate(int[][] sudoku) {
        if (sudoku == null || sudoku.length == 0) {
            return false;
        }

        return Arrays.stream(sudoku)
                .map(Arrays::stream)
                .mapToLong(IntStream::count)
                .allMatch(count -> count == SudokuConstants.FIELD_SIZE);
    }
}
