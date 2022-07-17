class Solution {
    public int helper(int i,int[] cost,Integer dp[]){
        if(i>=cost.length) return 0;
        if(dp[i]!=null) return dp[i];
        int op1=cost[i]+helper(i+1,cost,dp);
        int op2=cost[i]+helper(i+2,cost,dp);
        return dp[i]=Math.min(op1,op2);
    }
    public int minCostClimbingStairs(int[] cost) {
        Integer dp[]=new Integer[cost.length];
        int ans1=helper(0,cost,dp);
        int ans2=helper(1,cost,dp);
        return Math.min(ans1,ans2);
    }
}