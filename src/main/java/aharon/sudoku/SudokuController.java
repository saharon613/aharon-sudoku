package aharon.sudoku;

public class SudokuController {
    private final Sudoku sudoku;
    private final SudokuFrame frame;

    public SudokuController(Sudoku sudoku, SudokuFrame frame) {
        this.sudoku = sudoku;
        this.frame = frame;
    }
}
