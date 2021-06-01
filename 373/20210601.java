class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans=new ArrayList<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>((v1,v2)->(nums1[v1[0]]+nums2[v1[1]]-nums1[v2[0]]-nums2[v2[1]]));
        for(int i=0;i<nums1.length;i++){
            pq.offer(new int[]{i,0});
        }
        for(int i=0;i<k&&!pq.isEmpty();i++){
            int[] temp=pq.poll();
            List<Integer> res=new ArrayList<>();
            res.add(nums1[temp[0]]);
            res.add(nums2[temp[1]]);
            ans.add(res);
            if(temp[1]+1<nums2.length){
                pq.offer(new int[]{temp[0],temp[1]+1});
            }
        }
        return ans;

    }
}