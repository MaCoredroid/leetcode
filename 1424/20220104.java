class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        int maxVal=0;
        int cnt=0;
        for(int i=0;i<nums.size();i++){
            for(int j=0;j<nums.get(i).size();j++){
                if(!map.containsKey(i+j)) map.put(i+j,new ArrayList<>());
                map.get(i+j).add(nums.get(i).get(j));
                maxVal=Math.max(maxVal,i+j);
                cnt++;
            }
        }
        int[] ans=new int[cnt];
        int p=0;
        for(int sum=0;sum<=maxVal;sum++){
            Collections.reverse(map.get(sum));
            for(Integer v:map.get(sum)){
                ans[p++]=v;
            }
        }
        return ans;
    }
}