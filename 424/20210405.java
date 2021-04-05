class Solution {
    public int characterReplacement(String s, int k) {
        char[] ch=s.toCharArray();
        int ans=0;
        for(int i=0;i<ch.length;i++){
            char temp=ch[i];
            int count=k;
            int j=i+1;
            while(count>=0&j<ch.length){
                if(ch[j]!=temp){
                    if(count==0){
                        break;
                    }
                    count--;
                }
                j++;
            }
            ans=Math.max(ans,j-i);
            
            if(i+1<ch.length&&ch[i]!=ch[i+1]){
                temp=ch[i+1];
                count=k-1;
                j=i+2;
                while(count>=0&j<ch.length){
                    if(ch[j]!=temp){
                        if(count==0){
                            break;
                        }
                        count--;
                    }
                    j++;
                }
                ans=Math.max(ans,j-i);
            }
        }
        return ans;
    }
}