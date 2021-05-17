class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] res=preorder.split(",");
        int[] pointer=new int[]{0};
        if(!helper(res,pointer)){
            return false;
        }
        return pointer[0]==res.length;


    }

    private boolean helper(String[] res, int[] pointer){
        if(pointer[0]>=res.length){
            return false;
        }
        if(res[pointer[0]].equals("#")){
            pointer[0]++;
            return true;
        }
        pointer[0]++;
        if(!helper(res,pointer)){
            return false;
        }
        return helper(res,pointer);
    }
}