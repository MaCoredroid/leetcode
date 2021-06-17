class Solution {
    public List<String> removeComments(String[] source) {
        boolean inBlock=false;
        List<String> ret=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<source.length;i++){
            if(!inBlock){
                sb=new StringBuilder();
            }
            int j=0;
            int n=source[i].length();
            while(j<n){
                if(!inBlock&&j+1<n&&source[i].charAt(j)=='/'&&source[i].charAt(j+1)=='*'){
                    inBlock=true;
                    j++;
                }else if(inBlock&&j+1<n&&source[i].charAt(j)=='*'&&source[i].charAt(j+1)=='/'){
                    inBlock=false;
                    j++;
                }else if(!inBlock&&j+1<n&&source[i].charAt(j)=='/'&&source[i].charAt(j+1)=='/'){
                    break;
                }else if(!inBlock){
                    sb.append(source[i].charAt(j));
                }
                j++;
            }
            if (!inBlock && sb.length() > 0) {
                ret.add(new String(sb));
            }

        }
        return ret;
    }
}