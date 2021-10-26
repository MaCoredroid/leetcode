class Solution {
    public int calculate(String s) {
        Stack<Integer> stack=new Stack<>();
        char prev='+';
        int prevNum=0;
        for(char c:s.toCharArray()){
            if(c>='0'&&c<='9'){
                prevNum=prevNum*10+c-'0';
            }else if(c!=' '){
                dealWithPrev(prev,prevNum,stack);
                prevNum=0;
                prev=c;
            }
        }
        dealWithPrev(prev,prevNum,stack);
        int ans=0;
        for(Integer a:stack){
            ans+=a;
        }
        return ans;
    }
    
    private void dealWithPrev(char prev,int prevNum,Stack<Integer> s){
        if(prev=='-'){
            s.push(-1*(prevNum));
        }else if(prev=='*'){
            s.push(s.pop()*prevNum);
        }else if(prev=='/'){
            s.push(s.pop()/prevNum);
        }else{
            s.push(prevNum);
        }
    }
}