/**
 * MainClass
 */
public class MainClass {
    public static char[][] arr;
    public static void main(String[] args) {
        createArray(4,5);
        fillChar('x', 2, 4, 1,4);
        fillChar('y', 1, 3, 0,5);
        draw();

    }
    public static void createArray(int numRows, int numColumns){
        arr = new char[numRows][numColumns];
    }
    public static void fillChar(char c, int rowStart, int rowEnd, int columnStart, int columnEnd){
        if(columnStart < columnEnd && rowStart < rowEnd){
            arr[rowStart][columnStart] = c;
            fillChar(c, rowStart+1, rowEnd, columnStart, columnEnd);
            
            fillChar(c, rowStart, rowEnd, columnStart+1, columnEnd);
        }
    }
    public static void draw(){
        for (int i = 0; i< arr.length; i++) {
         
            for (int j = 0; j< arr[0].length; j++) {
                if(arr[i][j]==0){
                    System.out.print("  0");
                }
                else{
                    System.out.print("  "+arr[i][j]);   
                }
            }   
            System.out.println();
        }
    }
}