class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        char[] ch=s.toCharArray();
        char pre=ch[0];
        int left=0;
        int cnt=1;
        List<List<Integer>> ans=new ArrayList<>();
        for(int right=1;right<ch.length;right++){
            if(ch[right]==pre){
                cnt++;
            }else{
                if(right-left>=3){
                    List<Integer> toAdd=new ArrayList<>();
                    toAdd.add(left);
                    toAdd.add(right-1);
                    ans.add(toAdd);
                }
                left=right;
                cnt=1;
                pre=ch[left];
            }
        }
        if(ch.length-left>=3){
            List<Integer> toAdd=new ArrayList<>();
            toAdd.add(left);
            toAdd.add(ch.length-1);
            ans.add(toAdd);
        }
        return ans;
    }
}