class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<=path.length();i++){
            if(i==path.length()||path.charAt(i)=='/'){
                if(sb.length()>0){
                    if(sb.toString().equals("..")){
                        if(stack.size()>0){
                            stack.pop();
                        }
                    }else if(!sb.toString().equals(".")){
                        stack.push(sb.toString());
                    }
                    sb=new StringBuilder();
                }
            }else{
                sb.append(path.charAt(i));
            }
        }
        sb=new StringBuilder();
        while(stack.size()>0){
            sb.insert(0,stack.pop());
            sb.insert(0,"/");
        }
        if(sb.length()==0){
            sb.append("/");
        }
        return sb.toString();
    }
}