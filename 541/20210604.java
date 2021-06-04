class Solution {
    public String reverseStr(String s, int k) {
        char[] ch=s.toCharArray();
        int p=0;
        while(p<ch.length){
            int right=p;
            for(int i=0;i<k&&right<ch.length;i++){
                right++;
            }
            int left=p;
            p=right;
            right--;
            while(left<right){
                char temp=ch[left];
                ch[left]=ch[right];
                ch[right]=temp;
                left++;
                right--;
            }
            for(int i=0;i<k&&p<ch.length;i++){
                p++;
            }
        }
        return new String(ch);
    }
}