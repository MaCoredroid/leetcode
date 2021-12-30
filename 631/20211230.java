class Excel {
    Node[][] nodes;
    Stack<int[]> stack=new Stack<>();
    public Excel(int height, char width) {
        nodes=new Node[height][width-'A'+1];
    }
    
    public void set(int row, char column, int val) {
        nodes[row-1][column-'A']=new Node(new HashMap<String,Integer>(),val);
        sort(row-1,column-'A');
        execute_stack();
    }
    
    public int get(int row, char column) {
        if(nodes[row-1][column-'A']==null) return 0;
        return nodes[row-1][column-'A'].val;
    }
    
    public int sum(int row, char column, String[] numbers) {
        HashMap<String,Integer> map=convert(numbers);
        int ans=calculate(row-1,column-'A',map);
        set(row,column,ans);
        nodes[row-1][column-'A']=new Node(map,ans);
        return ans;
    }
    
    public HashMap<String,Integer> convert(String[] strs){
        HashMap<String,Integer> res=new HashMap<>();
        for(String s:strs){
            if(s.indexOf(":")<0){
                res.put(s,res.getOrDefault(s,0)+1);
            }else{
                String[] cells=s.split(":");
                int si=Integer.parseInt(cells[0].substring(1)),ei=Integer.parseInt(cells[1].substring(1));
                char sj=cells[0].charAt(0),ej=cells[1].charAt(0);
                for(int i=si;i<=ei;i++){
                    for(char j=sj;j<=ej;j++){
                        res.put(""+j+i,res.getOrDefault(""+j+i,0)+1);
                    }
                }
            }
        }
        return res;
    }
    
    public void sort(int r,int c){
        for(int i=0;i<nodes.length;i++){
            for(int j=0;j<nodes[0].length;j++){
                if(nodes[i][j]!=null&&nodes[i][j].map.containsKey(""+(char)('A'+c)+(r+1))){
                    sort(i,j);
                }
            }
        }
        stack.push(new int[]{r,c});
    }
    
    public void execute_stack(){
        while(!stack.isEmpty()){
            int[] top=stack.pop();
            if(nodes[top[0]][top[1]].map.size()>0){
                calculate(top[0],top[1],nodes[top[0]][top[1]].map);
            }
        }
    }
    
    public int calculate(int r,int c,HashMap < String, Integer > map){
        int sum=0;
        for(String s:map.keySet()){
            int x=Integer.parseInt(s.substring(1))-1,y=s.charAt(0)-'A';
            sum+=(nodes[x][y]!=null?nodes[x][y].val:0)*map.get(s);
        }
        nodes[r][c]=new Node(map,sum);
        return sum;
    }
}

class Node{
    HashMap<String,Integer> map;
    int val;
    public Node(HashMap<String,Integer> map,int v){
        this.map=map;
        this.val=v;
    }
}
/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(height, width);
 * obj.set(row,column,val);
 * int param_2 = obj.get(row,column);
 * int param_3 = obj.sum(row,column,numbers);
 */