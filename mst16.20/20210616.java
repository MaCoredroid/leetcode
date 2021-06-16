class Solution {
    int l;
    int[] map = new int[]{0,0,0,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,5,6,6,6,7,7,7,7};
    public List<String> getValidT9Words(String num, String[] words) {
        l=num.length();
        int[] nums=new int[l];
        for(int i=0;i<l;i++){
            nums[i]=num.charAt(i)-'2';
        }
        List<String> res = new ArrayList<>();
        for(String word : words){
            if(isValid(nums,word)){
                res.add(word);
            }
        }
        return res;

    }

    private boolean isValid(int[] nums,String word){
        for(int i=0;i<l;i++){
            if(map[word.charAt(i)-'a']!=nums[i]){
                return false;
            }
        }
        return true;
    }
}