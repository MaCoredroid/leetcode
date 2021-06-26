class Solution {
    public boolean isRobotBounded(String instructions) {
        int[] diretions= new int[]{0, 1, 0, -1, 0};
        // 坐标位置
        int x = 0;
        int y = 0;
        // 方向默认为0，北向
        int currDirection = 0;

        for (char c : instructions.toCharArray())
        {
            if (c == 'G')
            {
                x += diretions[currDirection];
                y += diretions[currDirection+1];
            }
            else if (c == 'L')
            {
                currDirection = (currDirection +4-1) % 4;
            }
            else
            {
                currDirection = (currDirection + 1) % 4;
            }
        }

        return (x== 0 && y == 0) || (currDirection != 0);
    }
}