class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index=findX(arr,x);
        int l=index-1,r=index;
        LinkedList<Integer> ans=new LinkedList<>();
        while(k>0){
            if(l<0){
                ans.add(arr[r++]);
            }else if(r>=arr.length){
                ans.addFirst(arr[l--]);
            }else if(x-arr[l]<=arr[r]-x){
                ans.addFirst(arr[l--]);
            }else{
                ans.add(arr[r++]);
            }
            k--;
        }
        return ans;
    }
    
    public int findX(int[] arr,int x){
        int l=0,r=arr.length-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(arr[mid]==x){
                return mid;
            }else if(arr[mid]>x){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
}