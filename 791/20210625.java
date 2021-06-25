class Solution {
    int[] weights=new int[26];
    public String customSortString(String order, String str) {
        
        Arrays.fill(weights,27);
        for(int i=0;i<order.length();i++){
            char c=order.charAt(i);
            weights[c-'a']=i;
        }
        char[] ch=str.toCharArray();
        sort(ch,0,ch.length-1);
        return new String(ch);
    }

    private void sort(char[] ch,int left,int right){
        if(left>=right){
            return;
        }
        char res=ch[left];
        int pivot=weights[ch[left]-'a'];
        int start=left;
        int end=right;
        while(start<end){
            while(start<end&&weights[ch[end]-'a']>=pivot){
                end--;
            }
            ch[start]=ch[end];
            while(start<end&&weights[ch[start]-'a']<=pivot){
                start++;
            }
            ch[end]=ch[start];
        }
        ch[start]=res;
        sort(ch,left,start-1);
        sort(ch,start+1,right);
    }
}