class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans,new ArrayList<Integer>(),n,1,k);
        return ans;
    }
    void helper(List<List<Integer>> ans,List<Integer> p, int target, int index,int k){
        if(target == 0 && p.size() == k){
            ans.add(new ArrayList<Integer>(p));
            return;
        }
        for (int i = index; i <= 9 && i <= target; i++) {
            p.add(i);
            helper(ans,p,target-i,i+1,k);
            p.remove(p.size() - 1);
        }
    }
    
}