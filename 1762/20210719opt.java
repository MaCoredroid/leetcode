class Solution {
    public int[] findBuildings(int[] heights) {
        int max=-1;
        int index=heights.length-1;
        for(int i=heights.length-1;i>=0;i--){
            if(heights[i]>max){
                max=heights[i];
                heights[index--]=i;
            }
        }
        return Arrays.copyOfRange(heights,index+1,heights.length);
    }
}