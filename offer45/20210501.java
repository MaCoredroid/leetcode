class Solution {
    public String minNumber(int[] nums) {
        StringBuilder sb=new StringBuilder();
        sort(nums,0,nums.length-1);
        for(int num:nums){
            sb.append(num);
        }
        return sb.toString();
    }

    private void sort(int[] nums,int left,int right){
        if(left>=right){
            return;
        }
        int p=left;
        int q=right;
        int value=nums[p];
        while(p<q){
            while(p<q&&compare(nums[q],value)>=0){
                q--;
            }
            nums[p]=nums[q];
            while(p<q&&compare(nums[p],value)<=0){
                p++;
            }
            nums[q]=nums[p];
        }
        nums[p]=value;
        sort(nums,left,p-1);
        sort(nums,p+1,right);

    }

    private int compare(int x,int y){
        int base=10;
        while(y/base>0){
            base*=10;
        }
        int ans1=x*base+y;
        base=10;
        while(x/base>0){
            base*=10;
        }
        int ans2=y*base+x;
        return ans1-ans2;
    }
}