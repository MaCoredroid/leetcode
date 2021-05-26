class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if(jug1Capacity+jug2Capacity<targetCapacity){
            return false;
        }
        if(jug1Capacity==0||jug2Capacity==0){
            return targetCapacity==0||jug2Capacity+jug1Capacity==targetCapacity;
        }
        return targetCapacity%gcd(jug1Capacity,jug2Capacity)==0;
    }

    public int gcd(int a,int b){
        int remainder=a%b;
        while(remainder!=0){
            a=b;
            b=remainder;
            remainder=a%b;
        }
        return b;
    }
}