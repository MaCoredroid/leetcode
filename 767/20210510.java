class Solution {
    public String reorganizeString(String S) {
        char[] ch=S.toCharArray();
        if(S.length()<2){
            return S;
        }
        int[] count=new int[26];
        int maxCount=0;
        for(int i=0;i<ch.length;i++){
            count[ch[i]-'a']++;
            maxCount=Math.max(maxCount,count[ch[i]-'a']);
        }
        if(maxCount>(1+ch.length)/2){
            return "";
        }
        PriorityQueue<Character> queue=new PriorityQueue<Character>(new Comparator<Character>(){
            public int compare(Character a, Character b){
                return count[b-'a']-count[a-'a'];
            }
        });
        for(int i=0;i<26;i++){
            if(count[i]>0){
                queue.offer((char)('a'+i));
            }
        }
        StringBuilder sb=new StringBuilder();
        while(queue.size()>1){
            Character letter1=queue.poll();
            Character letter2=queue.poll();
            sb.append(letter1).append(letter2);
            count[letter1-'a']--;
            count[letter2-'a']--;
            if(count[letter1-'a']>0){
                queue.offer(letter1);
            }
            if(count[letter2-'a']>0){
                queue.offer(letter2);
            }
        }
        if(queue.size()>0){
            sb.append(queue.poll());
        }
        return sb.toString();
    }
}