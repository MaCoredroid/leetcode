class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> queue1=new LinkedList<>();
        Queue<Integer> queue2=new LinkedList<>();
        for(int i=0;i<senate.length();i++){
            if(senate.charAt(i)=='R'){
                queue1.offer(i);
            }else{
                queue2.offer(i);
            }
        }
        while(!queue1.isEmpty()&&!queue2.isEmpty()){
            Integer p1=queue1.poll();
            Integer p2=queue2.poll();
            if(p1<p2){
                queue1.offer(p1+senate.length());
            }else{
                queue2.offer(p2+senate.length());
            }
        }
        if(queue1.size()==0){
            return "Dire";
        }
        return "Radiant";

    }
}