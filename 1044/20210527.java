class Solution {
    String ans="";
    String target="";
    public String longestDupSubstring(String s) {
        this.target=s;
        int[] nums=new int[s.length()];
        for(int i=0;i<s.length();i++){
            nums[i]=s.charAt(i)-'a';
        }
        int left=0;
        int right=s.length()-1;
        while(left<=right){
            int mid=left+((right-left)>>1);
            if(search(nums,mid)){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return ans;
    }

    public boolean search(int[] nums,int len){
        long h = 0;
        long modulus = (long)Math.pow(2, 37)-1;
        for(int i=0;i<len;i++){
            h=(h*26+nums[i])%modulus;
        }
        Set<Long> set=new HashSet<>();
        set.add(h);
        Long aL=1L;
        for(int i=1;i<=len;i++){
            aL=(aL*26)%modulus;
        }
        for(int start=1;start<nums.length-len+1;start++){
            h = (h * 26 - nums[start - 1] * aL % modulus + modulus) % modulus;
            h = (h + nums[start + len - 1]) % modulus;
            if(set.contains(h)){
                ans=target.substring(start,start+len);
                return true;
            }
            set.add(h);
        }
        return false;
    }
}