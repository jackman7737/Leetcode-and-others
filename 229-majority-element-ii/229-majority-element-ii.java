class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length == 1){
            res.add(nums[0]);
            return res;
        }
        int c1 = 0, c2 = 0, n1 = -1, n2 = -1;
        for(int ele: nums){
            if(ele == n1)
                c1++;
            else if(ele == n2)
                c2++;
            else if(c1 == 0){
                n1 = ele;
                c1 = 1;
            }
            else if(c2== 0){
                n2 = ele;
                c2 = 1;
            }
            else{
                c1--;
                c2--;
            }
        }
        int cnt1 = 0, cnt2 = 0;
        for(int ele: nums){
            if(ele == n1)
                cnt1++;
            else if(ele == n2)
                cnt2++;
        }
        if(cnt1 > (nums.length/3))
            res.add(n1);
        if(cnt2 > (nums.length/3))
            res.add(n2);
        return res;
    }
}