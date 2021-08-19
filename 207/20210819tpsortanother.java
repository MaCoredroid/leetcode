class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,Node> graph=new HashMap<>();
        LinkedList<Integer> list=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            createNode(graph,i);
        }
        for(int[] prerequisite:prerequisites){
            Node from=createNode(graph,prerequisite[1]);
            Node to=createNode(graph,prerequisite[0]);
            from.next.add(prerequisite[0]);
            to.indegree++;
        }
        int points=0;
        for(Map.Entry<Integer,Node> entry:graph.entrySet()){
            Node node=entry.getValue();
            if(node.indegree==0){
                list.add(entry.getKey());
                points++;
            }
        }
        while(list.size()>0&&points<numCourses){
            Integer course=list.pop();
            for(Integer nextCourse:graph.get(course).next){
                Node child=graph.get(nextCourse);
                child.indegree--;
                if(child.indegree==0){
                    points++;
                    list.add(nextCourse);
                }
            }
        }
        return points==numCourses;
    }
    
    private Node createNode(HashMap<Integer,Node> graph,Integer course){
        if(!graph.containsKey(course)){
            graph.put(course,new Node());
        }
        return graph.get(course);
    }
}

class Node{
    public List<Integer> next=new ArrayList<>();
    public int indegree=0;
}