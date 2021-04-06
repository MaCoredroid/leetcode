class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        int count=gcd(nums.length,k);
        for(int i=0;i<count;i++){
            int current=i;
            int prev=nums[current];
            current=(current+k)%nums.length;
            while(current!=i){
                int next=nums[current];
                nums[current]=prev;
                prev=next;
                current=(current+k)%nums.length;
            }
            nums[current]=prev;
        }
    }

    public int gcd(int x, int y){
        return y>0?gcd(y,x%y):x;
    }
}