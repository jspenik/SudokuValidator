package org.sudoku.validator;

/**
 *
 */
public final class SudokuConstants {

    public static final int FIELD_SIZE = 9;
    public static final int REGION_SIZE = 3;
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;

    private SudokuConstants() {
        throw new IllegalStateException();
    }
}
