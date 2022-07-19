class Solution {
    int [][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; // tldr
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxGold = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != 0){
                    int gold = helper(grid, i, j, new boolean[m][n]);
                    maxGold = Math.max(maxGold, gold);
                }
            }
        }
        return maxGold;
    }
    private int helper(int [][] grid, int i, int j, boolean [][] visit){
        visit[i][j] = true;
        int maxGold = 0;
        for(int [] dir : dirs){
            int ni = i + dir[0];
            int nj = j + dir[1];
            if(ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[i].length && grid[ni][nj] != 0 && visit[ni][nj] == false){
                int gold = helper(grid, ni, nj, visit);
                maxGold = Math.max(maxGold, gold);
            }
        }
        visit[i][j] = false;
        return maxGold + grid[i][j];
    }
}