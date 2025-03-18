package aharon.sudoku;

import java.util.*;

public class Sudoku {

    int[][] board;

    public Sudoku(int[][] board) {
        this.board = board;
    }

    public void setValue(int row, int col, int value) {
        if (row >= 0 && row < 9 && col >= 0 && col < 9) {
            this.board[row][col] = value;
        }
    }

    public List<SudokuError> getErrors() {
        List<SudokuError> allErrors = new ArrayList<>();
        allErrors.addAll(getColErrors());
        allErrors.addAll(getRowErrors());
        allErrors.addAll(getBoxErrors());

        return allErrors;
    }

    public List<SudokuError> getColErrors() {
        List<SudokuError> errors = new ArrayList<>();

        for (int col = 0; col < 9; col++) {
            int[] numsPassed = new int[10];

            for (int row = 0; row < 9; row++) {
                int currentNumber = board[row][col];

                if (currentNumber >= 1 && currentNumber <= 9) {
                    if (numsPassed[currentNumber] == 1) {
                        errors.add(new SudokuError(row, col, currentNumber));
                    }
                    numsPassed[currentNumber] = 1;
                }
            }
        }
        return errors;
    }

    public List<SudokuError> getRowErrors() {
        List<SudokuError> errors = new ArrayList<>();

        for (int row = 0; row < 9; row++) {
            int[] numsPassed = new int[10];

            for (int col = 0; col < 9; col++) {
                int currentNumber = board[row][col];

                if (currentNumber >= 1 && currentNumber <= 9) {
                    if (numsPassed[currentNumber] == 1) {
                        errors.add(new SudokuError(row, col, currentNumber));
                    }
                    numsPassed[currentNumber] = 1;
                }
            }
        }
        return errors;
    }

    public List<SudokuError> getBoxErrors() {
        List<SudokuError> errors = new ArrayList<>();
        for (int subRow = 0; subRow < 3; subRow++) {
            for (int subCol = 0; subCol < 3; subCol++) {

                int[] numsPassed = new int[10];

                int startRow = subRow * 3;
                int startCol = subCol * 3;

                for (int sRow = startRow; sRow < startRow + 3; sRow++) {

                    for (int sCol = startCol; sCol < startCol + 3; sCol++) {

                        int currentNumber = board[sRow][sCol];

                        if (currentNumber >= 1 && currentNumber <= 9) {

                            if (numsPassed[currentNumber] == 1) {
                                errors.add(new SudokuError(sRow, sCol, currentNumber));
                            }
                            numsPassed[currentNumber] = 1;
                        }
                    }
                }
            }
        }
        return errors;
    }
}
