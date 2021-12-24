class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s=new Stack<>();
        List<Integer> head=new ArrayList<>();
        for(int x:asteroids){
            if(x>0){
                s.push(x);
            }else{
                while(!s.isEmpty()&&s.peek()<=Math.abs(x)){
                    if(s.pop()==Math.abs(x)){
                        x=0;
                        break;
                    }
                }
                if(x!=0&&s.isEmpty()) head.add(x);
            }
        }
        int[] ret=new int[s.size()+head.size()];
        for(int i=ret.length-1;!s.isEmpty();i--){
            ret[i]=s.pop();
        }
        for(int i=0;i<head.size();i++){
            ret[i]=head.get(i);
        }
        return ret;
    }
}