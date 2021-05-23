class Solution {
    public boolean oneEditAway(String first, String second) {
        if(first.length()<second.length()){
            return oneEditAway(second,first);
        }
        if(first.length()-second.length()>=2){
            return false;
        }else if(first.length()-second.length()==1){
            int p1=0,p2=0;
            while(p2<second.length()&&first.charAt(p1)==second.charAt(p2)){
                p1++;
                p2++;
            }
            p1++;
            while(p2<second.length()&&first.charAt(p1)==second.charAt(p2)){
                p1++;
                p2++;
            }
            return p1==first.length();

        }else{
            int p1=0,p2=0;
            while(p2<second.length()&&first.charAt(p1)==second.charAt(p2)){
                p1++;
                p2++;
            }
            p1++;
            p2++;
            while(p2<second.length()&&first.charAt(p1)==second.charAt(p2)){
                p1++;
                p2++;
            }
            return p1>=first.length();
        }
        
    }
}