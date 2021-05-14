class MedianFinder {
    List<Integer> ans=new ArrayList<>();
    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        int left=0;
        int right=ans.size()-1;
        while(left<=right){
            int middle=((right-left)>>1)+left;
            if(ans.get(middle)<num){
                left=middle+1;
            }else{
                right=middle-1;
            }
        }
        ans.add(left,num);
    }
    
    public double findMedian() {
        if(ans.size()%2==0){
            return(ans.get((0+ans.size()-1)/2)+ans.get((0+ans.size()-1)/2+1))/2.0;
        }else{
            return ans.get((0+ans.size()-1)/2);
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */