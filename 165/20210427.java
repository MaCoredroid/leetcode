class Solution {
    public int compareVersion(String version1, String version2) {
        int i=0;
        int j=0;
        while(i<version1.length()||j<version2.length()){
            int leftI=i;
            while(i<version1.length()&&version1.charAt(i)!='.'){
                i++;
            }
            int leftJ=j;
            while(j<version2.length()&&version2.charAt(j)!='.'){
                j++;
            }
            String num1="",num2="";
            if(i<=version1.length()){
                num1=version1.substring(leftI,i);
            }
            if(j<=version2.length()){
                num2=version2.substring(leftJ,j);
            }
            int ans=compare(num1,num2);
            if(ans!=0){
                return ans;
            }
            i++;
            j++;
        }
        return 0;
    }

    private int compare(String a,String b){
        int num1=0,num2=0;      
        for(int i=0;i<a.length();i++){
            num1*=10;
            num1+=a.charAt(i)-'0';
        }
        for(int i=0;i<b.length();i++){
            num2*=10;
            num2+=b.charAt(i)-'0';
        }
        if(num1>num2){
            return 1;
        }else if(num1<num2){
            return -1;
        }else{
            return 0;
        }
    }
}