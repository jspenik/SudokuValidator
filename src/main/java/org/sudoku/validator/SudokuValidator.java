package org.sudoku.validator;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.sudoku.validator.validators.ColumnLengthValidator;
import org.sudoku.validator.validators.ColumnValidator;
import org.sudoku.validator.validators.RegionValidator;
import org.sudoku.validator.validators.RowLengthValidator;
import org.sudoku.validator.validators.RowValidator;
import org.sudoku.validator.validators.SudokuModelValidator;
import org.sudoku.validator.validators.ValueRangeValidator;

/**
 *
 */
public class SudokuValidator {

    private final Collection<SudokuModelValidator> validators = Stream.of(
            new RowLengthValidator(),
            new ColumnLengthValidator(),
            new ValueRangeValidator(),
            new RowValidator(),
            new ColumnValidator(),
            new RegionValidator())
            .collect(Collectors.toSet());

    public boolean validate(int[][] sudoku) {
        return validators.stream().map(validator -> validator.validate(sudoku)).noneMatch(result -> !result);
    }
}
