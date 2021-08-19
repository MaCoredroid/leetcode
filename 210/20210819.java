class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Node> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new Node());
        }
        for(int[] prerequisite:prerequisites){
            Node from=graph.get(prerequisite[1]);
            Node to=graph.get(prerequisite[0]);
            from.next.add(prerequisite[0]);
            to.inDegree++;
        }
        LinkedList<Integer> list=new LinkedList<>();
        int points=0;
        int[] ret=new int[numCourses];
        int p=0;
        for(int i=0;i<numCourses;i++){
            if(graph.get(i).inDegree==0){
                list.add(i);
                ret[p++]=i;
                points++;
            }
        }
        while(list.size()>0&&points<numCourses){
            Integer course=list.pop();
            for(Integer nextCourse:graph.get(course).next){
                Node next=graph.get(nextCourse);
                next.inDegree--;
                if(next.inDegree==0){
                    list.add(nextCourse);
                    ret[p++]=nextCourse;
                    points++;
                }
            }
        }
        if(points<numCourses){
            return new int[0];
        }
        return ret;
    }
    
}

class Node{
    public List<Integer> next=new ArrayList<>();
    public int inDegree=0;
}