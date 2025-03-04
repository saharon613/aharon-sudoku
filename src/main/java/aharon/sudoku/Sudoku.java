package aharon.sudoku;

import java.util.*;

public class Sudoku
{

    private int[][] board;

    public Sudoku(int[][] board) {
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
                    }
                }
                numsPassed[countPassed] = currentNumber;
                countPassed++;
            }
        }

        for (int subRow = 0; subRow < 3; subRow++) {
            for (int subCol = 0; subCol < 3; subCol++) {

                int[] numsPassed = new int[9];
                int countPassed = 0;

                int startRow = subRow * 3;
                int startCol = subCol * 3;

                for (int sRow = startRow;  sRow < startRow + 3; sRow++) {

                    for (int sCol = startCol;  sCol < startCol + 3; sCol++) {

                        int currentNumber = board[sRow][sCol];

                        for (int np = 0; np < countPassed; np++) {

                            if (numsPassed[np] == currentNumber) {
                                int boxNum = subRow * 3 + subCol + 1;
                                String error = "Duplicate of " + currentNumber + " in box " + boxNum;
                                errors.add(error);
                            }
                        }
                        numsPassed[countPassed] = currentNumber;
                        countPassed++;
                    }
                }
            }
        }
        return errors;
    }
}
