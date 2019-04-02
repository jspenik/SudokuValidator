package org.sudoku.validator.validators;

import java.util.stream.IntStream;
import org.sudoku.validator.SudokuConstants;

/**
 * Checks if the column uniqueness rule applies
 *
 */
public class ColumnValidator implements SudokuModelValidator {

    @Override
    public boolean validate(int[][] sudoku) {
        if (sudoku == null || sudoku.length == 0) {
            return false;
        }

        for (int column = 0; column < SudokuConstants.FIELD_SIZE; column++) {
            IntStream.Builder builder = IntStream.builder();
            for (int row = 0; row < SudokuConstants.FIELD_SIZE; row++) {
                builder.add(sudoku[row][column]);
            }
            if (builder.build().distinct().count() != SudokuConstants.FIELD_SIZE) {
                return false;
            }
        }

        return true;
    }
}
