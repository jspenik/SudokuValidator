package org.sudoku.validator.loaders;

/**
 *
 * @param <InputSourceType>
 */
public interface SudokuLoader<InputSourceType> {

    public int[][] load(InputSourceType inputSource);
}
