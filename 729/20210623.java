class MyCalendar {
    List<Integer> head=new ArrayList<>();
    List<Integer> tail=new ArrayList<>();
    public MyCalendar() {

    }
    
    public boolean book(int start, int end) {
        int left=0;
        int right=head.size()-1;
        while(left<=right){
            int mid=left+((right-left)>>1);
            if(head.get(mid)>start){
                right=mid-1;
            }else if(head.get(mid)<start){
                left=mid+1;
            }else{
                return false;
            }
        }
        if(left<head.size()&&end>head.get(left)){
            return false;
        }
        if(left-1>=0&&tail.get(left-1)>start){
            return false;
        }
        head.add(left,start);
        tail.add(left,end);
        return true;
    }
}



/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */