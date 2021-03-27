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
        int[][] ans=new int[people.length][];
        for(int i=0;i<people.length;i++){
            int count=people[i][1]+1;
            for(int j=0;j<people.length;j++){
                if(ans[j]==null){
                    count--;
                    if(count==0){
                        ans[j]=people[i];
                        break;
                    }
                }
            }
        }
        return ans;
    }
}