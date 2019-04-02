package org.sudoku.validator.validators;

import java.util.stream.IntStream;
import org.sudoku.validator.SudokuConstants;

/**
 * Checks for regional uniqueness
 *
 */
public class RegionValidator implements SudokuModelValidator {

    @Override
    public boolean validate(int[][] sudoku) {
        if (sudoku == null || sudoku.length == 0) {
            return false;
        }

        for (int regionRow = 0; regionRow < SudokuConstants.FIELD_SIZE; regionRow += SudokuConstants.REGION_SIZE) {
            for (int regionColumn = 0; regionColumn < SudokuConstants.FIELD_SIZE; regionColumn += SudokuConstants.REGION_SIZE) {
                IntStream.Builder builder = IntStream.builder();
                for (int row = regionRow; row < regionRow + SudokuConstants.REGION_SIZE; row++) {
                    for (int column = regionColumn; column < regionColumn + SudokuConstants.REGION_SIZE; column++) {
                        builder.add(sudoku[row][column]);
                    }
                }

                if (builder.build().distinct().count() != SudokuConstants.FIELD_SIZE) {
                    return false;
                }
            }
        }

        return true;
    }
}
