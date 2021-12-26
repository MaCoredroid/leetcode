class Solution {
    public String minWindow(String s1, String s2) {
        char[] ch1=s1.toCharArray();
        char[] ch2=s2.toCharArray();
        int p1=0,p2=0,len1=s1.length(),len2=s2.length(), start = -1, len = len1+1;
        while(p1<len1){
            if(ch1[p1]==ch2[p2]){
                if(++p2==len2){
                    int end=p1+1;
                    while(--p2>=0){
                        while(ch1[p1]!=ch2[p2]){
                            p1--;
                        }
                        p1--;
                    }
                    p1++;
                    p2++;
                    if(end-p1<len){
                        start=p1;
                        len=end-p1;
                    }
                }
            }
            p1++;
        }
        return start==-1?"":s1.substring(start,start+len);
    }
}