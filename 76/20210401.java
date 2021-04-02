class Solution {
    public String minWindow(String s, String t) {
        String ans="";
        char[] origin=s.toCharArray();
        char[] key=t.toCharArray();
        int left=0;
        int right=0;
        HashMap<Character,Integer> res=new HashMap<>();
        HashMap<Character,Integer> cur=new HashMap<>();
        for(int i=0;i<key.length;i++){
            res.put(key[i],res.getOrDefault(key[i],0)+1);
        }
        while(right<origin.length){
            if(res.get(origin[right])!=null){
                cur.put(origin[right],cur.getOrDefault(origin[right],0)+1);
            }
            while(left<=right&&verify(res,cur)){
                if(ans.equals("")||ans.length()>right-left+1){
                    ans=s.substring(left,right+1);
                }
                if(res.get(origin[left])!=null){
                    cur.put(origin[left],cur.getOrDefault(origin[left],0)-1);
                    if(cur.get(origin[left])<=0){
                        cur.remove(origin[left]);
                    }
                }
                left++;
            }
            right++;
        }
        return ans;
    }

    private boolean verify(HashMap<Character,Integer> res,HashMap<Character,Integer> cur){
        for (Map.Entry<Character,Integer> entry : res.entrySet()){
            if(cur.getOrDefault(entry.getKey(),0)<entry.getValue()){
                return false;
            }
        }
        return true;
    }
}