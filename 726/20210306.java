class Solution {
    public String countOfAtoms(String formula) {
        Stack<TreeMap<String,Integer>> stack=new Stack<>();
        stack.push(new TreeMap<>());
        int i=0;
        while(i<formula.length()){
            if(formula.charAt(i)>='A'&&formula.charAt(i)<='Z'){
                String res="";
                res+= formula.charAt(i);
                if(i+1<formula.length()&&formula.charAt(i+1)>='a'&&formula.charAt(i+1)<='z'){
                    i++;
                    res+= formula.charAt(i);
                }
                i++;
                int j=i;
                while(i<formula.length()&&formula.charAt(i)>='0'&&formula.charAt(i)<='9'){
                    i++;
                }
                int count=1;
                if(j!=i)
                {
                    count=Integer.parseInt(formula.substring(j,i));
                }
                if(stack.peek().containsKey(res)){
                    stack.peek().put(res,stack.peek().get(res)+count);
                }else{
                    stack.peek().put(res,count);
                }
            }else if(formula.charAt(i)=='('){
                stack.push(new TreeMap<String,Integer>());
                i++;
            }else if(formula.charAt(i)==')'){
                TreeMap<String,Integer> ret=stack.pop();
                i++;
                int j=i;
                while(i<formula.length()&&formula.charAt(i)>='0'&&formula.charAt(i)<='9'){
                    i++;
                }
                int count=1;
                if(j!=i)
                {
                    count=Integer.parseInt(formula.substring(j,i));
                }
                for(Map.Entry<String,Integer> entry : ret.entrySet()){
                    if(stack.peek().containsKey(entry.getKey())){
                        stack.peek().put(entry.getKey(),count*entry.getValue()+stack.peek().get(entry.getKey()));
                    }else{
                        stack.peek().put(entry.getKey(),count*entry.getValue());
                    }
                }

            }
        }
        StringBuilder sb=new StringBuilder();
        TreeMap<String,Integer> ret=stack.pop();
        for(Map.Entry<String,Integer> entry : ret.entrySet()){
            sb.append(entry.getKey());
            if(entry.getValue()!=1){
                sb.append(entry.getValue());
            }
        }
        return sb.toString();
    }
}