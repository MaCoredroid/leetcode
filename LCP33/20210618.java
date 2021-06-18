class Solution {
    public int storeWater(int[] bucket, int[] vat) {
        PriorityQueue<int[]> queue=new PriorityQueue<int[]>(new Comparator<int[]>() {//按照倾倒次数降序排列
			public int compare(int[] s1,int[] s2) {
				return s2[0]-s1[0];
			}
		});
		int num=0,res=Integer.MAX_VALUE;
        for(int i=0;i<bucket.length;i++){
            if(vat[i]==0){
                continue;
            }else if(bucket[i]==0){
                queue.offer(new int[]{vat[i],i});
                bucket[i]++;
                num++;
            }else{
                queue.offer(new int[]{(vat[i]-1)/bucket[i]+1,i});
            }
        }
        while(!queue.isEmpty()){
            int[] temp=queue.poll();
            if(num>=res){
                return res;
            }
            res=Math.min(res,num+temp[0]);
            bucket[temp[1]]++;
            num++;
            queue.offer(new int[]{(vat[temp[1]]-1)/bucket[temp[1]]+1,temp[1]});
        }
        return num;
    }
}