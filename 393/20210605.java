class Solution {
    public boolean validUtf8(int[] data) {
        for(int i=0;i<data.length;i++){
            int j=7;
            for(;j>=0;j--){
                if((data[i]&(1<<j))==0){
                    break;
                }
            }
            int num=7-j-1;
            if(num==0||num>3){
                return false;
            }
            if(num==-1){
                continue;
            }
            if(!helper(data,i+1,num)){
                return false;
            }
            i+=num;
        }
        return true;
    }

    private boolean helper(int[] data,int pointer,int len){
        while(len>0){
            if(pointer>=data.length){
                return false;
            }
            if((data[pointer]&(1<<7))>0&&(data[pointer]&(1<<6))==0){
                pointer++;
                len--;
            }else{
                return false;
            }
        }
        return true;
    }
}