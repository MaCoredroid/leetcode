class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> map = new ArrayList<>();
        for(int i=0;i<buildings.length;i++){
            map.add(new ArrayList<Integer>(Arrays.asList(buildings[i][0],-buildings[i][2])));
            map.add(new ArrayList<Integer>(Arrays.asList(buildings[i][1],buildings[i][2])));
        }
        List<List<Integer>> ans = new ArrayList<>();
        int LastHeight=0;
        PriorityQueue<Integer> heap=new PriorityQueue<>(Collections.reverseOrder());
        int currentHeight=0;
        heap.add(0);
        Collections.sort(map, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> p1, List<Integer> p2) {
                int x1 = p1.get(0);
                int y1 = p1.get(1);
                int x2 = p2.get(0);
                int y2 = p2.get(1);
                if (x1 != x2) {
                    return x1 - x2;
                } else {
                    return y1 - y2;
                }
            }
        });
        for(List<Integer> pair : map){
            if(pair.get(1)<0){
                heap.add(-pair.get(1));
            }else{
                heap.remove(pair.get(1));
            }
            currentHeight=heap.peek();
            if(currentHeight!=LastHeight){
                ans.add(new ArrayList<Integer>(Arrays.asList(pair.get(0),currentHeight)));
                LastHeight=currentHeight;
            }
        }
        return ans;


    }
}