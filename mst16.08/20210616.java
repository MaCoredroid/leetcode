class Solution {
    private final int[] NUMBER = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 30, 40, 50, 60, 70, 80, 90, 100, 1000, 1000000, 1000000000};
    private final String[] WORDS = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety", "Hundred", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if(num==0){
            return "Zero";
        }
        int i = 30;
        while (i >= 0 && NUMBER[i] > num) --i;
        StringBuilder res=new StringBuilder();
        if(NUMBER[i]<=90){
            res.append(WORDS[i]);
        }else{
            res.append(numberToWords(num/NUMBER[i])).append(" ").append(WORDS[i]);
        }
        if(num%NUMBER[i]>0){
            res.append(" ").append(numberToWords(num%NUMBER[i]));
        }
        return res.toString();
    }
}