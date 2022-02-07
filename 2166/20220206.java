class Bitset {
    boolean[] res;
    boolean flipcnt;
    int cnt;
    public Bitset(int size) {
        this.res=new boolean[size];
    }
    
    public void fix(int idx) {
        if(!(res[idx]^flipcnt)){
            res[idx]^=true;
            cnt++;
        }
    }
    
    public void unfix(int idx) {
        if((res[idx]^flipcnt)){
            res[idx]^=true;
            cnt--;
        }
    }
    
    public void flip() {
        flipcnt^=true;
        cnt=res.length-cnt;
    }
    
    public boolean all() {
        return cnt==res.length;
    }
    
    public boolean one() {
        return cnt>=1;
    }
    
    public int count() {
        return cnt;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (boolean b : res) {
            sb.append(b ^ flipcnt ? '1' : '0');
        }
        return sb.toString();
        
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */