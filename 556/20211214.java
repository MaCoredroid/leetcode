class Solution {
    public int nextGreaterElement(int n) {
        String input=""+n;
        int i=input.length()-1;
        char[] res=input.toCharArray();
        for(;i>0;i--){
            if(res[i-1]<res[i]){
                break;
            }
        }
        if(i==0) return -1;
        int l=i,r=res.length-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(res[mid]>res[i-1]){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        swap(res,l-1,i-1);
        
        reverse(res,i);
        try{
            return Integer.parseInt(new String(res));
        }catch(Exception e){
            return -1;
        }
        
        
    }
    
    public void reverse(char[] res,int i){
        int l=i,r=res.length-1;
        while(l<r){
            swap(res,l,r);
            l++;
            r--;
        }
    }
    public void swap(char[] res,int i,int j){
        char c=res[i];
        res[i]=res[j];
        res[j]=c;
    }
}