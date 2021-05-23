class Solution {
    public int paintingPlan(int n, int k) {
        if(k==0||k==n*n){
            return 1;
        }
        if(k<0||k>n*n){
            return 0;
        }
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if((i+j)*n-(i*j)==k){
                    res+=helper(n,i)*helper(n,j);
                }
            }
        }
        return res;
    }

    private int helper(int n,int i){
        if(i==0||i==n){
            return 1;
        }
        return compute(n)/compute(i)/compute(n-i);

    }

    private int compute(int i){
        int ret=1;
        for(int p=1;p<=i;p++){
            ret*=p;
        }
        return ret;
    }

}