class Solution {
    Set<Integer> columns=new HashSet<>();
    Set<Integer> diagonals1=new HashSet<>();
    Set<Integer> diagonals2=new HashSet<>();
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
                columns.add(i);
                diagonals1.add(count+i);
                diagonals2.add(count-i);
                backTrack(ans,curr,count+1);
                columns.remove(i);
                diagonals1.remove(count+i);
                diagonals2.remove(count-i);
                curr[count][i]=false;
            }
        }
    }

    private boolean check(boolean[][] curr,int i,int j){
        if(columns.contains(j)||diagonals1.contains(i+j)||diagonals2.contains(i-j)){
            return false;
        }
        return true;
    }
}