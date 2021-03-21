class Solution {
    int[] a;
    int[] c;
    public int reversePairs(int[] nums) {
        HashSet<Integer> res=new HashSet<>();
        int[] tmp = new int[nums.length];
        System.arraycopy(nums, 0, tmp, 0, nums.length);
        Arrays.sort(tmp);
        c=new int[nums.length+1];
        Arrays.fill(c,0);
        int count=0;
        for(int i=nums.length-1;i>=0;i--){
            int pos=Arrays.binarySearch(tmp,nums[i])+1;
            count+=query(pos-1);
            update(pos);
        }
        return count;
    }

    private int lowbit(int x){
        return x&(-x);
    }

    private int query(int x){
        int count=0;
        while(x>0){
            count+=c[x];
            x-=lowbit(x);
        }
        return count;
    }

    private void update(int x){
        while(x<c.length){
            c[x]++;
            x+=lowbit(x);
        }
    }

    
}