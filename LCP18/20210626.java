class Solution {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int minS=staple[0];
        int maxS=staple[staple.length-1];
        int minD=drinks[0];
        int maxD=drinks[drinks.length-1];
        int index2=find(staple,x-minD);
        int ans=0;
        for(int i=0;i<index2;i++){
            int target=x-staple[i];
            int left=find(drinks,target);
            ans=(ans+left)%1_000_000_007;
        }
        return ans%1_000_000_007;
    }

    private int find(int[] arr,int val){
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=left+((right-left)>>1);
            if(arr[mid]<=val){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }
}