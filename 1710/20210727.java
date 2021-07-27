class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(o1,o2)->(o2[1]-o1[1]));
        int ans=0;
        int p=0;
        while(truckSize>0&&p<boxTypes.length){
            ans+=Math.min(boxTypes[p][0],truckSize)*boxTypes[p][1];
            truckSize-=Math.min(boxTypes[p][0],truckSize);
            p++;
        }
        return ans;
    }
}