package aharon.sudoku;

import java.util.*;

public class Sudoku
{

    private int[][] board;

    public Sudoku(int[][] board) {
        this.board = board;
    }

    public List<String> getErrors() {
        List<String> allErrors = new ArrayList<>();
        allErrors.addAll(getColErrors()); // Add column errors to the list
        allErrors.addAll(getRowErrors()); // Add row errors to the list
        allErrors.addAll(getBoxErrors()); // Add box errors to the list

        return allErrors;
    }

    public List<String> getColErrors() {
        List<String> errors = new ArrayList<>();

        for (int col = 0; col < 9; col++) {
            int[] numsPassed = new int[10];

            for (int row = 0; row < 9; row++) {
                int currentNumber = board[row][col];

                if (currentNumber >= 1 && currentNumber <= 9) {
                    if (numsPassed[currentNumber] == 1) {
                        String error = "Duplicate of " + currentNumber + " in row " + row + ", column " + col;
                        errors.add(error);
                    }
                    numsPassed[currentNumber] = 1;
                }
            }
        }
        return errors;
    }

    public List<String> getRowErrors() {
        List<String> errors = new ArrayList<>();

        for (int row = 0; row < 9; row++) {
            int[] numsPassed = new int[10];

            for (int col = 0; col < 9; col++) {
                int currentNumber = board[row][col];

                if (currentNumber >= 1 && currentNumber <= 9) {
                    if (numsPassed[currentNumber] == 1) {
                        String error = "Duplicate of " + currentNumber + " in row " + row + ", column " + col;
                        errors.add(error);
                    }
                    numsPassed[currentNumber] = 1;
                }
            }
        }
        return errors;
    }

    public List<String> getBoxErrors()
    {
        List<String> errors = new ArrayList<>();
        for (int subRow = 0; subRow < 3; subRow++) {
            for (int subCol = 0; subCol < 3; subCol++) {

                int[] numsPassed = new int[10];

                int startRow = subRow * 3;
                int startCol = subCol * 3;

                for (int sRow = startRow;  sRow < startRow + 3; sRow++) {

                    for (int sCol = startCol;  sCol < startCol + 3; sCol++) {

                        int currentNumber = board[sRow][sCol];

                        if (currentNumber >= 1 && currentNumber <= 9) {

                            if (numsPassed[currentNumber] == 1) {
                                int boxNum = (subRow * 3) + subCol + 1;
                                String error = "Duplicate of " + currentNumber + " in box " + boxNum;
                                errors.add(error);
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
