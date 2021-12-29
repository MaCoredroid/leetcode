class Solution {
    public String getHint(String secret, String guess) {
        int cntBulls=0,cntCows=0;
        int[] cnt1=new int[10];
        int[] cnt2=new int[10];
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
                cntBulls++;
            }else{
                cnt1[secret.charAt(i)-'0']++;
                cnt2[guess.charAt(i)-'0']++;
            }
        }
        for(int p=0;p<10;p++){
            cntCows+=Math.min(cnt1[p],cnt2[p]);
        }
        return cntBulls+"A"+cntCows+"B";
    }
}