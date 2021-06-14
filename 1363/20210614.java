class Solution {
    public String largestMultipleOfThree(int[] digits) {
        int[] cnt=new int[10];
        int[] remainders=new int[3];
        int sum=0;
        for(int digit:digits){
            sum+=digit;
            cnt[digit]++;
            remainders[digit%3]++;
        }
        int remove=0,rest=0;
        if(sum%3==1){
            if(remainders[1]>=1){
                remove=1;
                rest=1;
            }else{
                remove=2;
                rest=2;
            }
        }else if(sum%3==2){
            if(remainders[2]>=1){
                remove=2;
                rest=1;
            }else{
                remove=1;
                rest=2;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<10;i++){
            for(int j=0;j<cnt[i];j++){
                if(rest!=0&&remove==i%3){
                    rest--;
                }else{
                    sb.append((char)('0'+i));
                }
            }
        }
        if(sb.length()==0){
            return "";
        }
        if(sb.charAt(sb.length()-1)=='0'){
            return "0";
        }
        return sb.reverse().toString();
    }
}