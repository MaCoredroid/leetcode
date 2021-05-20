class Solution {
    List<List<String>> ans=new ArrayList<>();
    int n=0;
    public List<List<String>> solveNQueens(int n) {
        this.n=n;
        helper(new int[n][n],new HashSet<>(),new HashSet<>(),new HashSet<>(),new HashSet<>(),0,0,0);
        return ans;
    }

    private void helper(int[][] board,Set<Integer> rows,Set<Integer> cols, Set<Integer> dig1,Set<Integer> dig2,int i,int j,int cnt){
        if(cnt==n){
            List<String> temp=new ArrayList<>();
            for(int[] row:board){
                StringBuilder sb=new StringBuilder();
                for(int num:row){
                    if(num==1){
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
        if(j==n){
            i++;
            j=0;
            if(i==n){
                return;
            }
        }
        if(rows.contains(i)||cols.contains(j)||dig1.contains(i+j)||dig2.contains(i-j)){
            helper(board,rows,cols,dig1,dig2,i,j+1,cnt);
        }else{
            rows.add(i);
            cols.add(j);
            dig1.add(i+j);
            dig2.add(i-j);
            board[i][j]=1;
            cnt++;
            helper(board,rows,cols,dig1,dig2,i,j+1,cnt);
            rows.remove(i);
            cols.remove(j);
            dig1.remove(i+j);
            dig2.remove(i-j);
            board[i][j]=0;
            cnt--;
            helper(board,rows,cols,dig1,dig2,i,j+1,cnt);
        }
    }
}