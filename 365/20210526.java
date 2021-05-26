class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        Deque<int[]> stack=new LinkedList<>();
        stack.push(new int[]{0,0});
        Set<Long> visited=new HashSet<>();
        while(!stack.isEmpty()){
            if(visited.contains(hash(stack.peek()))){
                stack.pop();
                continue;
            }
            int[] state=stack.poll();
            visited.add(hash(state));
            if(state[0]==targetCapacity||state[1]==targetCapacity||state[0]+state[1]==targetCapacity){
                return true;
            }
            stack.push(new int[]{state[0],jug2Capacity});
            stack.push(new int[]{jug1Capacity,state[1]});
            stack.push(new int[]{0,state[1]});
            stack.push(new int[]{state[0],0});
            stack.push(new int[]{state[0]-Math.min(state[0],jug2Capacity-state[1]),state[1]+Math.min(jug2Capacity-state[1],state[0])});
            stack.push(new int[]{state[0]+Math.min(state[1],jug1Capacity-state[0]),state[1]-Math.min(state[1],jug1Capacity-state[0])});
        }
        return false;
    }

    public long hash(int[] state) {
        return (long) state[0] * 1000001 + state[1];
    }
}