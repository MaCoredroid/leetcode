class Solution {
    HashMap<Long,Long> map=new HashMap<>();
    public int maxProfit(int[] inventory, int orders) {
        int maxVal=0;
        for(int value:inventory){
            maxVal=Math.max(maxVal,value);
            map.put((long)value,map.getOrDefault((long)value,0L)+1);
        }
        int index=search(0,maxVal,orders);
        long ans=0;
        for(Map.Entry<Long,Long> entry:map.entrySet()){
            if(entry.getKey()>index){
                long num=entry.getValue()*(entry.getKey()-index);
                orders-=num;
                ans=(ans+(entry.getKey()+index+1)*num/2)%1_000_000_007;
            }
        }
        ans=(ans+orders*(long)index)%1_000_000_007;
        return (int)ans;
    }
    
    private int search(int left,int right,int orders){
        while(left<=right){
            int middle=left+((right-left)>>1);
            if(check(middle,orders)){
                left=middle+1;
            }else{
                right=middle-1;
            }
        }
        return left;
    }
    
    private boolean check(long value,long orders){
        for(Map.Entry<Long,Long> entry:map.entrySet()){
            if(entry.getKey()>value){
                orders-=entry.getValue()*(entry.getKey()-value);
            }
        }
        return orders<=0;
    }
}