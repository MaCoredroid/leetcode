class Solution {
    public int longestStrChain(String[] words) {
        TreeMap<Integer,List<Node>> map=new TreeMap<>();
        for(String s:words){
            if(!map.containsKey(s.length())){
                map.put(s.length(),new ArrayList<>());
            }
            map.get(s.length()).add(new Node(s,0));
        }
        int ret=0;
        for(Integer len:map.keySet()){
            if(map.containsKey(len-1)){
                for(Node s:map.get(len)){
                    for(Node p:map.get(len-1)){
                        if(isPre(p,s)){
                            s.cnt=Math.max(s.cnt,p.cnt+1);
                            ret=Math.max(s.cnt,ret);
                        }
                    }
                }
            }
        }
        return ret+1;
    }
    
    public boolean isPre(Node p,Node s){
        boolean flag=false;
        String pre=p.s;
        String next=s.s;
        int q=0;
        for(int i=0;i<pre.length();i++){
            if(pre.charAt(i)==next.charAt(q)){
                q++;
            }else if(!flag){
                flag=true;
                q++;
                i--;
            }else{
                return false;
            }
        }
        return true;
    }
    
    
}

class Node{
    String s;
    int cnt;
    public Node(String s,int cnt){
        this.s=s;
        this.cnt=cnt;
    }
}