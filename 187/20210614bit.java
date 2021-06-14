class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int L=10,n=s.length();
        if(n<=L){
            return new ArrayList<>();
        }
        int a=4,aL=(int)Math.pow(a,L);
        Map<Character, Integer> toInt = new HashMap() {{put('A', 0); put('C', 1); put('G', 2); put('T', 3); }};
        int[] nums = new int[n];
        for(int i = 0; i < n; ++i) nums[i] = toInt.get(s.charAt(i));
        int bitmask=0;
        Set<Integer> seen=new HashSet<>();
        Set<String> output=new HashSet<>();
        for(int start=0;start<n-L+1;start++){
            if(start>0){
                bitmask<<=2;
                bitmask|=nums[start+L-1];
                bitmask&=~(3 << 2 * L);
            }else{
                for(int i=0;i<L;i++){
                    bitmask<<=2;
                    bitmask|=nums[i];
                }
            }
            if(seen.contains(bitmask)){
                output.add(s.substring(start,start+L));
            }
            seen.add(bitmask);
        }
        return new ArrayList<>(output);
    }
}