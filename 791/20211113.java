class Solution {
    public String customSortString(String order, String s) {
        int[] dict=new int[128];
        for(int i=0;i<order.length();i++){
            dict[order.charAt(i)]=i;
        }
        char[] ch=s.toCharArray();
        sort(ch,dict,0,ch.length-1);
        return new String(ch);
    }
    
    public void sort(char[] ch,int[] dict,int left,int right){
        if(left>=right){
            return;
        }
        char pivot=ch[left];
        int l=left,r=right;
        while(l<r){
            while(l<r&&dict[ch[r]]>=dict[pivot]){
                r--;
            }
            ch[l]=ch[r];
            while(l<r&&dict[ch[l]]<=dict[pivot]){
                l++;
            }
            ch[r]=ch[l];
        }
        ch[l]=pivot;
        sort(ch,dict,left,l-1);
        sort(ch,dict,l+1,right);
    }
}