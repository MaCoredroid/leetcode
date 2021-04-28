class Solution {
    static final int TARGET=24;
    static final double EPSION=1e-6;
    static final int ADD=0, MULTIPLE=1, MINUS=2, DIVIDE=3;
    public boolean judgePoint24(int[] nums) {
        List<Double> list=new ArrayList<>();
        for(int num:nums){
            list.add((double)num);
        }
        return solve(list);

    }

    private boolean solve(List<Double> nums){
        if(nums.size()==0){
            return false;
        }
        if(nums.size()==1){
            return Math.abs(nums.get(0)-TARGET)<EPSION;
        }
        for(int i=0;i<nums.size();i++){
            for(int j=0;j<nums.size();j++){
                if(i!=j){
                    List<Double> list2=new ArrayList<>();
                    for(int k=0;k<nums.size();k++){
                        if(k!=i&&k!=j){
                            list2.add(nums.get(k));
                        }
                    }
                    for(int k=0;k<4;k++){
                        if(k<2&&i>j){
                            continue;
                        }
                        if(k==ADD){
                            list2.add(nums.get(i)+nums.get(j));
                        }else if(k==MULTIPLE){
                            list2.add(nums.get(i)*nums.get(j));
                        }else if(k==MINUS){
                            list2.add(nums.get(i)-nums.get(j));
                        }else{
                            list2.add(nums.get(i)/nums.get(j));
                        }
                        if(solve(list2)){
                            return true;
                        }
                        list2.remove(list2.size()-1);
                    }
                }
            }
        }
        return false;
    }
}