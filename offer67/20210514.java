class Solution {
    public int strToInt(String str) {

        char[] ch=str.toCharArray();
        int pointer=0;
        while(pointer<str.length()&&ch[pointer]==' '){
            pointer++;
        }
        boolean isNeg=false;
        if(pointer>=ch.length){
            return 0;
        }
        if(ch[pointer]=='-'){
            isNeg=true;
            pointer++;
        }else if(ch[pointer]=='+'){
            pointer++;
        }
        int base=0;
        while(pointer<str.length()&&ch[pointer]>='0'&&ch[pointer]<='9'){
            if(isNeg&&(base<Integer.MIN_VALUE/10||(base==Integer.MIN_VALUE/10&&ch[pointer]-'0'>8))){
                return Integer.MIN_VALUE;
            }
            if(!isNeg&&(base>Integer.MAX_VALUE/10||(base==Integer.MAX_VALUE/10&&ch[pointer]-'0'>7))){
                return Integer.MAX_VALUE;
            }
            base*=10;
            if(isNeg){
                base-=ch[pointer]-'0';
            }else{
                base+=ch[pointer]-'0';
            }
            pointer++;
        }
        return base;
    }
}