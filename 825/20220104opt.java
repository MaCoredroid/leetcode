class Solution {
    public int numFriendRequests(int[] ages) {
        int[] cnt=new int[121];
        for(int age:ages){
            cnt[age]++;
        }
        int ans=0;
        for(int a=15;a<=120;a++){
            for(int b=(int)(0.5*a)+7+1;b<=a;b++){
                ans+=cnt[a]*cnt[b];
                if(a==b){
                    ans-=cnt[a];
                }
            }
        }
        return ans;
    }
}