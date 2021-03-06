class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n=buildings.length;
        List<List<Integer>> output=new ArrayList<>();
        if(n==0){
            return output;
        }else if(n==1){
            output.add(Arrays.asList(buildings[0][0],buildings[0][2]));
            output.add(Arrays.asList(buildings[0][1],0));
            return output;
        }
        List<List<Integer>> left=getSkyline(Arrays.copyOfRange(buildings,0,n/2));
        List<List<Integer>> right=getSkyline(Arrays.copyOfRange(buildings,n/2,n));
        return mergeSkyline(left,right);
        
    }

    public List<List<Integer>> mergeSkyline(List<List<Integer>> left,List<List<Integer>> right){
        int pointerLeft=0;
        int pointerRight=0;
        int prevMax=0;
        int x=0;
        int leftY=0;
        int rightY=0;
        List<List<Integer>> output= new ArrayList<>();
        while(pointerLeft<left.size()&&pointerRight<right.size()){
            if(left.get(pointerLeft).get(0)<right.get(pointerRight).get(0)){
                x=left.get(pointerLeft).get(0);
                leftY=left.get(pointerLeft).get(1);
                pointerLeft++;
            }else{
                x=right.get(pointerRight).get(0);
                rightY=right.get(pointerRight).get(1);
                pointerRight++;
            }
            if(prevMax!=Math.max(leftY,rightY)){
                updateOutput(output,x,Math.max(leftY,rightY));
                prevMax=Math.max(leftY,rightY);
            }
        }
        appendSkyline(output,left,pointerLeft,prevMax);
        appendSkyline(output,right,pointerRight,prevMax);
        return output;
    }

    public void updateOutput(List<List<Integer>> output,int x,int maxY){
        if(output.isEmpty()||output.get(output.size()-1).get(0)!=x){
            output.add(Arrays.asList(x,maxY));
        }else{
            output.set(output.size()-1,Arrays.asList(x,maxY));
        }
    }

    public void appendSkyline(List<List<Integer>> output,List<List<Integer>> skyline,int pointer,int prevMax){
        while(pointer<skyline.size()){
            if(skyline.get(pointer).get(1)!=prevMax){
                updateOutput(output,skyline.get(pointer).get(0),skyline.get(pointer).get(1));
                prevMax=skyline.get(pointer).get(1);
            }
            pointer++;
        }
    }
}