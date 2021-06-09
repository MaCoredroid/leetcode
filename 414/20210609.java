class Solution {
    public int thirdMax(int[] nums) {
        long one=Long.MIN_VALUE;
        long two=Long.MIN_VALUE;
        long three=Long.MIN_VALUE;
        for(int val:nums){
            if(val==one||val==two||val==three){
                continue;
            }
            if(val>one){
                three=two;
                two=one;
                one=val;
            }else if(val>two){
                three=two;
                two=val;
            }else if(val>three){
                three=val;
            }
        }
        return three==Long.MIN_VALUE?(int)one:(int)three;
    }
}