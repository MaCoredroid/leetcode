class Solution {
    List<List<String>> ans=new ArrayList<>();
    int n=0;
    public List<List<String>> solveNQueens(int n) {
        this.n=n;
        helper(new int[n][n],new boolean[n],new boolean[n],new boolean[n<<1],new boolean[n<<1],0);
        return ans;
    }

    private void helper(int[][] board,boolean[] rows,boolean[] cols, boolean[] dig1,boolean[] dig2,int cnt){
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
        int i=cnt;
        for(int j=0;j<n;j++){
            if(rows[i]||cols[j]||dig1[i+j]||dig2[i-j+n]){
                continue;
            }else{
                rows[i]=cols[j]=dig1[i+j]=dig2[i-j+n]=true;
                board[i][j]=1;
                helper(board,rows,cols,dig1,dig2,cnt+1);
                rows[i]=cols[j]=dig1[i+j]=dig2[i-j+n]=false;
                board[i][j]=0;
            }
        }
    }
}