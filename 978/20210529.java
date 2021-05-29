class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if(arr.length<2){
            return arr.length;
        }
        int flag=0;
        int left=0;
        int cnt=2;
        if(arr[1]-arr[0]<0){
            flag=1;
        }else if(arr[1]==arr[0]){
            left++;
            flag=2;
            cnt=1;
        }
        for(int right=2;right<arr.length;right++){
            if(arr[right]==arr[right-1]){
                cnt=Math.max(cnt,right-left);
                left=right;
                flag=2;
                continue;
            }
            if(arr[right]-arr[right-1]>0&&flag!=0){
                flag=0;
            }else if(arr[right]-arr[right-1]<0&&flag!=1){
                flag=1;
            }else{
                left=right-1;
                flag=0;
                if(arr[right]-arr[right-1]<0){
                    flag=1;
                }
            }
            cnt=Math.max(cnt,right-left+1);
        }
        return cnt;
    }
}