package aharon.sudoku;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class SudokuFrame extends JFrame {

    private JTextField[][] textFields = new JTextField[9][9];

    public SudokuFrame() {
        setTitle("Sudoku Board");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(9, 9));

        int[][] partialBoard = {
                {5, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 7, 0, 1, 0, 0, 0, 0, 8},
                {0, 0, 8, 3, 0, 2, 0, 6, 0},
                {0, 0, 0, 7, 0, 1, 0, 0, 3},
                {0, 2, 0, 0, 5, 0, 0, 9, 0},
                {7, 0, 3, 0, 2, 0, 8, 0, 0},
                {0, 6, 0, 0, 0, 7, 2, 8, 0},
                {0, 8, 0, 4, 1, 0, 0, 0, 0},
                {3, 0, 0, 0, 0, 0, 1, 0, 9},
        };

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                JTextField textField = new JTextField();
                textField.setHorizontalAlignment(JTextField.CENTER);
                textFields[row][col] = textField;

                if (partialBoard[row][col] != 0) {
                    textField.setText(String.valueOf(partialBoard[row][col]));
                    textField.setEditable(false);
                    textField.setBackground(Color.LIGHT_GRAY);
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
                if (text.isEmpty()) {
                    return;
                }
            }
        }

        // When all cells are filled, show a message

    }

    public static void main(String[] args) {
        SudokuFrame frame = new SudokuFrame();
        frame.setVisible(true);
    }
}
