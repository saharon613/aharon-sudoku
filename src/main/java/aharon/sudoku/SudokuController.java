package aharon.sudoku;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SudokuController {
    private final Sudoku sudoku;
    private final SudokuFrame frame;

    public SudokuController(Sudoku sudoku, SudokuFrame frame) {
        this.sudoku = sudoku;
        this.frame = frame;
    }

    public void readGui() {
        JTextField[][] cells = frame.textFields;
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                String cellText = cells[row][col].getText();
                if (!cellText.isEmpty()) {
                    try
                    {
                        int value = Integer.parseInt(cellText);
                        sudoku.board[row][col] = value;
                    }
                    catch (NumberFormatException e) {
                        sudoku.board[row][col] = 0;
                    }
                }
            }
        }
    }

    public void highlightErrors() {
        List<SudokuError> errors = sudoku.getErrors();
        JTextField[][] textFields = frame.textFields;

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                textFields[row][col].setBackground(Color.WHITE);
            }
        }

        for (SudokuError error : errors) {
            textFields[error.row()][error.column()].setBackground(Color.RED);
        }
    }

    public void checkBoard() {
        readGui();
        highlightErrors();
    }
}
