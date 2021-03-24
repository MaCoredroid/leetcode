class Solution {
    List<HashMap<String,Integer>> scope=new ArrayList<>();
    public int evaluate(String expression) {
        scope.add(new HashMap<>());
        int ans=evaluate_inner(expression);
        scope.remove(scope.size()-1);
        return ans;
    }

    private int evaluate_inner(String expression){
        char[] ch= expression.toCharArray();
        if(ch[0]!='('){
            if(ch[0]=='-'||Character.isDigit(ch[0])){
                return Integer.parseInt(expression);
            }
            for(int i=scope.size()-1;i>=0;i--){
                if(scope.get(i).containsKey(expression)){
                    return scope.get(i).get(expression);
                }
            }
        }
        List<String> tokens=new ArrayList<>();
        if(ch[1]=='m'){
            tokens=parse(expression.substring(6,expression.length()-1));
            return evaluate(tokens.get(0))*evaluate(tokens.get(1));
        }else{
            tokens=parse(expression.substring(5,expression.length()-1));
            if(ch[1]=='a'){
                return evaluate(tokens.get(0))+evaluate(tokens.get(1));
            }else{
                for(int i=1; i<tokens.size();i+=2){
                    scope.get(scope.size()-1).put(tokens.get(i-1),evaluate(tokens.get(i)));
                }
                return evaluate(tokens.get(tokens.size()-1));
            }
        }
    }

    private List<String> parse(String expression){
        int count=0;
        List<String> ans=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        for(String token: expression.split(" ")){
            char[] ch= token.toCharArray();
            for(int i=0;i<ch.length;i++){
                if(ch[i]=='('){
                    count++;
                }else if(ch[i]==')'){
                    count--;
                }
            }
            if(sb.length()>0){
                sb.append(" ");
            }
            sb.append(token);
            if(count==0){
                ans.add(new String(sb));
                sb=new StringBuilder();
            }
        }
        if(sb.length()>0){
            ans.add(new String(sb));
        }
        return ans;
    }
}