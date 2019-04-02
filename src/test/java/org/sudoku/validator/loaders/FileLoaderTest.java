package org.sudoku.validator.loaders;

import java.net.URISyntaxException;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 */
public class FileLoaderTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    private FileLoader loader;

    @Before
    public void init() {
        loader = new FileLoader();
    }

    @Test
    public void testCompletelyValidFile() throws URISyntaxException {
        String path = "src/test/resources/valid.csv";
        int[][] expected = {
            {1, 6, 8, 4, 5, 7, 9, 3, 2},
            {5, 7, 2, 3, 9, 1, 4, 6, 8},
            {9, 3, 4, 6, 2, 8, 5, 1, 7},
            {8, 2, 9, 7, 4, 3, 1, 5, 6},
            {6, 5, 1, 2, 8, 9, 3, 7, 4},
            {7, 4, 3, 5, 1, 6, 2, 8, 9},
            {3, 9, 5, 8, 7, 2, 6, 4, 1},
            {4, 1, 7, 9, 6, 5, 8, 2, 3},
            {2, 8, 6, 1, 3, 4, 7, 9, 5}};

        int[][] result = loader.load(path);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testValidToReadButNotValidAnswer1() throws URISyntaxException {
        String path = "src/test/resources/validToRead1.csv";
        int[][] expected = {
            {1, 6, 8, 4, 5, 7, 9, 3, 2},
            {5, 7, 2, 3, 9, 1, 4, 6, 8},
            {9, 3, 4, 6, 2, 8, 5, 1, 7},
            {8, 2, 9, 7, 4, 3, 1, 5, 6},
            {6, 5, 1, 2, 8, 9, 3, 7, 4},
            {7, 4, 3, 5, 1, 6, 2, 8, 9},
            {2, 8, 6, 1, 3, 4, 7, 9, 5}};

        int[][] result = loader.load(path);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testValidToReadButNotValidAnswer2() throws URISyntaxException {
        String path = "src/test/resources/validToRead2.csv";
        int[][] expected = {
            {1, 6, 8, 4, 5, 7, 9, 3, 2},
            {5, 7, 2, 3, 9, 1, 4, 6, 8},
            {9, 3, 4, 6, 2, 8, 5, 1, 7},
            {8, 2, 9, 7, 4, 3, 1, 5, 6},
            {6, 5, 1, 2, 8, 9, 300, 7, 4},
            {7, 4, 3, 5, 1, 6, 215, 8, 9},
            {2, 8, 6, 1, 3, 4, 7, 9, 5}};

        int[][] result = loader.load(path);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testInvalidFileNotNumber1() throws URISyntaxException {
        String path = "src/test/resources/invalidNumber1.csv";

        exceptionRule.expect(SudokuLoadingException.class);
        exceptionRule.expectMessage("Invalid content: For input string");

        loader.load(path);
    }

    @Test
    public void testInvalidFileNotNumber2() throws URISyntaxException {
        String path = "src/test/resources/invalidNumber2.csv";

        exceptionRule.expect(SudokuLoadingException.class);
        exceptionRule.expectMessage("Invalid content: For input string");

        loader.load(path);
    }

    @Test
    public void testInvalidFileNotExits() throws URISyntaxException {
        String path = "src/test/resources/doesNotExist.csv";

        exceptionRule.expect(SudokuLoadingException.class);
        exceptionRule.expectMessage("invalid path: src/test/resources/doesNotExist.csv");

        loader.load(path);
    }
}
