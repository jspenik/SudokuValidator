package org.sudoku.validator.validators;

import org.sudoku.validator.SudokuConstants;

/**
 * Checks if the length of columns are proper
 *
 */
public class ColumnLengthValidator implements SudokuModelValidator {

    @Override
    public boolean validate(int[][] sudoku) {
        return sudoku != null && sudoku.length == SudokuConstants.FIELD_SIZE;
    }
}
