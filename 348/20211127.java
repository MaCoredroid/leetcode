class TicTacToe {
    int[] rows;
    int[] cols;
    int dia;
    int adia;

    public TicTacToe(int n) {
        rows=new int[n];
        cols=new int[n];
    }
    
    public int move(int row, int col, int player) {
        int cur=(player==1)?1:-1;
        rows[row]+=cur;
        cols[col]+=cur;
        int n=rows.length;
        if(row==col) dia+=cur;
        if(col==(n-row-1)) adia+=cur;
        if(Math.abs(rows[row])==n||Math.abs(cols[col])==n||Math.abs(dia)==n||Math.abs(adia)==n){
            return player;
} 
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */