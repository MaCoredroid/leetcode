class DetectSquares {
    Map<Integer,Map<Integer,Integer>> map=new HashMap<>();
    public DetectSquares() {
        
    }
    
    public void add(int[] point) {
        if(!map.containsKey(point[0])){
            map.put(point[0],new HashMap<>());
        }
        map.get(point[0]).put(point[1],map.get(point[0]).getOrDefault(point[1],0)+1);
    }
    
    public int count(int[] point) {
        int cnt=0;
        int x=point[0],y=point[1];
        if(map.get(x)==null) return 0;
        Map<Integer,Integer> res=map.get(x);
        for(int y1:res.keySet()){
            if(y1!=y){
                int len=Math.abs(y-y1);
                int leftX=x-len;
                if(map.containsKey(leftX)){
                    cnt+=map.get(leftX).getOrDefault(y1,0)*
                        map.get(leftX).getOrDefault(y,0)*
                        res.get(y1);
                }
                int rightX=x+len;
                if(map.containsKey(rightX)){
                    cnt+=map.get(rightX).getOrDefault(y1,0)*
                        map.get(rightX).getOrDefault(y,0)*
                        res.get(y1);
                }
            }
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