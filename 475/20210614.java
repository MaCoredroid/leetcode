class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int radius=0;
        int n=heaters.length;
        Arrays.sort(heaters);
        Arrays.sort(houses);
        int left=0;
        int right=n-1;
        for(int house:houses){
            
            right=n-1;
            while(left<=right){
                int mid=left+((right-left)>>1);
                if(heaters[mid]<house){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
            int leftdis=left-1>=0?house-heaters[left-1]:Integer.MAX_VALUE;
            int rightdis=left<n?heaters[left]-house:Integer.MAX_VALUE;
            radius=Math.max(radius,Math.min(leftdis,rightdis));
        }
        return radius;
    }
}