class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target){
            return 0;
        }
        for(int i=0;i<routes.length;i++){
            ans.add(new ArrayList<>());
            Arrays.sort(routes[i]);
        }
        Set<Integer> start=new HashSet<>();
        Set<Integer> end=new HashSet<>();
        Set<Integer> visited=new HashSet<>();
        for(int i=0;i<routes.length;i++){
            for(int j=i+1;j<routes.length;j++){
                if(intersect(routes[i],routes[j])){
                    ans.get(i).add(j);
                    ans.get(j).add(i);
                }
            }
        }
        for(int i=0;i<routes.length;i++){
            if(Arrays.binarySearch(routes[i],source)>=0){
                start.add(i);
                visited.add(i);
            }
            if(Arrays.binarySearch(routes[i],target)>=0){
                end.add(i);
                visited.add(i);
                if(start.contains(i)){
                    return 1;
                }
            }
        }
        int step=1;
        while(!start.isEmpty()&&!end.isEmpty()){
            step++;
            if(start.size()>end.size()){
                Set<Integer> temp=start;
                start=end;
                end=temp;
            }
            Set<Integer> newStartSet=new HashSet<>();
            if(exchange(start,end,newStartSet,visited)){
                return step;
            }
            start=newStartSet;
        }
        return -1;
    }

    private boolean intersect(int[] A,int[] B){
        int pointer1=0;
        int pointer2=0;
        while(pointer1<A.length&&pointer2<B.length){
            if(A[pointer1]==B[pointer2]){
                return true;
            }else if(A[pointer1]>=B[pointer2]){
                pointer2++;
            }else{
                pointer1++;
            }
        }
        return false;
    }

    private boolean exchange(Set<Integer> start,Set<Integer> end,Set<Integer> newStart,Set<Integer> visited){
        for(Integer a:start){
            List<Integer> neighbours=ans.get(a);
            for(Integer neighbour:neighbours){
                if(end.contains(neighbour)){
                    return true;
                }
                if(!visited.contains(neighbour)){
                    newStart.add(neighbour);
                    visited.add(neighbour);
                }
            }
        }
        return false;
    }
}