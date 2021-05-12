class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] pos=new int[26];
        for(int i=0;i<S.length();i++){
            pos[S.charAt(i)-'a']=i;
        }
        int start=0;
        int end=0;
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<S.length();i++){
            end=Math.max(end,pos[S.charAt(i)-'a']);
            if(end==i){
                ans.add(end-start+1);
                start=end+1;
            }
        }
        return ans;
    }
}