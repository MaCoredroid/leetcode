class Solution {
   
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<List<Integer>> neighbours=new ArrayList<>();
        int[] dp=new int[wordList.size()];
        boolean flag=false;
        int endIndex=0;
        for(int i=0;i<wordList.size();i++){
            neighbours.add(new ArrayList<Integer>());
            if(wordList.get(i).equals(endWord)){
                flag=true;
                endIndex=i;
            }
        }
        if(!flag){
            return 0;
        }
        Arrays.fill(dp,dp.length+1);
        for(int i=0;i<wordList.size();i++){
            if(canChange(beginWord,wordList.get(i))){
                dp[i]=1;
            }
            for(int j=i+1;j<wordList.size();j++){
                if(canChange(wordList.get(i),wordList.get(j))){
                    neighbours.get(i).add(j);
                    neighbours.get(j).add(i);
                }
            }
        }
        boolean updateFlag=false;
        while(!updateFlag){
            for(int i=0;i<wordList.size();i++){
                int min=wordList.size()+1;
                for(Integer neighbour:neighbours.get(i)){
                    min=Math.min(min,dp[neighbour]);
                }
                if(dp[i]>min+1){
                    dp[i]=min+1;
                    updateFlag=true;
                }
            }
            updateFlag=!updateFlag;
        }
        if(dp[endIndex]!=dp.length+1){
            return dp[endIndex]+1;
        }
        return 0;
    }

    private boolean canChange(String a,String b){
        if(a.length()!=b.length()){
            return false;
        }
        int count=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                count++;
            }
        }
        return count==1;
    }

    

    
}