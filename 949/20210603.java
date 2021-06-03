class Solution {
    public String largestTimeFromDigits(int[] arr) {
        int ans=-1;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(i==j){
                    continue;
                }
                for(int k=0;k<4;k++){
                    if(k==i||k==j){
                        continue;
                    }
                    int l=6-i-j-k;
                    int hour=arr[i]*10+arr[j];
                    int minute=arr[k]*10+arr[l];
                    if(hour<24&&minute<60){
                        ans=Math.max(ans,hour*60+minute);
                    }
                }
            }
        }
        return ans>=0?String.format("%02d:%02d", ans / 60, ans % 60):"";
    }
}