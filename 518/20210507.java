class Solution {
    HashMap<String,Integer> map=new HashMap<>();
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        return helper(amount,coins,0);
    }

    private int helper(int amount, int[] coins,int pointer){
        String s=amount+"*"+pointer;
        if(map.containsKey(s)){
            return map.get(s);
        }
        if(amount==0){
            return 1;
        }
        if(pointer==coins.length){
            return 0;
        }
        int times=amount/coins[pointer];
        if(times==0){
            return 0;
        }
        int count=0;
        for(int i=0;i<=times;i++){
            count+=helper(amount-i*coins[pointer],coins,pointer+1);
        }
        map.put(s,count);
        return count;
    }
}