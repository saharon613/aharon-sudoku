package aharon.sudoku;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class SudokuFrameTest {
    private SudokuFrame board;

    @BeforeEach
    void setUp() {
        board = new SudokuFrame();
    }

    @Test
    void testCheckBoard() {
        board.textFields[1][0].setText("6");
        board.checkBoard();
        assertTrue(board.sudoku.getErrors().isEmpty());
        assertEquals(Color.WHITE, board.textFields[1][0].getBackground());

        board.textFields[1][0].setText("");

        board.textFields[1][0].setText("3");
        board.checkBoard();
        assertFalse(board.sudoku.getErrors().isEmpty());
        assertEquals(Color.RED, board.textFields[1][0].getBackground());
    }
}
