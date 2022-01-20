class Solution {
    public String nextClosestTime(String time) {
        char[] result=time.toCharArray();
        char[] digits=new char[]{result[0],result[1],result[3],result[4]};
        Arrays.sort(digits);
        result[4]=findNext(result[4],'9',digits);
        if(result[4] > time.charAt(4)) return String.valueOf(result);  // e.g. 23:43 -> 23:44
        
        // find next digit for HH:_M
        result[3] = findNext(result[3], '5', digits);
        if(result[3] > time.charAt(3)) return String.valueOf(result);  // e.g. 14:29 -> 14:41
        
        // find next digit for H_:MM
        result[1] = result[0] == '2' ? findNext(result[1], '3', digits) : findNext(result[1], '9', digits);
        if(result[1] > time.charAt(1)) return String.valueOf(result);  // e.g. 02:37 -> 03:00 
        
        // find next digit for _H:MM
        result[0] = findNext(result[0], '2', digits);
        return String.valueOf(result);
    }
    
    public char findNext(char cur,char upper,char[] digits){
        if(cur==upper){
            return digits[0];
        }
        int pos = Arrays.binarySearch(digits, cur) + 1;
        while(pos < 4 && (digits[pos] > upper || digits[pos] == cur)) { // traverse one by one to find next greater digit
            pos++;
        }
        return pos == 4 ? digits[0] : digits[pos];
    }
}