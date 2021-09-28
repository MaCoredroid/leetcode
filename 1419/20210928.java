class Solution {
    char[] dic=new char[]{'c','r','o','a','k'};
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] ch=new int[128];
        int cnt=0;
        for(char c:croakOfFrogs.toCharArray()){
            ch[c]++;
            cnt=Math.max(cnt,ch['c']-ch['k']);
            List<Character> prevs=prevChar(c);
            for(Character p:prevs){
                if(ch[p]<ch[c]){
                    return -1;
                }
            }
        }
        return ch['c']!=ch['k']?-1:cnt;
    }
    
    public List<Character> prevChar(char c){
        List<Character> ans=new ArrayList<>();
        for(int i=0;i<5;i++){
            if(c==dic[i]){
                return ans;
            }else{
                ans.add(dic[i]);
            }
        }
        return ans;
    }
}