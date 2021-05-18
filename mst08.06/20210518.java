class Solution {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(),A,B,C);
    }
    public void move(int n,List<Integer> A, List<Integer> B, List<Integer> C){
        if(n==1){
            C.add(A.get(A.size()-1));
            A.remove(A.size()-1);
            return;
        }
        move(n-1,A,C,B);
        C.add(A.get(A.size()-1));
        A.remove(A.size()-1);
        move(n-1,B,A,C);
    }
}