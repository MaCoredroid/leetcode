class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        Queue<Integer> queue= new LinkedList<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),-1);
                while(!queue.isEmpty()&&map.get(s.charAt(queue.peek()))==-1){
                    queue.poll();
                }
            }else{
                map.put(s.charAt(i),i);
                queue.offer(i);
            }
        }
        return queue.isEmpty()?-1:queue.peek();
    }
}