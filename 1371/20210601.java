class Solution {
    public int findTheLongestSubstring(String s) {
        int[] pos=new int[1<<5];
        Arrays.fill(pos,-1);
        int status=0;
        int ans=0;
        pos[0]=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'){
                status^=(1<<0);
            }else if(s.charAt(i)=='e'){
                status^=(1<<1);
            }else if(s.charAt(i)=='i'){
                status^=(1<<2);
            }else if(s.charAt(i)=='o'){
                status^=(1<<3);
            }else if(s.charAt(i)=='u'){
                status^=(1<<4);
            }
            if(pos[status]>=0){
                ans=Math.max(ans,i+1-pos[status]);
            }else{
                pos[status]=i+1;
            }
        }
        return ans;
    }
}