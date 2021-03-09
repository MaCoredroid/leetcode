class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>ret= new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        Set<Integer> cols = new HashSet<>();
        for(int i=0;i<n;i++){
            cols.add(i);
        }
        backTrack(ret,res,cols,new HashSet<>(),new HashSet<>());
        return ret;
    }

    private void backTrack(List<List<String>>ret, List<Integer> res,Set<Integer> cols,Set<Integer> diagonals1, Set<Integer> diagonals2){
        if(cols.size()==0){
            List<String> ans=new ArrayList<>();
            for(int i=0;i<res.size();i++){
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<res.size();j++){
                    if(j==res.get(i)){
                        sb.append('Q');
                    }else{
                        sb.append('.');
                    }
                }
                ans.add(sb.toString());
            }
            ret.add(ans);
            return;
        }
        for(Integer a:cols){
            if(!diagonals1.contains(res.size()-a)&&!diagonals2.contains(res.size()+a)){
                diagonals1.add(res.size()-a);
                diagonals2.add(res.size()+a);
                res.add(a);
                Set<Integer> newcols=new HashSet<>(cols);
                newcols.remove(a);
                backTrack(ret,res,newcols,diagonals1,diagonals2);
                res.remove(res.size()-1);
                diagonals1.remove(res.size()-a);
                diagonals2.remove(res.size()+a);
            }
        }
    }
}