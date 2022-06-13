public class Solution {
   public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>>pq=new PriorityQueue<>((a,b)->a.getValue()-b.getValue());
        for(int i=0;i<nums.length;i++)
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        for(Map.Entry<Integer,Integer>entry:hm.entrySet())
        {
            pq.add(entry);
            if(pq.size()>k)
                pq.poll();
        }
        int i=k-1;
        int res[]=new int[k];
        while(!pq.isEmpty())
        {
            res[i]=pq.poll().getKey();
            i--;
        }
        return res;
    }
}