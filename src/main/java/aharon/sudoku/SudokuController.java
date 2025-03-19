package aharon.sudoku;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SudokuController {

    private final Sudoku sudoku;
    private final JTextField[][] cells;

    public SudokuController(Sudoku sudoku, JTextField[][] cells) {
        this.sudoku = sudoku;
        this.cells = cells;
    }

    private void readGui() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                String cellText = cells[row][col].getText();
                if (!cellText.isEmpty()) {
                    try {
                        int value = Integer.parseInt(cellText);
                        sudoku.setValue(row, col, value);

                    } catch (NumberFormatException e) {

                        sudoku.setValue(row, col, 0);
                        cells[row][col].setBackground(Color.YELLOW);
                    }
                }
            }
        }
    }

    private void highlightErrors() {
        List<SudokuError> errors = sudoku.getErrors();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                cells[row][col].setBackground(Color.WHITE);
            }
        }

        for (SudokuError error : errors) {
            cells[error.row()][error.column()].setBackground(Color.RED);
        }
    }

    public void checkBoard() {
        readGui();
        highlightErrors()
    }
}
