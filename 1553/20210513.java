class Solution {
    Map<Integer,Integer> memo=new HashMap<Integer,Integer>();
    public int minDays(int n) {
        if(n<=1){
            return n;
        }
        if(!memo.containsKey(n)){
            memo.put(n,Math.min(1+n%2+minDays(n/2),1+n%3+minDays(n/3)));
        }
        return memo.get(n);
    }
}