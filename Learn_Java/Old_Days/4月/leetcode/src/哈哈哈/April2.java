package 哈哈哈;

public class April2 {

    public static void main(String[] args) {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        int[][] board1 = new int[board.length + 2][board[0].length + 2];

        for (int i = 1; i < board1.length - 1; i++) {
            for (int j = 1; j < board1[i].length - 1; j++) {
                board1[i][j] = board[i - 1][j - 1];
            }
        }

        for (int i = 1; i < board1.length - 1; i++) {
            for (int j = 1; j < board1[i].length - 1; j++) {
                int[] arr = new int[8];
                arr[0] = board1[i - 1][j - 1];
                arr[1] = board1[i][j - 1];
                arr[2] = board1[i + 1][j - 1];
                arr[3] = board1[i - 1][j];
                arr[4] = board1[i + 1][j];
                arr[5] = board1[i - 1][j + 1];
                arr[6] = board1[i][j + 1];
                arr[7] = board1[i + 1][j + 1];
                int count = 0;
                for (int x = 0; x < 8; x++) {
                    if (arr[x] == 1) {
                        count++;
                    }
                }
                if (board1[i][j] == 0 && count == 3) {
                    board[i - 1][j - 1] = 1;
                }
                if (board1[i][j] == 1) {
                    if (count < 2) {
                        board[i - 1][j - 1] = 0;
                    }

                    if (count > 3) {
                        board[i - 1][j - 1] = 0;
                    }
                }
            }
        }


        for (int i = 0; i < 4; i++) {
            for (int i1 = 0; i1 < 3; i1++) {
                System.out.print(board[i][i1]);
            }
            System.out.println();
        }
    }
}
