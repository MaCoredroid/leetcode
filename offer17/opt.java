class Solution {
    public int[] printNumbers(int n) {
        //因为n为正整数，所以最小为10，也可以把10改为9，100改为99等
		int[] map = { 10, 100, 1000, 10_000, 100_000, 1_000_000, 10_000_000,
 				100_000_000, 1_000_000_000, Integer.MAX_VALUE };
		int size = map[n-1];
		int[] ans = new int[size - 1];
		for (int i = 1; i < size; i++) {
			ans[i - 1] = i;
		}
		return ans;

    }
}