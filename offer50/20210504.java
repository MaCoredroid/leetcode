class Solution {
    public char firstUniqChar(String s) {
        Queue<Character> queue=new LinkedList<>();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),-1);
                while(!queue.isEmpty()&&map.get(queue.peek())==-1){
                    queue.poll();
                }
            }else{
                map.put(s.charAt(i),0);
                queue.offer(s.charAt(i));
            }
        }
        return queue.isEmpty()?' ':queue.peek();
    }
}