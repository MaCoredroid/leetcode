class Solution {
    int[] segments = new int[4];
    public List<String> restoreIpAddresses(String s) {
        List<String> ans=new ArrayList<>();
        backTrack(ans,0,s.toCharArray(),0);
        return ans;
    }

    private void backTrack(List<String> ans,int count,char[] ch,int pointer){
        if(count==4){
            if(pointer==ch.length){
                StringBuilder sb=new StringBuilder();
                for(int i=0;i<4;i++){
                    sb.append(segments[i]);
                    sb.append('.');
                }
                sb.deleteCharAt(sb.length()-1);
                ans.add(sb.toString());
            }
            return;
        }
        if(pointer==ch.length){
            return;
        }
        if(ch[pointer]=='0'){
            segments[count]=0;
            backTrack(ans,count+1,ch,pointer+1);
        }else{
            int ret=0;
            while(pointer<ch.length&&ret<=255){
                ret=ret*10+(ch[pointer]-'0');
                segments[count]=ret;
                if(ret<=255){
                    backTrack(ans,count+1,ch,pointer+1);
                }
                pointer++;
            }
        }
    }
}