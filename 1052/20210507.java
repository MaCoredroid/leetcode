class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int total=0;
        for(int i=0;i<grumpy.length;i++){
            if(grumpy[i]==0){
                total+=customers[i];
            }
        }
        int increase=0;
        int max=0;
        for(int i=0;i<X;i++){
            increase+=customers[i]*grumpy[i];
        }
        max=increase;
        for(int i=X;i<grumpy.length;i++){
            increase-=customers[i-X]*grumpy[i-X];
            increase+=customers[i]*grumpy[i];
            max=Math.max(increase,max);
        }
        return total+max;
    }
}