class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int[] arr=new int[46];
        int prev=0;
        int n=lowLimit;
        while(n>0){
            prev+=n%10;
            n/=10;
        }
        arr[prev]++;
        for(int i=lowLimit+1;i<=highLimit;i++){
            int j=i;
            int cnt=0;
            while(j%10==0){
                cnt++;
                j/=10;
            }
            prev+=1-9*cnt;
            arr[prev]++;
        }
        int maxNum=0;
        for(int val:arr){
            maxNum=Math.max(val,maxNum);
        }
        return maxNum;
    }
}