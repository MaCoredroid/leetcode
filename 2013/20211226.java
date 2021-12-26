class DetectSquares {

    int[][] points=new int[1001][1001];
    List<int[]> ans=new ArrayList<>();
    public DetectSquares() {
        
    }
    
    public void add(int[] point) {
        points[point[0]][point[1]]++;
        ans.add(point);
    }
    
    public int count(int[] point) {
        int x1=point[0],y1=point[1],cnt=0;
        for(int[] p:ans){
            int x3=p[0],y3=p[1];
            if(x1-x3==0||Math.abs(x1-x3)!=Math.abs(y1-y3)) continue;
            cnt+=points[x1][y3]*points[x3][y1];
        }
        return cnt;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */