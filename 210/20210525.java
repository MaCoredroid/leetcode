class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges=new ArrayList<>();
        int[] indeg=new int[numCourses];
        int[] result=new int[numCourses];
        int index=0;
        for(int i=0;i<numCourses;i++){
            edges.add(new ArrayList<>());
        }
        for(int[] res:prerequisites){
            edges.get(res[1]).add(res[0]);
            indeg[res[0]]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int temp=queue.poll();
            result[index++]=temp;
            for(int clean:edges.get(temp)){
                indeg[clean]--;
                if(indeg[clean]==0){
                    queue.offer(clean);
                }
            }
        }
        if(index==numCourses){
            return result;
        }
        return new int[0];

    }
}