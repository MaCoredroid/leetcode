class Solution {
    public String intToRoman(int num) {
        int[] values=new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] keys=new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb= new StringBuilder();
        int pointer=0;
        while(num>0){
            if(num/values[pointer]>0){
                for(int i=0;i<num/values[pointer];i++){
                    sb.append(keys[pointer]);
                }
                num%=values[pointer];
            }
            pointer++;
        }
        return sb.toString();
    }
}