class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        backTrack(ans,new boolean[n][n],0);
        return ans;
    }

    private void backTrack(List<List<String>> ans,boolean[][] curr,int count){
        if(count==curr.length){
            List<String> temp=new ArrayList<>();
            for(int i=0;i<curr.length;i++){
                StringBuilder sb= new StringBuilder();
                for(int j=0;j<curr.length;j++){
                    if(curr[i][j]){
                        sb.append('Q');
                    }else{
                        sb.append('.');
                    }
                }
                temp.add(sb.toString());
            }
            ans.add(temp);
            return;
        }
        for(int i=0;i<curr.length;i++){
            if(check(curr,count,i)){
                curr[count][i]=true;
                backTrack(ans,curr,count+1);
                curr[count][i]=false;
            }
        }
    }

    private boolean check(boolean[][] curr,int i,int j){
        for(int p=0;p<i;p++){
            for(int q=0;q<curr.length;q++){
                if(curr[p][q]&&(q==j||(p+q)==(i+j)||(p-q)==(i-j))){
                    return false;
                }
            }
        }
        return true;
    }
}