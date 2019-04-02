package org.sudoku.validator.loaders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 *
 */
public class FileLoader implements SudokuLoader<String> {

    @Override
    public int[][] load(String inputPath) throws SudokuLoadingException {
        try {
            Path path = Paths.get(inputPath);
            return Files.lines(path)
                    .map(s -> s.split(","))
                    .map(Arrays::stream)
                    .map(stream -> stream.mapToInt(Integer::valueOf))
                    .map(IntStream::toArray)
                    .toArray(int[][]::new);
        } catch (InvalidPathException | IOException ex) {
            throw new SudokuLoadingException("invalid path: " + inputPath);
        } catch (NumberFormatException | NullPointerException ex) {
            throw new SudokuLoadingException("Invalid content: " + ex.getMessage());
        }
    }
}
