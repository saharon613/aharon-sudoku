package aharon.sudoku;

public class SudokuError
{
    private int row;
    private int column;
    private int value;

    public SudokuError(int row, int column, int value){
        this.row = row;
        this.column = column;
        this.value = value;
    }
    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }
    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "SudokuError{"
                + "row=" + row
                + ", column=" + column
                + ", value=" + value
                + '}';
    }
}
