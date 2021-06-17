class Solution {
      public double minRecSize(int[][] lines) {
        int n = lines.length;
        Arrays.sort(lines, (a, b)-> a[0]!=b[0] ? a[0]-b[0]: a[1]-b[1]);
        
        int p = 0, q = 0;
        double[] point1 = new double[] {Double.MIN_VALUE, Double.MIN_VALUE};
        double[] point2 = new double[] {Double.MAX_VALUE, Double.MAX_VALUE};
        while (q < n && lines[p][0]==lines[q][0]) q++;
        int r = q + 1;
        if (r >= n) return 0;
        while (q<n) {
            while (r < n && lines[q][0]==lines[r][0]) r++;
            point1[0] = Math.max(point1[0], getX(lines, q, q - 1));
            point1[1] = Math.max(point1[1], getY(lines, q, q - 1));
            point2[0] = Math.min(point2[0], getX(lines, p, r - 1));
            point2[1] = Math.min(point2[1], getY(lines, p, r - 1));
            p = q; q = r;
        }
        return (point1[0]-point2[0])*(point1[1]-point2[1]);
    }
    
    private double getX(int[][] lines, int p, int q) {
        return 1.0 * (lines[p][1]-lines[q][1])/(lines[q][0]-lines[p][0]);
    }

    private double getY(int[][] lines, int p, int q) {
        return 1.0 * (lines[q][0]*lines[p][1]-lines[p][0]*lines[q][1])/(lines[q][0]-lines[p][0]);
    }
}
