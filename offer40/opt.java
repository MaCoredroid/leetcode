class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k==0)
        {
            return new int[0];
        }
        if(k==arr.length )
        {
            return arr;
        }
        int[] res=new int[k];
        for(int i=0;i<k;i++)
        {
            res[i]=arr[i];
        }
        buildheap(res);
        for(int i=k;i<arr.length;i++)
        {
            if(arr[i]<res[0])
            {
                res[0]=arr[i];
                heapify(res,0);
            }
        }
        return res;
    }
    private void buildheap(int[] num)
    {
        int i=num.length-1;
        int index=(i-1)/2;
        while(index>=0)
        {
            heapify(num,index);
            index--;
        }
    }
    private void heapify(int[] num,int i)
    {
        int len=num.length;
        if(i>=len)
        {
            return;
        }
        int max=i;
        if(i*2+1<len&&num[i*2+1]>num[max])
        {
            max=i*2+1;
        }
        if(i*2+2<len&&num[i*2+2]>num[max])
        {
            max=i*2+2;
        }
        if(max!=i)
        {
            int temp=num[i];
            num[i]=num[max];
            num[max]=temp;
            heapify(num,max);
        }

    }
}