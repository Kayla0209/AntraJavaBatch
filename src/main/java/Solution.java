public class Solution {
    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 0, 1, 1, 1},
                                    {1, 1, 1, 1, 1},
                                    {1, 1, 0, 1, 0},
                                    {1, 1, 1, 1, 1},
                                    {1, 1, 1, 0, 0}};
        System.out.println(largestSquareSurroundedByOne(array));
    }

    public static int largestSquareSurroundedByOne(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int row = matrix.length;
        int column = matrix[0].length;
        int[][] leftToRight = new int[row][column];
        int[][] rightToLeft = new int[row][column];
        int[][] topToBottom = new int[row][column];
        int[][] bottomToTop = new int[row][column];

        for (int i = 0; i < row; i++) {
            int numOnes = 0;
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    numOnes = 0;
                    leftToRight[i][j] = 0;
                } else {
                    numOnes += 1;
                    leftToRight[i][j] = numOnes;
                }
                System.out.println(leftToRight[i][j]);
            }
        }

        for (int i = 0; i < row; i++) {
            int numOnes = 0;
            for (int j = column - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    numOnes = 0;
                    rightToLeft[i][j] = 0;
                } else {
                    numOnes += 1;
                    rightToLeft[i][j] = numOnes;
                }
            }
        }

        for (int j = 0; j < column; j++) {
            int numOnes = 0;
            for (int i = 0; i < row; i++) {
                if (matrix[i][j] == 0) {
                    numOnes = 0;
                    topToBottom[i][j] = 0;
                } else {
                    numOnes += 1;
                    topToBottom[i][j] = numOnes;
                }
            }
        }

        for (int j = 0; j < column; j++) {
            int numOnes = 0;
            for (int i = row - 1; i >= 0; i--) {
                if (matrix[i][j] == 0) {
                    numOnes = 0;
                    bottomToTop[i][j] = 0;
                } else {
                    numOnes += 1;
                    bottomToTop[i][j] = numOnes;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int l = Math.min(rightToLeft[i][j], bottomToTop[i][j]);
                if (l == 0) {
                    continue;
                } else if (l == 1) {
                    result = (result == 0) ? 1 : result;
                } else {
                    for (l = Math.min(rightToLeft[i][j], bottomToTop[i][j]); l >= 1; l-- ) {
                        if (leftToRight[i + l][j + l] >= l && topToBottom[i + l][j + l] >= l && result < l) {
                            result = l;
                        }
                    }
                }

            }
        }

        return result;
    }
}

