class Solution {
    public String numberToWords(int num) {
        if(num==0){
            return "Zero";
        }
        int[] nums=new int[]{1000000000, 1000000,1000,100};
        String[] words=new String[]{"Billion","Million","Thousand","Hundred"};
        
        int p=0;
        StringBuilder sb=new StringBuilder();
        while(p<nums.length){
            if(num<nums[p]){
                p++;
                continue;
            }
            sb.append(" "+numberToWords(num/nums[p]));
            sb.append(" "+words[p]);
            num=num%nums[p];
            p++;
        }
        sb.append(" "+LessThanHundred(num));
        return sb.toString().trim();
    }
    
    public String LessThanHundred(int num){
        if(num<20) return LessThanTwenty(num);
        String[] words={"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        return words[num/10]+" "+LessThanTwenty(num%10);
    }
    
    public String LessThanTwenty(int num){
        String[] words = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        return words[num];
    }
}