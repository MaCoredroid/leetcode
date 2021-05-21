class Solution {
    private int[] array;
    private int[] original;

    private Random rand = new Random();

    public Solution(int[] nums) {
        array=nums;
        original=nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array=original;
        original=original.clone();
        return array;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        List<Integer> ret=new ArrayList<>();
        for(int num:array){
            ret.add(num);
        }
        for(int i=0;i<array.length;i++){
            int id=rand.nextInt(ret.size());
            array[i]=ret.get(id);
            ret.remove(id);
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