class SnapshotArray {
    List<int[]>[] res;
    int sid;
    public SnapshotArray(int length) {
        res=new List[length];
        sid=0;
        for(int i=0;i<length;i++){
            res[i]=new ArrayList<>();
            res[i].add(new int[]{0,0});
        }
    }
    
    public void set(int index, int val) {
        if(res[index].get(res[index].size()-1)[0]==sid){
            res[index].get(res[index].size()-1)[1]=val;
        }else{
            res[index].add(new int[]{sid,val});
        }
    }
    
    public int snap() {
        return sid++;
    }
    
    public int get(int index, int snap_id) {
        List<int[]> list=res[index];
        int l=0,r=list.size()-1;
        while(l<=r){
            int mid=l+((r-l)>>1);
            if(list.get(mid)[0]==snap_id){
                return list.get(mid)[1];
            }else if(list.get(mid)[0]>snap_id){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return list.get(l-1)[1];
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */