class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        int n=cars.length;
        double[] ret=new double[n];
        Arrays.fill(ret,-1.0);
        Stack<Integer> stack=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty()&&(cars[i][1]-cars[stack.peek()][1]<=0||(1.0*(cars[stack.peek()][0]-cars[i][0])/(cars[i][1]-cars[stack.peek()][1])>=ret[stack.peek()])&&ret[stack.peek()]>0)){
                stack.pop();
            }
            if(stack.size()>0){
                ret[i]=(1.0*(cars[stack.peek()][0]-cars[i][0])/(cars[i][1]-cars[stack.peek()][1]));
            }
            stack.push(i);
        }
        return ret;
            
    }
}