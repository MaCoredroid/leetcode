class Excel {
    
    Node[][] nodes;
    
    class Node{
        Integer val;
        boolean isNum;
        String[] formula;
        public void setNum(int val){
            this.val=val;
            this.isNum=true;
        }

        public void setFormula(String[] s){
            this.isNum=false;
            this.formula=s;
        }

        public int calculate(){
            int sum=0;
            for(String s:this.formula){
                int c=s.charAt(0)-'A';
                if(s.length()<=3){
                    int r=Integer.parseInt(s.substring(1))-1;
                    if(nodes[r][c].isNum){
                        sum+=nodes[r][c].val;
                    }else{
                        sum+=nodes[r][c].calculate();
                    }
                }else{
                    int i=0;
                    while(s.charAt(i)!=':'){
                        i++;
                    }
                    int r1=Integer.parseInt(s.substring(1,i))-1;
                    int c1=s.charAt(0)-'A';
                    int r2=Integer.parseInt(s.substring(i+2))-1;
                    int c2=s.charAt(i+1)-'A';
                    for(int p=r1;p<=r2;p++){
                        for(int q=c1;q<=c2;q++){
                            if(nodes[p][q].isNum){
                                sum+=nodes[p][q].val;
                            }else{
                                sum+=nodes[p][q].calculate();
                            }
                        }
                    }
                }
            }
            this.val=sum;
            return sum;
        }
    }


    public Excel(int height, char width) {
        this.nodes = new Node[height][width-'A'+1];
        for (int h=0; h<height; h++) {
            for (int w=0; w<(width-'A'+1); w++) {
                nodes[h][w] = new Node();
                nodes[h][w].setNum(0); 
            } 
        } 
    }
    
    public void set(int row, char column, int val) {
        nodes[row-1][column-'A'].setNum(val);
    } 
    
    public int get(int row, char column) {
        if (nodes[row-1][column-'A'].isNum) {
            return nodes[row-1][column-'A'].val;
        } else {
            return nodes[row-1][column-'A'].calculate();
        }
    } 
    
    public int sum(int row, char column, String[] numbers) {
        nodes[row-1][column-'A'].setFormula(numbers);
        return nodes[row-1][column-'A'].calculate(); 
    }
}



/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(height, width);
 * obj.set(row,column,val);
 * int param_2 = obj.get(row,column);
 * int param_3 = obj.sum(row,column,numbers);
 */