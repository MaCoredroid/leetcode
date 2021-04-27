class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack=new Stack<>();
        char[] ch=S.toCharArray();
        for(int i=0;i<S.length();i++){
            while(i<S.length()&&!stack.isEmpty()&&stack.peek()==S.charAt(i)){
                stack.pop();
                i++;
            }
            if(i<S.length()){
                stack.push(S.charAt(i));
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0,stack.pop());
        }
        return sb.toString();
    }
}