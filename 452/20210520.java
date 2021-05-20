class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,new Comparator<>(){
            public int compare(int[] point1,int[] point2){
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int ans=1;
        int pos=points[0][1];
        for(int[] point:points){
            if(point[0]>pos){
                pos=point[1];
                ans++;
            }
        }
        return ans;
    }
}