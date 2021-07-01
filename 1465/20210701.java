class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxH=Math.max(horizontalCuts[0],h-horizontalCuts[horizontalCuts.length-1]);
        int maxV=Math.max(verticalCuts[0],w-verticalCuts[verticalCuts.length-1]);
        for(int i=0;i<verticalCuts.length-1;i++){
            maxV=Math.max(maxV,verticalCuts[i+1]-verticalCuts[i]);
        }
        for(int i=0;i<horizontalCuts.length-1;i++){
            maxH=Math.max(maxH,horizontalCuts[i+1]-horizontalCuts[i]);
        }
        return (int)(((long)(maxV))*maxH%1000_000_007);
    }
}