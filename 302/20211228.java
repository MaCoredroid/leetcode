class Solution {
    public int minArea(char[][] image, int x, int y) {
        int m=image.length,n=image[0].length;
        int left=searchCol(image,0,y,0,m,true);
        int right=searchCol(image,y+1,n-1,0,m,false);
        int top=searchRow(image,0,x,left+1,right+1,true);
        int bottom = searchRow(image, x + 1, m-1, left+1, right+1, false);
        return (right - left) * (bottom - top);
    }
    
    public int searchCol(char[][] image,int i,int j,int top,int bottom,boolean flag){
        while(i<=j){
            int mid=(i+j)/2;
            boolean hasOne=false;
            for(int k=top;k<bottom;k++){
                if(image[k][mid]=='1'){
                    hasOne=true;
                    break;
                }
            }
            if(hasOne==flag) j=mid-1;
            else i=mid+1;
        }
        return i-1;
    }
    
    public int searchRow(char[][] image,int i,int j,int left,int right,boolean flag){
        while(i<=j){
            int mid=(i+j)/2;
            boolean hasOne=false;
            for(int k=left;k<right;k++){
                if(image[mid][k]=='1'){
                    hasOne=true;
                    break;
                }
            }
            if(hasOne==flag) j=mid-1;
            else i=mid+1;
        }
        return i-1;
    }
}

