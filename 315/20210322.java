class Solution {
    private int[] index;
    private int[] temp;
    private int[] tempIndex;
    private int[] ans;


    public List<Integer> countSmaller(int[] nums) {
        index=new int[nums.length];
        tempIndex=new int[nums.length];
        temp=new int[nums.length];
        ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            index[i]=i;
        }
        merge(nums,0,nums.length-1);
        List<Integer> list = new ArrayList<Integer>();
        for (int num : ans) {
            list.add(num);
        }
        return list;
    }

    private void merge(int[] nums,int left,int right){
        if(left>=right){
            return;
        }
        int mid=(left+right)>>1;
        merge(nums,left,mid);
        merge(nums,mid+1,right);
        mergeSort(nums,left,mid,right);
    }

    private void mergeSort(int[] nums,int left,int mid,int right){
        int i=left; 
        int j= mid+1;
        for(int k=left;k<=right;k++){
            if(i==mid+1){
                temp[k]=nums[j];
                tempIndex[k]=index[j];
                j++;
            }else if(j==right+1){
                temp[k]=nums[i];
                tempIndex[k]=index[i];
                ans[index[i]]+=j-mid-1;
                i++;
            }else if(nums[i]<=nums[j]){
                ans[index[i]]+=j-mid-1;
                temp[k]=nums[i];
                tempIndex[k]=index[i];
                i++;
            }else{
                temp[k]=nums[j];
                tempIndex[k]=index[j];
                j++;
            }
        }
        for(int k=left;k<=right;k++){
            nums[k]=temp[k];
            index[k]=tempIndex[k];
        }

    }

    
}