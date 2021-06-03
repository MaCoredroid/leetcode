class Solution {
    public int findMaximumXOR(int[] nums) {
        int x=0;
        for(int i=30;i>=0;i--){
            Set<Integer> set=new HashSet<>();
            for(int num:nums){
                set.add(num>>i);
            }
            int next=x*2+1;
            boolean found=false;
            for(int num:nums){
                if(set.contains(next^(num>>i))){
                    found=true;
                    break;
                }
            }
            if(found){
                x=next;
            }else{
                x=next-1;
            }
        }
        return x;
    }
}