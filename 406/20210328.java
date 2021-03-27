class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,new Comparator<int[]>(){
            public int compare(int[] people1,int[] people2){
                if(people1[0]!=people2[0]){
                    return people1[0]-people2[0];
                }else{
                    return people2[1]-people1[1];
                }
            }

        });
        int[][] ans=new int[people.length][2];
        Arrays.fill(ans,new int[]{-1,-1});
        for(int i=0;i<people.length;i++){
            int count=0;
            int pointer=0;
            while(count<people[i][1]){
                if(ans[pointer][0]==-1){
                    count++;
                }
                pointer++;
            }
            while(ans[pointer][0]!=-1){
                pointer++;
            }
            ans[pointer]=new int[]{people[i][0],people[i][1]};
        }
        return ans;
    }
}