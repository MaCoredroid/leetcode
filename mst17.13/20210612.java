class Solution {
    public int respace(String[] dictionary, String sentence) {
        int n=sentence.length();
        int[] dp=new int[n+1];
        Trie root=new Trie();
        for(String res:dictionary){
            root.insert(res);
        }
        for(int i=1;i<=n;i++){
            dp[i]=dp[i-1]+1;
            Trie curr=root;
            for(int j=i;j>=1;j--){
                int index=sentence.charAt(j-1)-'a';
                if(curr.next[index]==null){
                    break;
                }else if(curr.next[index].isEnd){
                    dp[i]=Math.min(dp[i],dp[j-1]);
                }
                if(dp[i]==0){
                    break;
                }
                curr=curr.next[index];
            }
        }
        return dp[n];
    }
}

class Trie{
    Trie[] next;
    boolean isEnd;
    public Trie(){
        next=new Trie[26];
        isEnd=false;
    }

    public void insert(String s){
        Trie root=this;
        char[] ch=s.toCharArray();
        for(int i=ch.length-1;i>=0;i--){
            int t=ch[i]-'a';
            if(root.next[t]==null){
                root.next[t]=new Trie();
            }
            root=root.next[t];
        }
        root.isEnd=true;
    }
}