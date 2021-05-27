class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        DualHeap dh=new DualHeap(k);
        for(int i=0;i<k;i++){
            dh.insert(nums[i]);
        }
        double[] res=new double[nums.length-k+1];
        res[0]=dh.getMedian();
        for(int i=k;i<nums.length;i++){
            dh.erase(nums[i-k]);
            dh.insert(nums[i]);
            res[i-k+1]=dh.getMedian();
        }
        return res;
    }
}

class DualHeap{
    PriorityQueue<Integer> small = new PriorityQueue<Integer>(new Comparator<Integer>() {
        public int compare(Integer num1, Integer num2) {
            return num2.compareTo(num1);
        }
    });
    PriorityQueue<Integer> large = new PriorityQueue<Integer>(new Comparator<Integer>() {
        public int compare(Integer num1, Integer num2) {
            return num1.compareTo(num2);
        }
    });


    private Map<Integer, Integer> delayed=new HashMap<>();
    private int k;
    private int largesize=0;
    private int smallsize=0;
    public DualHeap(int k){
        this.k=k;
    }
    public Double getMedian(){
        return (k&1)==1?(double)small.peek():((double)small.peek()+large.peek())/2.0;
    }

    public void insert(int num){
        if(small.isEmpty()||num<=small.peek()){
            small.offer(num);
            smallsize++;
        }else {
            large.offer(num);
            largesize++;
        }
        makeBalance();
    }

    public void erase(int num){
        delayed.put(num,delayed.getOrDefault(num,0)+1);
        if(num<=small.peek()){
            smallsize--;
            if(num==small.peek()){
                prune(small);
            }
        }else{
            largesize--;
            if(num==large.peek()){
                prune(large);
            }

        }
        makeBalance();
    }

    private void makeBalance(){
        if(smallsize>largesize+1){
            large.offer(small.poll());
            largesize++;
            smallsize--;
            prune(small);
        }else if(smallsize<largesize){
            small.offer(large.poll());
            largesize--;
            smallsize++;
            prune(large);
        }
    }

    private void prune(PriorityQueue<Integer> heap){
        while(!heap.isEmpty()){
            int num=heap.peek();
            if(delayed.containsKey(num)){
                delayed.put(num,delayed.get(num)-1);
                if(delayed.get(num)==0){
                    delayed.remove(num);
                }
                heap.poll();
            }else{
                break;
            }
        }
    }

}