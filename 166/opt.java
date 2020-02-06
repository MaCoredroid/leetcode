class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0)
        {
            return "0";
        }
        StringBuilder sb=new StringBuilder();
        if((numerator<0)^(denominator<0))
        {
            sb.append("-");
        }
        long dividend=Math.abs(Long.valueOf(numerator));
        long divisor=Math.abs(Long.valueOf(denominator));
        sb.append(String.valueOf(dividend/divisor));
        long remainder=dividend%divisor;
        if(remainder==0)
        {
            return sb.toString();
        }
        sb.append(".");
        HashMap<Long,Integer> map= new HashMap<>();
        while(remainder!=0)
        {
            if(map.containsKey(remainder))
            {
                sb.insert(map.get(remainder),"(");
                sb.append(")");
                return sb.toString();
            }
            map.put(remainder,sb.length());
            remainder*=10;
            sb.append(remainder/divisor);
            remainder%=divisor;
        }
        return sb.toString();
    }
}