class Solution {
    Random rand = new Random();
    public int[][] kClosest(int[][] points, int k) {
        sort(points,k,0,points.length-1);
        int[][] ret=new int[k][2];
        for(int i=0;i<k;i++){
            ret[i][0]=points[i][0];
            ret[i][1]=points[i][1];
        }
        return ret;
    }

    private void sort(int[][] points, int k, int start,int end){
        int left=start,right=end;
        if(left>=right){
            return;
        }
        int pivotId = left + rand.nextInt(right - left + 1);
        int[] temp=points[left];
        points[left]=points[pivotId];
        points[pivotId]=temp;
        temp=points[left];
        while(left<right){
            while(left<right&&compare(points[right],temp)>=0){
                right--;
            }
            points[left]=points[right];
            while(left<right&&compare(points[left],temp)<=0){
                left++;
            }
            points[right]=points[left];
        }
        points[left]=temp;
        if(left<=k){
            sort(points,k,left+1,end);
        }else{
            sort(points,k,start,left-1);
        }
    }

    public int compare(int[] o1,int[] o2){
        return o1[0]*o1[0]+o1[1]*o1[1]-o2[0]*o2[0]-o2[1]*o2[1];
    }
}