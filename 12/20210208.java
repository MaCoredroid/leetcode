class Solution {
    public String intToRoman(int num) {
        String[] symbols=new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] values=new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuilder sb=new StringBuilder();
        int index=0;
        while(num!=0)
        {           
            for(int i=0;i<num/values[index];i++)
            {
                sb.append(symbols[index]);
            }
            num=num%values[index];     
            index++;
        }
        return sb.toString();
    }
    
}