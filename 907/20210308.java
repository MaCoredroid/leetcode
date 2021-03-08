class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1_000_000_007;
        int[] left = new int[arr.length];
        int[] right= new int[arr.length];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty()&&arr[i]<arr[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                left[i]=-1;
            }else{
                left[i]=stack.peek();
            }
            stack.push(i);
        }
        stack=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!stack.isEmpty()&&arr[i]<=arr[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                right[i]=arr.length;
            }else{
                right[i]=stack.peek();
            }
            stack.push(i);
        }
        long ans=0;
        for(int i=0;i<arr.length;i++){
            long partone=((i-left[i])*(right[i]-i))%mod;
            long parttwo=arr[i]*partone%mod;
            ans=(ans+parttwo)%mod;
        }
        return (int)ans;
    }
}