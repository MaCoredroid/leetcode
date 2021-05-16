class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return intersect(nums2,nums1);
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums1){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int[] intersection = new int[nums1.length];
        int index=0;
        for(int num:nums2){
            int count=map.getOrDefault(num,0);
            if(count>0){
                intersection[index++]=num;
                map.put(num,count-1);
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}