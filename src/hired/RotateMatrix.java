package hired;

import java.util.Arrays;

public class RotateMatrix {

    /**
     * [
     * [1,2,3],
     * [4,5,6],
     * [7,8,9]
     * ]
     * When rotating clockwise row becomes column and vise versa
     *
     * @return 90deg rotated matrix
     */
    public static int[][] rotateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int column = matrix[0].length;
        int[][] newArray = new int[column][rows];
        for (int i = 0; i < column; i++) {
            for (int j = rows-1; j >= 0; j--) {
                newArray[i][j] = matrix[j][i];
            }
        }

        return newArray;
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println("[");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(Arrays.toString(matrix[i]));
            System.out.println(",");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        printMatrix(rotateMatrix(matrix));
    }
}
