class Solution {
    int[][] f;
    List<List<String>> ans=new ArrayList<>();
    List<String> curr=new ArrayList<>();
    public List<List<String>> partition(String s) {
        f=new int[s.length()][s.length()];
        backTrack(0,s);
        return ans;
    }

    private void backTrack(int pointer,String s){
        if(pointer==s.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=pointer;i<s.length();i++){
            if(check(s,pointer,i)==1){
                curr.add(s.substring(pointer,i+1));
                backTrack(i+1,s);
                curr.remove(curr.size()-1);
            }
        }
    }

    private int check(String s,int i,int j){
        if(f[i][j]!=0){
            return f[i][j];
        }
        if(i>=j){
            f[i][j]=1;
            return f[i][j];
        }
        if(s.charAt(i)==s.charAt(j)){
            f[i][j]=check(s,i+1,j-1);
            return f[i][j];
        }else{
            f[i][j]=-1;
            return f[i][j];
        }
    }


}