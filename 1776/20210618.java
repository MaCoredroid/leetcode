class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        int n=cars.length;
        Stack<Integer> mono_stack=new Stack<>();
        double[] res=new double[n];
        for(int i=n-1;i>=0;i--){
            while(!mono_stack.isEmpty()){
                if(cars[i][1]<=cars[mono_stack.peek()][1]){
                    mono_stack.pop();
                }else{
                    if(res[mono_stack.peek()]<0){
                        break;
                    }else{
                        double t=(double)(cars[mono_stack.peek()][0]-cars[i][0])/(cars[i][1]-cars[mono_stack.peek()][1]);
                        if(t<res[mono_stack.peek()]){
                            break;
                        }else{
                            mono_stack.pop();
                        }
                    }
                }
            }
            if(!mono_stack.isEmpty()){
                double t=(double)(cars[mono_stack.peek()][0]-cars[i][0])/(cars[i][1]-cars[mono_stack.peek()][1]);
                res[i]=t;
            }else{
                res[i]=-1.0;
            }
            mono_stack.push(i);
        }
        return res;
    }
}