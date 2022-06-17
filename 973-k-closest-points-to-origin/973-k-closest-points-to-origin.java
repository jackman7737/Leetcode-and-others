class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]);
        });
        int res[][] = new int[k][2];
        for(int[] temp : points){
            pq.add(temp);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int count = 0;
        while(!pq.isEmpty()){
            res[count++] = pq.poll();
        }
        return res;
    }}