package org.sudoku.validator;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;
import org.sudoku.validator.validators.SudokuModelValidator;

/**
 *
 */
public class SudokuValidatorTest {

    private SudokuValidator sudokuValidator;

    @Test
    public void testAllValid() {
        SudokuModelValidator validator1 = mock(SudokuModelValidator.class);
        when(validator1.validate(any())).thenReturn(Boolean.TRUE);
        SudokuModelValidator validator2 = mock(SudokuModelValidator.class);
        when(validator2.validate(any())).thenReturn(Boolean.TRUE);

        sudokuValidator = new SudokuValidator(Arrays.asList(validator1, validator2));

        boolean result = sudokuValidator.validate(any());

        Assert.assertTrue(result);
    }

    @Test
    public void testSomeValid() {
        SudokuModelValidator validator1 = mock(SudokuModelValidator.class);
        when(validator1.validate(any())).thenReturn(Boolean.TRUE);
        SudokuModelValidator validator2 = mock(SudokuModelValidator.class);
        when(validator2.validate(any())).thenReturn(Boolean.FALSE);

        sudokuValidator = new SudokuValidator(Arrays.asList(validator1, validator2));

        boolean result = sudokuValidator.validate(any());

        Assert.assertFalse(result);
    }
}
