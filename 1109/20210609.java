class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans=new int[n+1];
        for(int[] book:bookings){
            int start=book[0];
            int end=book[1];
            ans[start-1]+=book[2];
            ans[end]-=book[2];
        }
        int[] ret=new int[n];
        int prev=ans[0];
        for(int i=0;i<ret.length;i++){
            ret[i]=prev;
            prev+=ans[i+1];
        }
        return ret;
    }
}