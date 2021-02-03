package lesson2;

public class Main {

    private final static int MAX_ARRAY_LENGTH = 4;

    private static int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != MAX_ARRAY_LENGTH) {
            throw new MyArraySizeException("Неверное количество строк");
        }
        int result = 0;
        for (int rowIdx = 0; rowIdx < MAX_ARRAY_LENGTH; rowIdx++) {
            if (array[rowIdx].length != MAX_ARRAY_LENGTH) {
                throw new MyArraySizeException("Неверное количество столбцов");
            }
            for (int colIdx = 0; colIdx < MAX_ARRAY_LENGTH; colIdx++) {
                try {
                    result+= Integer.parseInt(array[rowIdx][colIdx]);
                } catch (Exception e) {
                    throw new MyArrayDataException("Неудалось преобразовать значение", colIdx, rowIdx, array[rowIdx][colIdx]);
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[][] arr = {
                {"1","2","3","4"},
                {"1","2","3","4"},
                {"1","2","3","4"},
                {"1","2","3","4"}
        };
        try {
            int r = sumArray(arr);
            System.out.println(r);
        } catch (MyArraySizeException e) {
            System.err.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.err.printf("%s col=%d row=%d value=%s", e.getMessage(), e.getCol(), e.getRow(), e.getValue());
        }

    }
}
