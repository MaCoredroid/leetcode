class KthLargest {
    int[] heap;
    int size=0;
    int count=0;
    public KthLargest(int k, int[] nums) {
        heap=new int[k];
        count=k;
        for(int i=0;i<nums.length;i++){
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        if(size<count){
            heap[size]=val;
            up(size);
            size++;
        }else{
            if(heap[0]<val){
                heap[0]=val;
                down(0);
            }
        }
        return heap[0];
    }

    private void down(int index){
        int t=index;
        if(2*index+1<size&&heap[2*index+1]<heap[t]){
            t=2*index+1;
        }
        if(2*index+2<size&&heap[2*index+2]<heap[t]){
            t=2*index+2;
        }
        if(t!=index){
            int temp=heap[index];
            heap[index]=heap[t];
            heap[t]=temp;
            down(t);
        }
    }

    private void up(int index){
        while((index+1)/2-1>=0&&heap[(index+1)/2-1]>heap[index]){
            int temp=heap[index];
            heap[index]=heap[(index+1)/2-1];
            heap[(index+1)/2-1]=temp;
            index=(index+1)/2-1;
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */