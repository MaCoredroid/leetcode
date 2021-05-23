class Solution {
    public int getKthMagicNumber(int k) {
        int p3=1,p5=1,p7=1;
        int[] numList=new int[k+1];
        numList[1]=1;
        for(int i=2;i<=k;i++){
            numList[i]=Math.min(Math.min(numList[p3]*3,numList[p5]*5),numList[p7]*7);
            if(numList[i]==numList[p3]*3) p3++;
            if(numList[i]==numList[p5]*5) p5++;
            if(numList[i]==numList[p7]*7) p7++;
        }
        return numList[k];
    }
}