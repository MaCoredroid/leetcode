class Solution {
    public int[] threeEqualParts(int[] arr) {
        int[] IMP=new int[]{-1,-1};
        int N=arr.length;
        int cnt=0;
        for(int val:arr){
            cnt+=val;
        }
        if(cnt%3!=0){
            return new int[]{-1,-1};
        }
        int T=cnt/3;
        if(T==0){
            return new int[]{0,N-1};
        }
        int i1 = -1, j1 = -1, i2 = -1, j2 = -1, i3 = -1, j3 = -1;
        int su = 0;
        for (int i = 0; i < N; ++i) {
            if (arr[i] == 1) {
                su += 1;
                if (su == 1) i1 = i;
                if (su == T) j1 = i;
                if (su == T+1) i2 = i;
                if (su == 2*T) j2 = i;
                if (su == 2*T + 1) i3 = i;
                if (su == 3*T) j3 = i;
            }
        }
        int[] part1 = Arrays.copyOfRange(arr, i1, j1+1);
        int[] part2 = Arrays.copyOfRange(arr, i2, j2+1);
        int[] part3 = Arrays.copyOfRange(arr, i3, j3+1);

        if (!Arrays.equals(part1, part2)) return IMP;
        if (!Arrays.equals(part1, part3)) return IMP;
        int cnt1=i2-j1-1;
        int cnt2=i3-j2-1;
        int cnt3=N-j3-1;
        if(cnt1<cnt3||cnt2<cnt3){
            return IMP;
        }
        return new int[]{j1+cnt3,j2+cnt3+1};
    }
}