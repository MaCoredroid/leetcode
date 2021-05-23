class Solution {
    public String validIPAddress(String IP) {
        String[] res=IP.split("\\.");
        if(res.length==1){
            if(IP.chars().filter(ch -> ch == ':').count() != 7){
                return "Neither";
            }
            String[] ans=IP.split(":");
            if(checkIPV6(ans)){ 
                return "IPv6";
            }else{
                return "Neither";
            }
        }else if(IP.chars().filter(ch -> ch == '.').count() == 3&&checkIPV4(res)){
            return "IPv4";
        }else{
            return "Neither";
        }
    }

    private boolean checkIPV4(String[] res){
        if(res.length!=4){
            return false;
        }
        for(String s:res){
            int ans=0;
            char[] ch=s.toCharArray();
            boolean flag=true;
            if(ch.length>=4||ch.length==0){
                return false;
            }
            for(int i=0;i<ch.length;i++){
                if(ch[i]-'0'==0&&flag&&ch.length!=1){
                    return false;
                }else if(ch[i]-'0'>=0&&ch[i]-'0'<=9){
                    ans*=10;
                    ans+=ch[i]-'0';
                    flag=false;
                }else{
                    return false;
                }
            }
            if(ans>255){
                return false;
            }
        }
        return true;
    }

    private boolean checkIPV6(String[] res){
        if(res.length!=8){
            return false;
        }
        for(String s:res){
            char[] ch=s.toCharArray();
            if(ch.length==0||ch.length>4){
                return false;
            }
            for(int i=0;i<ch.length;i++){
                if(ch[i]>='0'&&ch[i]<='9'){
                    continue;
                }
                if(ch[i]>='a'&&ch[i]<='f'){
                    continue;
                }
                if(ch[i]>='A'&&ch[i]<='F'){
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}