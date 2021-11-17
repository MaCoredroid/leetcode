class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans=new ArrayList<>();
        int p1=0,p2=0;
        while(p1<firstList.length&&p2<secondList.length){
            if(firstList[p1][1]<secondList[p2][0]){
                p1++;
            }else if(firstList[p1][0]>secondList[p2][1]){
                p2++;
            }else if(firstList[p1][1]<secondList[p2][1]){
                ans.add(new int[]{Math.max(firstList[p1][0],secondList[p2][0]),firstList[p1][1]});
                p1++;
            }else{
                ans.add(new int[]{Math.max(firstList[p1][0],secondList[p2][0]),secondList[p2][1]});
                p2++;
            }
        }
        int[][] ret=new int[ans.size()][2];
        for(int i=0;i<ret.length;i++){
            ret[i]=ans.get(i);
        }
        return ret;
    }
}