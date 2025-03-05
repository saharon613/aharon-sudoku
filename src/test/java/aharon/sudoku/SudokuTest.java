package aharon.sudoku;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SudokuTest {
    @Test
    void getErrors() {
        //given
        int[][] board = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {3, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };

        Sudoku game = new Sudoku(board);

        //when
        List<String> colErrors = game.getColErrors();
        List<String> rowErrors = game.getRowErrors();
        List<String> boxErrors = game.getBoxErrors();

        //then
        assertEquals(List.of("Duplicate of 3 in row 8, column 0"), colErrors);
        assertEquals(List.of("Duplicate of 3 in row 1, column 6"), rowErrors);
        assertEquals(List.of("Duplicate of 3 in box 1"), boxErrors);

    }
}

