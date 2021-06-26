class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points,(o1,o2)->(o1[0]*o1[0]+o1[1]*o1[1]-o2[0]*o2[0]-o2[1]*o2[1]));
        int[][] ret=new int[k][2];
        for(int i=0;i<k;i++){
            ret[i][0]=points[i][0];
            ret[i][1]=points[i][1];
        }
        return ret;
    }
}