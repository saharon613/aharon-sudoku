package aharon.sudoku;

import java.util.*;

public class Sudoku
{

    private int[][] board;

    public Sudoku (int[][] board) {
        this.board = board;
    }

    public List<String> getErrors()
    {
        List<String> errors = new ArrayList<>();

        for (int col = 0; col < 9; col++) {
            int[] numsPassed = new int[9];
            int countPassed = 0;

            for (int row = 0; row < 9; row++) {
                int currentNumber = board[row][col];

                for (int np = 0; np < countPassed; np++) {
                    if (numsPassed[np] == currentNumber) {
                        String error = "Duplicate of " + currentNumber + " in row " + row + ", column " + col;
                        errors.add(error);
                        break;
                    }
                }
                numsPassed[countPassed] = currentNumber;
                countPassed++;
            }
        }

        for (int row = 0; row < 9; row++) {
            int[] numsPassed = new int[9];
            int countPassed = 0;

            for (int col = 0; col < 9; col++) {
                int currentNumber = board[row][col];

                for (int np = 0; np < countPassed; np++) {
                    if (numsPassed[np] == currentNumber) {
                        String error = "Duplicate of " + currentNumber + " in row " + row + ", column " + col;
                        errors.add(error);
                        break;
                    }
                }
                numsPassed[countPassed] = currentNumber;
                countPassed++;
            }
        }
        return errors;
    }
}
