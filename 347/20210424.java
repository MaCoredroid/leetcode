class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<int[]> res=new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            res.add(new int[]{entry.getKey(),entry.getValue()});
        }
        int[] ret=new int[k];
        qsort(res,ret,k,0,res.size()-1,0);
        return ret;
    }

    private void qsort(List<int[]> res,int[] ret,int k,int p,int q,int pointer){
        if(p>q){
            return;
        }
        int left=p;
        int right=q;
        int[] pivot=res.get(left);
        while(left<right){
            while(left<right&&res.get(right)[1]<=pivot[1]){
                right--;
            }
            res.set(left,res.get(right));
            while(left<right&&res.get(left)[1]>=pivot[1]){
                left++;
            }
            res.set(right,res.get(left));
        }
        res.set(left,pivot);
        if(k<=left-p){
            qsort(res,ret,k,p,left-1,pointer);
        }else{
            for(int i=p;i<=left;i++){
                ret[pointer++]=res.get(i)[0];
            }
            if(pointer<ret.length){
                qsort(res,ret,k-(left-p+1),left+1,q,pointer);
            }
        }
    }
}