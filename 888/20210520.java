class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        HashSet<Integer> set=new HashSet<>();
        int ans1=0,ans2=0;
        for(int num:aliceSizes){
            set.add(num);
            ans1+=num;
        }
        for(int num:bobSizes){
            ans2+=num;
        }
        for(int num:bobSizes){
            if(set.contains(num+(ans1-ans2)/2)){
                return new int[]{num+(ans1-ans2)/2,num};
            }
        }
        return new int[]{0,0};
    }
}