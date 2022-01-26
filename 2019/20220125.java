class Solution {
    public int scoreOfStudents(String s, int[] answers) {
        Stack<Integer> stack=new Stack<>();
        char pre='+';
        int num=0,ans=0;
        for(char c:s.toCharArray()){
            if(c>='0'&&c<='9'){
                num=num*10+c-'0';
            }else{
                if(pre=='+') stack.push(num);
                else stack.push(stack.pop()*num);
                pre=c;
                num=0;
            }
        }
        if(pre=='+') stack.push(num);
        else stack.push(stack.pop()*num);   
        while(!stack.isEmpty()){
            ans+=stack.pop();
        }
        int n=s.length();
        Set<Integer>[][] dp=new Set[n][n];
        for(int i=0;i<n;i+=2){
            dp[i][i]=new HashSet<>();
            dp[i][i].add(s.charAt(i)-'0');
        }
        for(int end=2;end<n;end+=2){
            for(int start=end-2;start>=0;start-=2){
                dp[start][end]=new HashSet<>();
                for(int k=start;k<end;k+=2){
                    for(int left:dp[start][k]){
                        for(int right:dp[k+2][end]){
                            int val=s.charAt(k+1)=='*'?left*right:left+right;
                            if(val<=1000) dp[start][end].add(val);
                        }
                    }
                }
            }
        }
        int ret=0;
        for(int a:answers){
            if(a==ans) ret+=5;
            else if(dp[0][n-1].contains(a)) ret+=2;
        }
        return ret;
    }
}