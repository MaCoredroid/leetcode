class Solution {
    public int movesToChessboard(int[][] board) {
        int N = board.length;
        Map<Integer, Integer> count = new HashMap();
        for (int[] row: board) { 
            int code = 0;
            for (int x: row){
                code = 2 * code + x; 
            }  
            count.put(code, count.getOrDefault(code, 0) + 1);
        }
        int k1 = analyzeCount(count, N); // 计算行交换次数（其实是使行排列正确，需要交换列）
        if (k1 == -1) return -1; //  行不正确直接返回

        // 检查列属性（和行一样）
        count = new HashMap();
        for (int c = 0; c < N; ++c) {
            int code = 0;
            for (int r = 0; r < N; ++r)
                code = 2 * code + board[r][c];
            count.put(code, count.getOrDefault(code, 0) + 1);
        }

        int k2 = analyzeCount(count, N); // 计算列交换次数
        return k2 >= 0 ? k1 + k2 : -1;  // 走到这里说明行正确，若列不正确返回-1，否则返回二者和

    }

    private int analyzeCount(Map<Integer, Integer> count,int N){
        if (count.size() != 2) return -1;
        List<Integer> keys = new ArrayList(count.keySet());
        int k1 = keys.get(0), k2 = keys.get(1); // k1，k2就是上面的code二进制数

        if (!(count.get(k1) == N/2 && count.get(k2) == (N+1)/2) &&
                !(count.get(k2) == N/2 && count.get(k1) == (N+1)/2))
            return -1;

        if ((k1 ^ k2) != (1<<N) - 1)
            return -1;

        int Nones = (1 << N) - 1;// N位1：00..0011..111，后面& Nones是为了截断前面多余的位数，
        int ones = Integer.bitCount(k1 & Nones); // bitCount统计状态1的二进制中1的个数
        int cand = Integer.MAX_VALUE;

        if (N%2 == 0 || ones * 2 < N) // 0xAAAAAAAA：10101010101010101010101010101010
            // 找到与正确的1010...相差的位数，则需要交换的次数是一半（/2）
            cand = Math.min(cand, Integer.bitCount(k1 ^ 0xAAAAAAAA & Nones) / 2);
        // N是偶数，或者奇数且1的个数大于N，那么就是1开头的状态
        if (N%2 == 0 || ones * 2 > N) // 0x55555555：01010101010101010101010101010101
            cand = Math.min(cand, Integer.bitCount(k1 ^ 0x55555555 & Nones) / 2);

        return cand;
    }
}