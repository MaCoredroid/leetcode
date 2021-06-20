class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m>bloomDay.length/k){
            return -1;
        }
        int high=Arrays.stream(bloomDay).max().getAsInt();
        int low=Arrays.stream(bloomDay).min().getAsInt();
        while(low<=high){
            int mid=low+((high-low)>>1);
            if(check(bloomDay,m,k,mid)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;

    }

    private boolean check(int[] bloomDay,int m,int k,int ans){
        int flowers=0;
        int res=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=ans){
                flowers++;
                if(flowers==k){
                    res++;
                    flowers=0;
                }
            }else{
                flowers=0;
            }
        }
        return res>=m;
    }
}