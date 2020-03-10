class Solution {
    public List<Integer> sortArray(int[] nums) {
        ArrayList output=new ArrayList<Integer>();
        if(nums.length==0)
        {
            return output;
        }
        quickSort(nums,0,nums.length-1);
        for(int i=0;i<nums.length;i++)
        {
            output.add(nums[i]);
        }
        return output;
    }
    public void quickSort(int[] arr, int start, int end)
    {
        if(start>=end)
        {
            return;
        }
        int left=start;
        int right=end;
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
        quickSort(arr,left,start-1);
        quickSort(arr,start+1,right);
    }
}