class Solution {
    public int lengthLongestPath(String input) {
        String[] res=input.split("\n");
        int prevDepth=0;
        List<Integer> s=new ArrayList<>();
        int prevLen=0;
        int ans=0;
        for(int i=0;i<res.length;i++){
            char[] ch=res[i].toCharArray();
            int p=0;
            while(p<ch.length&&ch[p]=='\t'){
                p++;
            }
            int depth=p;
            if(depth<=prevDepth){
                while(s.size()>depth){
                    prevLen-=s.get(s.size()-1);
                    s.remove(s.size()-1);
                }
            }
            prevDepth=depth;
            if(res[i].contains(".")){
                if(prevLen+ch.length-p+s.size()>ans){
                    ans=prevLen+ch.length-p+s.size();
                } 
            }else{
                s.add(ch.length-p);
                prevLen+=ch.length-p;
            }
        }
        return ans;
        
    }
}