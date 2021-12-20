class Solution {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] p : points) {
            if (!map.containsKey(p[0])) {
                map.put(p[0], new HashSet<>());
            }
            map.get(p[0]).add(p[1]);
        }
        Arrays.sort(points,(o1,o2)->(o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0]));
        int min=Integer.MAX_VALUE;
        for(int i=0;i<points.length-1;i++){
            for(int j=i+1;j<points.length;j++){
                int area=Math.abs((points[i][0]-points[j][0])*(points[i][1]-points[j][1]));
                if(area==0||area>=min){
                    continue;
                }
                if(map.get(points[i][0]).contains(points[j][1])&&map.get(points[j][0]).contains(points[i][1])){
                    min=area;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
        
    }
}