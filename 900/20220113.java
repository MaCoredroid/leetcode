class RLEIterator {
    int[] encoding;
    int p=0;
    public RLEIterator(int[] encoding) {
        this.encoding=encoding;
    }
    
    public int next(int n) {
        while(p<encoding.length){
            if(encoding[p]>=n){
                encoding[p]-=n;
                return encoding[p+1];
            }else{
                n-=encoding[p];
                p+=2;
            }
        }
        return -1;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */