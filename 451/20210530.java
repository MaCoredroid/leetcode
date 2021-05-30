class Solution {
    public String frequencySort(String s) {
        int[] count=new int[128];
        char[] ch=s.toCharArray();
        for(int i=0;i<ch.length;i++){
            count[ch[i]]++;
        }
        PriorityQueue<Character> pq=new PriorityQueue<Character>((o1,o2)->(count[o2]-count[o1]));
        for(int i=0;i<128;i++){
            if(count[i]!=0){
                pq.offer((char)i);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            Character temp=pq.poll();
            for(int i=0;i<count[temp];i++){
                sb.append(temp);
            }
        }
        return sb.toString();
    }
}