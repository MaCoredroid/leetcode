/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> ret=binaryMatrix.dimensions();
        int m=ret.get(0), n=ret.get(1);
        int left=0;
        int right=n-1;
        int[] arr=new int[m];
        Arrays.fill(arr,-1);
        while(left<=right){
            int mid=left+((right-left)>>1);
            boolean flag=false;
            for(int i=0;i<m;i++){
                if(arr[i]<mid&&binaryMatrix.get(i,mid)==1){
                    flag=true;
                    break;
                }else{
                    arr[i]=Math.max(mid,arr[i]);
                }
            }
            if(flag){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left==n?-1:left;
    }
}