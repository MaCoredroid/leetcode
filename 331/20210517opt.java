class Solution {
    public boolean isValidSerialization(String preorder) {
        int slots=1;
        int pointer=0;
        while(pointer<preorder.length()){
            if(slots==0){
                return false;
            }
            if(preorder.charAt(pointer)==','){
                pointer++;
            }else if(preorder.charAt(pointer)=='#'){
                pointer++;
                slots--;
            }else{
                while(pointer<preorder.length()&&preorder.charAt(pointer)!=','){
                    pointer++;
                }
                slots++;
            }
        }
        return slots==0;


    }

    
}