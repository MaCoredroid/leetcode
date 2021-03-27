class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans=new int[n];
        Stack<Integer> stack=new Stack<>();
        int prevTime=0;
        for(String log:logs){
            String[] res=log.split(":");
            int id=Integer.parseInt(res[0]);
            String ops=res[1];
            int time=Integer.parseInt(res[2]);
            if(ops.equals("start")){
                if(!stack.isEmpty()){
                    int oldId=stack.peek();
                    ans[oldId]+=time-prevTime;
                }
                stack.push(id);
                prevTime=time;
            }else{
                if(!stack.isEmpty()){
                    int oldId=stack.pop();
                    ans[oldId]+=time-prevTime+1;
                }
                if(!stack.isEmpty()){
                    prevTime=time+1;
                }
            }
        }
        return ans;
    }
}