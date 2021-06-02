class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        if(ax1>bx1){
            return computeArea(bx1,by1,bx2,by2,ax1,ay1,ax2,ay2);
        }
        if(by1>=ay2||bx1>=ax2||ay1>=by2){
            return (bx2-bx1)*(by2-by1)+(ax2-ax1)*(ay2-ay1);
        }
        int up=Math.min(ay2,by2);
        int down=Math.max(ay1,by1);
        int left=Math.max(ax1,bx1);
        int right=Math.min(ax2,bx2);
        return (bx2-bx1)*(by2-by1)+(ax2-ax1)*(ay2-ay1)-Math.abs(left-right)*Math.abs(up-down);
    }
}