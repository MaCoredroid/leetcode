class Solution {
    Map<String,List<Integer>> map=new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {
        if(expression.length()==0){
            return new ArrayList<Integer>();
        }
        if(map.containsKey(expression)){
            return map.get(expression);
        }
        List<Integer> ret=new ArrayList<>();
        char[] ch=expression.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='+'||ch[i]=='*'||ch[i]=='-'){
                char c=ch[i];
                List<Integer> ret1=diffWaysToCompute(expression.substring(0,i));
                List<Integer> ret2=diffWaysToCompute(expression.substring(i+1,ch.length));
                for(int num1:ret1){
                    for(int num2:ret2){
                        if(c=='+'){
                            ret.add(num1+num2);
                        }else if(c=='*'){
                            ret.add(num1*num2);
                        }else{
                            ret.add(num1-num2);
                        }
                    }
                }
            }
        }
        if(ret.size()==0){
            ret.add(Integer.valueOf(expression));
        }
        map.put(expression,ret);
        return ret;
    }
}