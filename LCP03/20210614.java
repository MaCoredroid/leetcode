class Solution {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        int upCnt=0,rightCnt=0;
        for(char ch:command.toCharArray()){
            if(ch=='U'){
                upCnt++;
            }else{
                rightCnt++;
            }
        }
        if(!canReach(upCnt,rightCnt,command,x,y)){
            return false;
        }
        for(int[] obstacle:obstacles){
            if(obstacle[0]<=x&&obstacle[1]<=y&&canReach(upCnt,rightCnt,command,obstacle[0],obstacle[1])){
                return false;
            }
        }
        return true;
    }

    private boolean canReach(int upCnt, int rightCnt, String command, int destX, int destY){
        int loopCount=Math.min(destX/rightCnt,destY/upCnt);
        destX-=rightCnt*loopCount;
        destY-=upCnt*loopCount;
        for(char ch:command.toCharArray()){
            if(destY==0&&destX==0){
                return true;
            }
            if(ch=='U'){
                destY--;
            }else{
                destX--;
            }
        }
        return destX==0&&destY==0;
    }
}