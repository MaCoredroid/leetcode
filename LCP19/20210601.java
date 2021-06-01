class Solution {
    public int minimumOperations(String leaves) {
        int n=leaves.length();
        int[][] f=new int[n][3];
        f[0][0]= leaves.charAt(0)=='r'?0:1;
        f[0][1]=Integer.MAX_VALUE;
        f[0][2]=Integer.MAX_VALUE;
        f[1][2]=Integer.MAX_VALUE;
        for(int i=1;i<leaves.length();i++){
            int isRed=leaves.charAt(i)=='r'?0:1;
            int isYellow=leaves.charAt(i)=='y'?0:1;
            f[i][0]=f[i-1][0]+isRed;
            f[i][1]=Math.min(f[i-1][0],f[i-1][1])+isYellow;
            if(i>1){
                f[i][2]=Math.min(f[i-1][1],f[i-1][2])+isRed;
            }
        }
        return f[leaves.length()-1][2];
    }
}