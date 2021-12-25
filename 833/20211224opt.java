class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int N=s.length();
        int[] match=new int[N];
        Arrays.fill(match,-1);
        for(int i=0;i<indices.length;i++){
            if(s.substring(indices[i],indices[i]+sources[i].length()).equals(sources[i])){
                match[indices[i]]=i;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<match.length;i++){
            if(match[i]!=-1){
                sb.append(targets[match[i]]);
                i+=sources[match[i]].length();
                i--;
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}