class Solution {
    public int cuttingRope(int n) {
        if(n<2)
        {
            return 0;
        }
        if(n==2)
        {
            return 1;
        }
        if(n==3)
        {
            return 2;
        }
        int timeOfThree=n/3;
        if(n-timeOfThree*3==1)
        {
            timeOfThree-=1;
        }
        int timeOfTwo=(n-timeOfThree*3)/2;
        return (int)Math.pow(3,timeOfThree)*(int)Math.pow(2,timeOfTwo);
    }
}