class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> ans=new ArrayList<>();
        backTrack(ans,num.toCharArray(),0,0,0);
        return ans;
    }

    private boolean backTrack(List<Integer> ans,char[] ch,int index,int sum,int prev){
        if(index==ch.length){
            return ans.size()>=3;
        }
        long currlong=0;
        for(int i=index;i<ch.length;i++){
            if(i>index&&ch[index]=='0'){
                break;
            }
            currlong=currlong*10+ch[i]-'0';
            if(currlong>Integer.MAX_VALUE){
                break;
            }
            int curr=(int)currlong;
            if(ans.size()>=2){
                if(curr>sum){
                    break;
                }else if(curr<sum){
                    continue;
                }
            }
            ans.add(curr);
            if(backTrack(ans,ch,i+1,prev+curr,curr)){
                return true;
            }else{
                ans.remove(ans.size()-1);
            }
        }
        return false;
    }
}