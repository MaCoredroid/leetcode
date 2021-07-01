class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        HashMap<String,List<Log>> map=new HashMap<>();
        for(int i=0;i<username.length;i++){
            if(!map.containsKey(username[i])){
                map.put(username[i],new ArrayList<>());
            }
            map.get(username[i]).add(new Log(timestamp[i],website[i]));
        }
        HashMap<String,Integer> cnt=new HashMap<>();
        for(Map.Entry<String,List<Log>> entry:map.entrySet()){
            List<Log> res=entry.getValue();
            Collections.sort(res,(o1,o2)->(o1.timestamp-o2.timestamp));
            Set<String> ans=new HashSet<>();
            helper(ans,res,new ArrayList<>(),0);
            for(String key:ans){
                cnt.put(key,cnt.getOrDefault(key,0)+1);
            }
        }
        String ans="";
        int max=0;
        for(Map.Entry<String,Integer> entry:cnt.entrySet()){
            if(entry.getValue()>max||(entry.getValue()==max&&entry.getKey().compareTo(ans)<0)){
                max=entry.getValue();
                ans=entry.getKey();
            }
        }
        List<String> ret=new ArrayList<>();
        String[] keys=ans.split(" ");
        for(String key:keys){
            ret.add(key);
        }
        return ret;
    }
    
    private void helper(Set<String> ans,List<Log> res,List<String> temp,int pos){
        if(temp.size()==3){
            StringBuilder sb=new StringBuilder();
            sb.append(temp.get(0)).append(" ").append(temp.get(1)).append(" ").append(temp.get(2));
            ans.add(sb.toString());
            return;
        }
        for(int i=pos;i<res.size();i++){
            temp.add(res.get(i).website);
            helper(ans,res,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
}

class Log{
    int timestamp;
    String website;
    public Log(int timestamp,String website){
        this.timestamp=timestamp;
        this.website=website;
    }
}