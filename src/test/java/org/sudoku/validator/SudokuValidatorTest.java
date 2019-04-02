package org.sudoku.validator;

import org.junit.Assert;
import org.junit.Ignore;

/**
 *
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
@Ignore
public class SudokuValidatorTest {

    //@Autowired
    private SudokuValidator sudokuValidator;

    //@Test
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

        boolean result = sudokuValidator.validate(sudoku);

        Assert.assertTrue(result);
    }
}
