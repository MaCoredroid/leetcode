class Solution {
    public int minJump(int[] jump) {
        for(int i=jump.length-1;i>=0;i--){
            int distance=jump[i];
            if(i+distance>=jump.length){
                jump[i]=1;
            }else{
                jump[i]=jump[i+distance]+1;
            }
            for(int j=i+1;j<jump.length&&j<i+distance&&jump[j]>jump[i];j++){
                jump[j]=jump[i]+1;
            }

        }
        return jump[0];

    }
}