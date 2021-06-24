class Solution {
    public boolean isMagic(int[] target) {
        int n = target.length;
        int[] source = new int[n];
        int[] tempsource = new int[n];
        for(int i=0;i<n;i++){
            source[i] = i+1;
            tempsource[i] = i+1;
        }
        change(tempsource,0,n-1);
        int k;
        for(k=0;k<n;k++){
            if(tempsource[k] != target[k]) break;
        }
        if(k == 0) return false;
        if(k == n) return true;
        return canWork(target,k,source);
    }
    public boolean canWork(int[] target,int k,int[] source){
        int times = target.length%k==0?target.length/k:target.length/k+1;
        for(int i=0;i<times;i++){
            change(source,0+i*k,source.length-1);
            for(int j=i*k;j<Math.min(i*k+k,target.length);j++){
                if(target[j] != source[j]){
                    return false;
                }
            }
        }
        return true;
    }

    public void change(int[] target,int start,int end){
        if(start>=end){
            return;
        }
        int cur;
        int[] temp = new int[end-start+1];
        int tempIndex = 0;
        int index = start;
        for(cur=0;cur<=end-start;cur++){
            if(cur%2==1){
                target[index++]=target[start+cur];
            }else{
                temp[tempIndex++]=target[start+cur];
            }
        }
        for(int i=0;index<=end;i++){
            target[index++]=temp[i];
        }
    }
}