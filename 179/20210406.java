class Solution {

    private class LargeNumber implements Comparator<String>{
        @Override
        public int compare(String num1,String num2){
            String s1=num1+num2;
            String s2=num2+num1;
            return s2.compareTo(s1);
        }
    }
    public String largestNumber(int[] nums) {
        String[] res=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            res[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(res, new LargeNumber());
        if(res[0].equals("0")){
            return "0";
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<res.length;i++){
            sb.append(res[i]);
        }
        return sb.toString();
    }
}