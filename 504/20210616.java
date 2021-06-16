class Solution {
    public String convertToBase7(int num) {
        if(num==0){
            return "0";
        }
        if(num<0){
            return "-"+convertToBase7(-num);
        }
        int base=1;
        while(base<=num){
            base*=7;
        }
        base/=7;
        StringBuilder sb=new StringBuilder();
        while(num>0||base!=0){
            sb.append(num/base);
            num=num%base;
            base/=7;
        }
        return sb.toString();

    }
}