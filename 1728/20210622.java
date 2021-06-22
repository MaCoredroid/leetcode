class Solution {
    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        int row = grid.length;
        int col = grid[0].length();
        //单元格从0编号，编号到n-1
        int n = row * col;
        int[] state = new int[row * col];

        int cat = 0;
        int mouse = 0;
        int target = 0;
        int cur = 0;
        //收集C M F的位置，以及标记某个单元格是否是墙壁
        for (int i = 0; i < row; i++) {
            for (char chars : grid[i].toCharArray()) {
                if (chars == 'C') {
                    cat = cur;
                }
                if (chars == 'M') {
                    mouse = cur;
                }
                if (chars == 'F') {
                    target = cur;
                }

                if (chars == '#') {
                    state[cur++] = 1;
                } else {
                    state[cur++] = 0;
                }
            }
        }

        //color[mouse][cat][turn] = result
        //i 老鼠 j 猫
        //turn: 0 老鼠行动轮  1 猫行动轮
        //result: 0 未知， 1 老鼠win， 2 猫win, -1不合法
        int[][][] color = new int[n][n][2]; 

        //初始化，抓到老鼠都是猫赢 2 catWin
        for (int i = 0; i < n; i++) {
            color[i][i][0] = 2;
            color[i][i][1] = 2;
        }

        //初始化， 到达目的地，谁到谁赢 result: 1-mouseWin, 2-catWin
        for (int i = 0; i < n; i++) {
            color[target][i][1] = 1;
            color[i][target][0] = 2;
        }

        //初始化，不合法的状态，都到达终端
        color[target][target][0] = -1;
        color[target][target][1] = -1;

        ArrayDeque<int[]> queue = new ArrayDeque<>();

        //收集所有的确定为1-mouseWin，2-catWin的状态
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (state[i] == 1 || state[j] == 1) {
                    continue;
                }
                if (color[i][j][0] == 1) {
                    queue.offerLast(new int[]{i, j, 0});
                }
                if (color[i][j][1] == 1) {
                    queue.offerLast(new int[]{i, j, 1});
                }
                if (color[i][j][0] == 2) {
                    queue.offerLast(new int[]{i, j, 0});
                }
                if (color[i][j][1] == 2) {
                    queue.offerLast(new int[]{i, j, 1});
                }
            }
        }
        int[][][] possible = new int[n][n][2];
        int[][] mouseJumps = new int[n][];
        int[][] catJumps = new int[n][];
        for (int i = 0; i < n; i++) {
            mouseJumps[i] = getJumpPos(row, col, i, mouseJump, grid);
            catJumps[i] = getJumpPos(row, col, i, catJump, grid);
        }
        for (int i = 0; i < n; i++) {
            int mousePossible = mouseJumps[i].length;
            int catPossible = catJumps[i].length;
            for (int j = 0; j < n; j++) {
                possible[i][j][0] = mousePossible;
                possible[j][i][1] = catPossible;
            }
        }

        int step = 0;
        while (step < 1000 && !queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] popStatus = queue.removeFirst();
                int a = popStatus[0];
                int b = popStatus[1];
                int c = popStatus[2];
                if (color[a][b][c] == 1) { //result = 1 ---- mouse win
                    if (c == 1) { //当前轮是猫轮，那么上一轮是老鼠轮，老鼠轮一定往必胜的方案跳【ref1】
                        int[] mousePoses = mouseJumps[a];
                        for (int prePos : mousePoses) {
                            if (color[prePos][b][0] == 0) {
                                color[prePos][b][0] = 1;
                                queue.offerLast(new int[]{prePos, b, 0});
                            }
                        }
                    } else { 
                        //当前轮是老鼠轮，那么上一轮是猫轮，所有可以转移到此状态的猫轮不输的出路减一【ref2】
                        for (int preCatPos : catJumps[b]) {
                            if (color[a][preCatPos][1] == 0) {
                                possible[a][preCatPos][1]--;
                                //当前轮是老鼠轮，那么上一轮是猫轮，所有可以转移到此状态的猫轮不输的出路减一
                                //当减一后没有其他出路，则这个状态虽然是猫轮选择，但所有的选择都是猫输
                                //节点状态置为老鼠赢 1 --- mouseWin
                                if (possible[a][preCatPos][1] == 0) {
                                    color[a][preCatPos][1] = 1;
                                    queue.offerLast(new int[] {a, preCatPos, 1});
                                }
                            }
                        }
                    }
                } else {
                    if (c == 0) { //当前轮是老鼠轮，上一轮是猫轮，思路同 【ref1】
                        int[] preCatPoses = catJumps[b];
                        for (int preCatPos : preCatPoses) {
                            if (color[a][preCatPos][1] == 0) {
                                color[a][preCatPos][1] = 2;
                                queue.offerLast(new int[]{a, preCatPos, 1});
                            }
                        }
                    } else {
                        //思路同【ref2】
                        int[] preMousePoses = mouseJumps[a];
                        for (int preMousePos : preMousePoses) {
                            if (color[preMousePos][b][0] == 0) {
                                possible[preMousePos][b][0]--;
                                if (possible[preMousePos][b][0] == 0) {
                                    color[preMousePos][b][0] = 2;
                                    queue.offerLast(new int[]{preMousePos, b, 0});
                                }
                            }
                        }
                    }
                } //result = 2 ------ cat win 2

            }
            if (color[mouse][cat][0] != 0) {
                break;
            }

            step += 1;
        }
        return color[mouse][cat][0]==1;

    }

    private int[] getJumpPos(int row, int col, int a, int jump, String[] grid) {
        int i = a / col;
        int j = a % col;
        int li = i;
        while (li > i - jump && li > 0) {
            if (grid[li-1].charAt(j) == '#') {
                break;
            }
            li--;
        }

        int ri = i;
        while (ri < i + jump && ri < row - 1) {
            if (grid[ri + 1].charAt(j) == '#') {
                break;
            }
            ri++;
        }


        int tj = j;
        while (tj > j - jump && tj > 0) {
            if (grid[i].charAt(tj - 1) == '#') {
                break;
            }
            tj--;
        }
        int bj = j;
        while (bj < j + jump && bj < col - 1) {
            if (grid[i].charAt(bj + 1) == '#') {
                break;
            }
            bj++;
        }

        int[] ans = new int[ri - li + 1 + bj - tj];
        int cur = 0;
        for (int x = li; x <= ri; x++) {
            ans[cur++] = x * col + j;
        }
        for (int y = tj; y <= bj; y++) {
            if (y == j) {
                continue;
            }
            ans[cur++] = i * col + y;
        }
        return ans;
    }
}