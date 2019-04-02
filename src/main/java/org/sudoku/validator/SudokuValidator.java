package org.sudoku.validator;

import java.util.Collection;
import org.sudoku.validator.validators.SudokuModelValidator;

/**
 *
 */
public class SudokuValidator {

    private final Collection<SudokuModelValidator> validators;

    public SudokuValidator(Collection<SudokuModelValidator> validators) {
        this.validators = validators;
    }

    public boolean validate(int[][] sudoku) {
        return validators.stream().map(validator -> validator.validate(sudoku)).noneMatch(result -> !result);
    }
}
