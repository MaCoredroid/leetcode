class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
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