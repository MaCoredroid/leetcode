class Solution {
    public int minCostToMoveChips(int[] position) {
        int num1=0,num2=0;
        for(int i=0;i<position.length;i++){
            if(position[i]%2==0){
                num1++;
            }else{
                num2++;
            }
        }
        return Math.min(num1,num2);
    }
}