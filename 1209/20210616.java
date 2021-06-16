class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Integer> counts=new Stack<>();
        char[] ch=s.toCharArray();
        int j=0;
        for(int i=0;i<s.length();i++,j++){
            ch[j]=ch[i];
            if(j==0||ch[j]!=ch[j-1]){
                counts.push(1);
            }else{
                int incremented=counts.pop()+1;
                if(incremented==k){
                    j=j-k;
                }else{
                    counts.push(incremented);
                }
            }
        }
        return new String(ch,0,j);
    }
}