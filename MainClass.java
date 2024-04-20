/**
 * MainClass
 */
public class MainClass {
    public static char[][] arr;

    public static void main(String[] args) {
        // createArray(10,10);
        // fillChar('x', 2, 4, 1,4);
        // fillChar('y', 1, 3, 0,5);

        /*
         * createArray(10,10);
         * pattern1(0);
         */

        createArray(4, 19);
        pattern2(9, 4, 0);

        draw();

    }

    public static void pattern1(int index) {
        if (arr[index][index] != '*' && index <= (int) (Math.min(arr[0].length, arr.length) / 2)) {
            fillChar('*', index, arr.length - index, index, arr[0].length - index);
            pattern1(index + 1);
        } else if (arr[index][index] != '#' && index <= (int) (Math.min(arr[0].length, arr.length) / 2)) {
            fillChar('#', index, arr.length - index, index, arr[0].length - index);
            pattern1(index + 1);
        }
    }

    public static void pattern2(int fillWidth, int shiftAmount, int index) {
        if (index + 1 < arr.length && fillWidth + index * shiftAmount < arr[0].length) {
            fillChar('*', index, index + 1, index * shiftAmount, fillWidth + index * shiftAmount);
            pattern2(fillWidth, shiftAmount, index + 1);
        } else if (index + 1 <= arr.length) {
            int k = (fillWidth + (index * shiftAmount)) - arr[0].length;
            fillChar('*', index, index + 1, index * shiftAmount, arr[0].length);
            fillChar('*', index, index + 1, 0, k);
            if(index + 1 == arr.length){
                pattern2(fillWidth, shiftAmount, index + 1);   
            }
            pattern2(fillWidth, shiftAmount, index + 1);
        }
    }

    public static void createArray(int numRows, int numColumns) {
        arr = new char[numRows][numColumns];
    }

    public static void fillChar(char c, int rowStart, int rowEnd, int columnStart, int columnEnd) {
        if (columnStart < columnEnd && rowStart < rowEnd) {
            arr[rowStart][columnStart] = c;
            fillChar(c, rowStart + 1, rowEnd, columnStart, columnEnd);

            fillChar(c, rowStart, rowEnd, columnStart + 1, columnEnd);
        }
    }

    public static void draw() {
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    System.out.print("#");
                } else {
                    System.out.print("" + arr[i][j]);
                }
            }
            System.out.println();
        }
    }
}