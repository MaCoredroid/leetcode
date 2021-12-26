class Solution {
    
    int[] array;
    int[] origin;
    Random rand=new Random();

    public Solution(int[] nums) {
        array=nums;
        origin=nums.clone();
    }
    
    public int[] reset() {
        array=origin;
        origin=origin.clone();
        return origin;
    }
    
    public int[] shuffle() {
        for(int i=0;i<array.length;i++){
            int index=rand.nextInt(array.length-i)+i;
            int temp=array[i];
            array[i]=array[index];
            array[index]=temp;
        }
        return array;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */