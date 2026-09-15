class Solution {
    public int[][] constructProductMatrix(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] ans = new int[m][n];

        int mod = 12345;

        // Prefix product
        long product = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                ans[i][j] = (int) product;

                product = (product * grid[i][j]) % mod;
            }
        }

        // Suffix product
        product = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                ans[i][j] =
                    (int) ((ans[i][j] * product) % mod);

                product = (product * grid[i][j]) % mod;
            }
        }

        return ans;
    }
}