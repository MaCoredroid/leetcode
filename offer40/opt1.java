class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k==0)
        {
            return new int[0];
        }
        if(k==arr.length)
        {
            return arr;
        }
        int start=0;
        int end=arr.length-1;
        int index=partition(arr,start,end);
        while(index!=k-1&&start<end)
        {
            if(index>k-1)
            {
                end=index-1;
            }
            else
            {
                start=index+1;
            }
            index=partition(arr,start,end);
            
        }
        int[] ret=new int[k];
        for(int i=0;i<k;i++)
        {
            ret[i]=arr[i];
        }
        return ret;
    }
    private int partition(int[] arr,int start,int end)
    {
        int value=arr[start];
        while(start<end)
        {
            while(start<end&&arr[end]>=value)
            {
                end--;
            }
            arr[start]=arr[end];   
            while(start<end&&arr[start]<=value)
            {
                start++;
            }
            arr[end]=arr[start];         
        }
        arr[start]=value;
        return start;
    }
   
}