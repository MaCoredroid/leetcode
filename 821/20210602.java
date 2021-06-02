class Solution {
    public int[] shortestToChar(String s, char c) {
        char[] ch=s.toCharArray();
        int[] answer=new int[ch.length];
        Arrays.fill(answer,ch.length);
        for(int i=0;i<ch.length;i++){
            if(ch[i]==c){
                answer[i]=0;
                int left=i-1;
                int temp=1;
                while(left>=0&&ch[left]!=c&&answer[left]>temp){
                    answer[left--]=temp++;
                }
                int right=i+1;
                temp=1;
                while(right<ch.length&&ch[right]!=c&&answer[right]>temp){
                    answer[right++]=temp++;
                }
            }
        }
        return answer;
    }
}