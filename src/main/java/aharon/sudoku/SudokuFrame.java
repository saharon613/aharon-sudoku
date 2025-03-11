package aharon.sudoku;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.List;

public class SudokuFrame extends JFrame {

    private JTextField[][] textFields = new JTextField[9][9];
    private Sudoku sudoku;

    public SudokuFrame() {
        setTitle("Sudoku Board");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(9, 9));

        int[][] partialBoard = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {0, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };

        sudoku = new Sudoku(partialBoard);

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                JTextField textField = new JTextField();
                textField.setHorizontalAlignment(JTextField.CENTER);
                textFields[row][col] = textField;

                if (partialBoard[row][col] != 0) {
                    textField.setText(String.valueOf(partialBoard[row][col]));
                    textField.setEditable(false);
                }
                else {
                    textField.getDocument().addDocumentListener(new DocumentListener() {
                        public void changedUpdate(DocumentEvent e) {
                            checkBoard();
                        }

                        public void insertUpdate(DocumentEvent e) {
                            checkBoard();
                        }

                        public void removeUpdate(DocumentEvent e) {
                            checkBoard();
                        }
                    });
                }
                add(textField);
            }
        }
    }

    private void checkBoard() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                String text = textFields[row][col].getText();
                if (!text.isEmpty()) {
                    sudoku.board[row][col] = Integer.parseInt(text);
                }
            }
        }

        System.out.println("board filled");

        List<SudokuError> errors = sudoku.getErrors();

        for (int errorIn = 0; errorIn < errors.size(); errorIn++) {
            SudokuError error = errors.get(errorIn);
            int row = error.getRow();
            int col = error.getColumn();
            textFields[row][col].setBackground(Color.RED);
            System.out.println(error);
        }
    }

    public static void main(String[] args) {
        SudokuFrame frame = new SudokuFrame();
        frame.setVisible(true);
    }
}
