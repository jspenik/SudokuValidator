package org.sudoku.validator.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class RowLengthValidatorTest {

    private RowLengthValidator validator;

    @Before
    public void init() {
        validator = new RowLengthValidator();
    }

    @Test
    public void testValid() {
        int[][] sudoku = {
            {1, 6, 8, 4, 5, 7, 9, 3, 2},
            {5, 7, 2, 3, 9, 1, 4, 6, 8},
            {9, 3, 4, 6, 2, 8, 5, 1, 7},
            {8, 2, 9, 7, 4, 3, 1, 5, 6},
            {6, 5, 1, 2, 8, 9, 3, 7, 4},
            {7, 4, 3, 5, 1, 6, 2, 8, 9},
            {3, 9, 5, 8, 7, 2, 6, 4, 1},
            {4, 1, 7, 9, 6, 5, 8, 2, 3},
            {2, 8, 6, 1, 3, 4, 7, 9, 5}};

        boolean result = validator.validate(sudoku);

        assertTrue(result);
    }

    @Test
    public void testInvalidNull() {
        int[][] sudoku = null;

        boolean result = validator.validate(sudoku);

        assertFalse(result);
    }

    @Test
    public void testInvalidEmpty() {
        int[][] sudoku = {};

        boolean result = validator.validate(sudoku);

        assertFalse(result);
    }

    @Test
    public void testInvalidTooShort() {
        int[][] sudoku = {
            {1, 6, 8, 4, 5, 7, 9, 3},
            {5, 7, 2, 3, 9, 1, 4, 6, 8},
            {9, 3, 4, 6, 2, 8, 5, 1, 7},
            {8, 2, 9, 7, 4, 3, 1, 5, 6},
            {6, 5, 1, 2, 8, 9, 3, 7, 4},
            {7, 4, 3, 5, 1, 6, 2, 8, 9},
            {3, 9, 5, 8, 7, 2, 6, 4, 1},
            {4, 1, 7, 9, 6, 5, 8, 2, 3},
            {2, 8, 6, 1, 3, 4, 7, 9, 5}};

        boolean result = validator.validate(sudoku);

        assertFalse(result);
    }

    @Test
    public void testInvalidTooLong() {
        int[][] sudoku = {
            {1, 6, 8, 4, 5, 7, 9, 3, 2, 4},
            {5, 7, 2, 3, 9, 1, 4, 6, 8},
            {9, 3, 4, 6, 2, 8, 5, 1, 7},
            {8, 2, 9, 7, 4, 3, 1, 5, 6},
            {6, 5, 1, 2, 8, 9, 3, 7, 4},
            {7, 4, 3, 5, 1, 6, 2, 8, 9},
            {3, 9, 5, 8, 7, 2, 6, 4, 1},
            {4, 1, 7, 9, 6, 5, 8, 2, 3},
            {2, 8, 6, 1, 3, 4, 7, 9, 5}};

        boolean result = validator.validate(sudoku);

        assertFalse(result);
    }
}
