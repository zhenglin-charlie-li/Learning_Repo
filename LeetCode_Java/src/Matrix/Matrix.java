package Matrix;

public class Matrix {
    public static void main(String[] args) {
        String inputString = "[[2,29,20,26,16,28],[12,27,9,25,13,21],[32,33,32,2,28,14],[13,14,32,27,22,26],[33,1,20,7,21,7],[4,24,1,6,32,34]]";
        int[][] matrix = convertInput(inputString);
        rotate(matrix);
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int top = 0;
        int buttom = n - 1;
        int left = 0;
        int right = n - 1;
        while (top < buttom) {
            for (int j = left; j <= right - 1; j++) {
                int temp = matrix[top][left + j];
                matrix[top][left + j] = matrix[buttom - j][left];
                matrix[buttom - j][left] = matrix[buttom][right - j];
                matrix[buttom][right - j] = matrix[top + j][right];
                matrix[top + j][right] = temp;
            }
            top++;
            buttom--;
            left++;
            right--;
        }
    }

    public static void printMatrix(int[][] result) {
        // Print the 2D array
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] convertInput(String inputString) {
        // Remove enclosing square brackets and split by "],[" to get inner arrays
        String[] innerArrayStrings = inputString.substring(2, inputString.length() - 2).split("\\],\\[");

        // Create a 2D array to hold the parsed values
        int[][] result = new int[innerArrayStrings.length][];

        // Parse each inner array
        for (int i = 0; i < innerArrayStrings.length; i++) {
            String[] elements = innerArrayStrings[i].split(",");
            result[i] = new int[elements.length];

            // Parse and populate the 2D array
            for (int j = 0; j < elements.length; j++) {
                result[i][j] = Integer.parseInt(elements[j]);
            }
        }
        return result;
    }
}