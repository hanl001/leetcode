class Solution {
    public void rotate(int[][] matrix) {
        // matrix[0][0] = matrix[n][0];
        // matrix[n][0] = matrix[n][n];
        // matrix[n][n] = matrix[0][n];
        // matrix[0][n] = matrix[0][0];
        
        // matrix[1][1] = matrix[n - 1][1];
        // matrix[n - 1][1] = matrix[n - 1][n - 1];
        // matrix[n - 1][n - 1] = matrix[1][n - 1];
        // matrix[1][n - 1] = matrix[1][1];
        
        // matrix[i][i] = matrix[n - i][i];
        // matrix[n - i][i] = matrix[n - i][n - i];
        // matrix[n - i][n - i] = matrix[i][n - i];
        // matrix[i][n - i] = matrix[i][i];

        int n = matrix.length - 1;
        int iLoop = n / 2 + n % 2; // 奇数矩阵中心点无需遍历
        int jLoop = matrix.length / 2 + matrix.length % 2; // 奇数矩阵中心点无需遍历
        for (int i = 0; i < iLoop; i++) {
            for (int j = 0; j < jLoop; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j][i];
                matrix[n - j][i] = matrix[n - i][n - j];
                matrix[n - i][n - j] = matrix[j][n - i];
                matrix[j][n - i] = temp;
            }
        }
    }
}
