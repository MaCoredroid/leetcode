class Solution {
    public int longestMountain(int[] arr) {
        int ans=0;
        int i=0;
        int j=0;
        while(j+1<arr.length){
            while(j+1<arr.length&&arr[j+1]>arr[j]){
                j++;
            }
            int mid=j;
            while(j+1<arr.length&&arr[j+1]<arr[j]){
                j++;
            }
            if(mid!=i&&mid!=j){
                ans=Math.max(j-i+1,ans);
            }
            while(j+1<arr.length&&arr[j+1]==arr[j]){
                j++;
            }
            i=j;
        }
        return ans==1?0:ans;
    }
}