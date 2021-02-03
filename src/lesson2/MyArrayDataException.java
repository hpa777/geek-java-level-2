package lesson2;

public class MyArrayDataException extends NumberFormatException {

    private int col;
    public int getCol() {
        return col;
    }

    private int row;
    public int getRow() {
        return row;
    }

    private String value;
    public String getValue() {
        return value;
    }

    public MyArrayDataException(String s, int col, int row, String value) {
        super(s);
        this.col = col;
        this.row = row;
        this.value = value;
    }
}