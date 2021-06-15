class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int p=-1;
        if(ruleKey.equals("type")){
            p=0;
        }else if(ruleKey.equals("color")){
            p=1;
        }else{
            p=2;
        }
        int ans=0;
        for(List<String> item:items){
            if(item.get(p).equals(ruleValue)){
                ans++;
            }
        }
        return ans;
    }
}