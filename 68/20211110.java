class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans=new ArrayList<>();
        int p=0;
        int temp=maxWidth;
        int prev=0;
        while(p<words.length){
            if(temp>=words[p].length()){
                temp-=words[p].length()+1;
                p++;
            }else{
                ans.add(printOut(words,prev,p,maxWidth));
                prev=p;
                temp=maxWidth;
            }
        }
        ans.add(printOut(words,prev,p,maxWidth));
        return ans;
    }

    public String printOut(String[] words,int left,int right,int max){
        int cnt=0;
        for(int i=left;i<right;i++){
            cnt+=words[i].length();
        }
        StringBuilder sb=new StringBuilder();
        if(right-left-1>0){
            int num=(max-cnt)/(right-left-1);
            int rest=(max-cnt)%(right-left-1);
            if(right==words.length){
                num=1;
                rest=0;
            }
            for(int i=left;i<right-1;i++){
                sb.append(words[i]);
                for(int j=0;j<num;j++){
                    sb.append(" ");
                }
                if(rest>0){
                    sb.append(" ");
                    rest--;
                }
            }
        }
        
        sb.append(words[right-1]);
        while(sb.length()<max){
            sb.append(" ");
        }
        return sb.toString();
    }
}