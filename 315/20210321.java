class Solution {
    private int[] c;
    private int[] a;
    public List<Integer> countSmaller(int[] nums) {
        HashSet<Integer> res=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            res.add(nums[i]);
        }
        a=new int[res.size()];
        int count=0;
        for(Integer i:res){
            a[count++]=i;
        }
        Arrays.sort(a);
        List<Integer> ret= new ArrayList<>();
        c=new int[nums.length+1];
        Arrays.fill(c,0);

        for(int i=nums.length-1;i>=0;i--){
            int id=Arrays.binarySearch(a,nums[i])+1;
            ret.add(query(id-1));
            update(id);
        }
        Collections.reverse(ret);
        return ret;
    }

    private int query(int index){
        int ret=0;
        while(index>0){
            ret+=c[index];
            index-=lowbit(index);
        }
        return ret;
    }

    private void update(int index){
        while(index<c.length){
            c[index]+=1;
            index+=lowbit(index);
        }
    }
    private int lowbit(int x){
        return x&-x;
    }
}