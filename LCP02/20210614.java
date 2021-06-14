class Solution {
    public int[] fraction(int[] cont) {
        int n=cont[cont.length-1];
        int m=1;
        for(int i=cont.length-2;i>=0;i--){
            int tmp=n;
            n=n*cont[i]+m;
            m=tmp;
        }
        return new int[]{n,m};
    }
}