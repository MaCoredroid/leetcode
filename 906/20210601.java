class Solution {
    public int superpalindromesInRange(String left, String right) {
        Long L=Long.valueOf(left);
        Long R=Long.valueOf(right);
        int MAGIC=100000;
        int ans=0;
        for(int k=1;k<MAGIC;k++){
            StringBuilder sb=new StringBuilder(Integer.toString(k));
            for(int i=sb.length()-2;i>=0;i--){
                sb.append(sb.charAt(i));
            }
            Long v=Long.valueOf(sb.toString());
            v*=v;
            if(v>R){
                break;
            }
            if(v>=L&&check(v)){
                ans++;
            }
        }
        for(int k=1;k<MAGIC;k++){
            StringBuilder sb=new StringBuilder(Integer.toString(k));
            for(int i=sb.length()-1;i>=0;i--){
                sb.append(sb.charAt(i));
            }
            Long v=Long.valueOf(sb.toString());
            v*=v;
            if(v>R){
                break;
            }
            if(v>=L&&check(v)){
                ans++;
            }
        }
        return ans;

    }

    private boolean check(Long v){
        long origin=v;
        long ans=0;
        while(v>0){
            ans=ans*10+v%10;
            v/=10;
        }
        return ans==origin;
    }
}