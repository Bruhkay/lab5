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
        createArray(10,10);
        pattern1(0);*/

        /* 
        createArray(4, 19);
        pattern2(9, 4, 0); */

        /* 
        createArray(3,3);
        pattern3(1,1); */

        
        draw(0,0);
        System.out.println();
        System.out.println("The maximum sum of rows is: "+findMaxRowSum(0,0));

    }
    public static int findMaxRowSum(int index, int max){
        if(arr.length > index+1){
            max = Math.max(findRowSum(index,0), max);
            return findMaxRowSum(index+1, max);
        }
        else{
            return Math.max(max, findRowSum(index , 0));
        }
    } 
    public static int findRowSum(int row, int index){
        if(arr[0].length > index+1){ 
            return (Character.getNumericValue(arr[row][index])+ findRowSum(row, index+1));
        }
        else{
            return Character.getNumericValue(arr[row][index]);
        }
        
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
    public static void pattern3(int index1, int index2){
        
        if(arr[0][0]==0){
            fillChar('1', 0, 1, 0, arr[0].length);
            fillChar('1', 0, arr.length, 0, 1);
        } 
        int k = ((Character.getNumericValue(arr[index1-1][index2])+ Character.getNumericValue(arr[index1][index2-1]))%10);
        arr[index1][index2]=Character.forDigit(k, 10);
        if(index1+1!=arr.length){
            pattern3(index1+1, index2);
        }
        if(index2+1!=arr[0].length){
            pattern3(index1, index2+1);
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

    public static void draw(int i, int j) {
        if(i < arr.length){
            if(j < arr[0].length){
                if (arr[i][j] == 0) {
                    System.out.print("#");
                } else {
                    System.out.print("" + arr[i][j]);
                }
                draw(i, j+1);
            }
            else{
                System.out.println();
                draw(i+1, 0);
            }
            
            
        }
    }
    /* 
    for (int i = 0; i < arr.length; i++) {

        for (int j = 0; j < arr[0].length; j++) {
            if (arr[i][j] == 0) {
                System.out.print("#");
            } else {
                System.out.print("" + arr[i][j]);
            }
        }
        System.out.println();
    } */
}