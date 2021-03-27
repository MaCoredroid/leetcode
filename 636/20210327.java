class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans=new int[n];
        Stack<Pair<Integer,Integer>> stack=new Stack<>();
        for(String log:logs){
            String[] res=log.split(":");
            int id=Integer.parseInt(res[0]);
            String ops=res[1];
            int time=Integer.parseInt(res[2]);
            if(ops.equals("start")){
                if(!stack.isEmpty()){
                    Pair<Integer,Integer> pair=stack.peek();
                    ans[pair.getKey()]+=time-pair.getValue();
                }
                stack.push(new Pair<Integer,Integer>(id,time));
            }else{
                if(!stack.isEmpty()){
                    Pair<Integer,Integer> pair=stack.pop();
                    ans[pair.getKey()]+=time-pair.getValue()+1;
                }
                if(!stack.isEmpty()){
                    Pair<Integer,Integer> pair=stack.pop();
                    stack.push(new Pair<Integer,Integer>(pair.getKey(),time+1));
                }
            }
        }
        return ans;
    }
}