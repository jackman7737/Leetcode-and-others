class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length(), MAX = Integer.MAX_VALUE;
        char[] a = word1.toCharArray(), b = word2.toCharArray();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i < m || j < n)
                    dp[i][j] = i < m && j < n && a[i] == b[j] ?
                        dp[i + 1][j + 1] : 1 + Math.min((i < m ? dp[i + 1][j] : MAX), (j < n ? dp[i][j + 1] : MAX));
            }
        }
        return dp[0][0];
    }
}