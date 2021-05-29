class Solution {
    public int orchestraLayout(int num, int xPos, int yPos) {
        int n=num;
        int layer=Math.min(Math.min(xPos,yPos),Math.min(n-xPos-1,n-yPos-1));
        long index=((long)num*num-(long)(num-2*layer)*(num-2*layer))%9+1;
        int left=layer;
        int right=num-layer-1;
        if(xPos==left){
            index+=yPos-left;
        }else if(yPos==right){
            index+=right-left;
            index+=xPos-left;
        }else if(xPos==right){
            index+=right-left;
            index+=right-left;
            index+=right-yPos;
        }else{
            index+=right-left;
            index+=right-left;
            index+=right-left;
            index+=right-xPos;
        }
        return (int)(index%9==0?9:index%9);
    }
}