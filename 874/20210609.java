class Solution {
    int[][] dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set=new HashSet<>();
        for(int[] target:obstacles){
            set.add(target[0]+"*"+target[1]);
        }
        int[] ans=new int[]{0,0};
        int index=0;
        int ret=0;
        for(int val:commands){
            if(val==-1){
                index++;
                if(index==4){
                    index=0;
                }
            }else if(val==-2){
                index--;
                if(index==-1){
                    index=3;
                }
            }else{
                for(int i=0;i<val;i++){
                    ans[0]+=dirs[index][0];
                    ans[1]+=dirs[index][1];
                    if(set.contains(ans[0]+"*"+ans[1])){
                        ans[0]-=dirs[index][0];
                        ans[1]-=dirs[index][1];
                        break;
                    }
                    ret=Math.max(ret, ans[0]*ans[0]+ans[1]*ans[1]);
                }
            }
        }
        return ret;
    }
}