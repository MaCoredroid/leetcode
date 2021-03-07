class Solution {
    public int scoreOfParentheses(String S) {
        int temp=0;
        Stack<Pair<Integer,Integer>> stack=new Stack<>();
        int i=0;
        while(i<S.length()){
            if(S.charAt(i)=='('){
                stack.push(new Pair<>(temp,i));
                temp=0;
            }else{
                Pair<Integer,Integer> pair=stack.pop();
                if(i-pair.getValue()==1){
                    temp=pair.getKey()+1;
                }else{
                    temp=pair.getKey()+temp*2;
                }
            }
            i++;
        }
        return temp;
    }
}