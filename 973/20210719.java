class Solution {
    int k;
    Random random=new Random();
    public int[][] kClosest(int[][] points, int k) {
        this.k=k;
        sort(points,0,points.length-1);
        int[][] ret=new int[k][2];
        for(int i=0;i<k;i++){
            ret[i]=points[i];
        }
        return ret;
    }
    
    private void sort(int[][] points,int left,int right){
        int index=random.nextInt(right-left+1)+left;
        int[] temp=points[index];
        points[index]=points[left];
        points[left]=temp;
        int l=left,r=right;
        int[] pivot=points[l];
        while(l<r){
            while(l<r&&compare(pivot,points[r])<=0){
                r--;
            }
            points[l]=points[r];
            while(l<r&&compare(pivot,points[l])>=0){
                l++;
            }
            points[r]=points[l];
        }
        points[l]=pivot;
        if(l==k-1){
            return;
        }else if(l<k-1){
            sort(points,l+1,right);
        }else{
            sort(points,left,l-1);
        }
    }
    
    private int compare(int[] a,int[] b){
        return a[0]*a[0]+a[1]*a[1]-b[0]*b[0]-b[1]*b[1];
    }
}