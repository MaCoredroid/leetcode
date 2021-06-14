class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String max="";
        for(String target:dictionary){
            if(check(target,s)&&(target.length()>max.length()||(target.length()==max.length()&&target.compareTo(max)<0))){
                max=target;
            }
        }
        return max;
    }

    private boolean check(String target,String s){
        char[] ch1=target.toCharArray();
        char[] ch2=s.toCharArray();
        int j=0;
        for(int i=0;i<ch2.length&&j<ch1.length;i++){
            if(ch2[i]==ch1[j]){
                j++;
            }
        }
        return j==ch1.length;
    }
}