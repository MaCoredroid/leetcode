class Solution {
    public double angleClock(int hour, int minutes) {
        double ans=Math.abs((hour+minutes/60.0)*30.0-minutes*6.0);
        if(ans>180){
            ans=360-ans;
        }
        return ans;
    }
}