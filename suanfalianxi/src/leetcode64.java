//最小路径和
//https://leetcode.cn/problems/minimum-path-sum/description/
public class leetcode64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return f1(grid, grid.length - 1, grid[0].length - 1,dp);
    }

    public static int f1(int[][] grid,int i,int j,int[][] dp){
        if (dp[i][j] != -1){
            return dp[i][j];
        }

        int ans;

        if (i == 0 && j == 0){
            ans = grid[0][0];
        }else {
            int up = Integer.MAX_VALUE;
            int left = Integer.MAX_VALUE;

            if(i - 1 >= 0){
                up = f1(grid,i - 1,j,dp);
            }
            if (j - 1 >= 0){
                left = f1(grid,i,j - 1,dp);
            }
            ans = grid[i][j] + Math.min(up,left);
        }
        dp[i][j] = ans;
        return ans;
    }
}
