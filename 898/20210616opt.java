class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        int n=arr.length;
        if(n<2){
            return n;
        }
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if((arr[i]&arr[j])==arr[i]){
                    break;
                }
                arr[j]|=arr[i];
                set.add(arr[j]);
            }
        }
        return set.add()
    }
}