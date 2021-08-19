class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,Node> graph=new HashMap<>();
        LinkedList<Integer> list=new LinkedList<>();
        for(int[] prerequisite:prerequisites){
            Node from=createNode(graph,prerequisite[1]);
            Node to=createNode(graph,prerequisite[0]);
            from.next.add(prerequisite[0]);
            to.indegree++;
        }
        for(Map.Entry<Integer,Node> entry:graph.entrySet()){
            Node node=entry.getValue();
            if(node.indegree==0){
                list.add(entry.getKey());
            }
        }
        int removeEdge=0;
        while(list.size()>0){
            Integer course=list.pop();
            for(Integer nextCourse:graph.get(course).next){
                Node child=graph.get(nextCourse);
                child.indegree--;
                removeEdge++;
                if(child.indegree==0){
                    list.add(nextCourse);
                }
            }
        }
        return removeEdge==prerequisites.length;
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