class Solution {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0;
        }
        List<Integer> time = new ArrayList<>();
        for (String timePoint : timePoints) {
            String[] split = timePoint.split(":");
            time.add(Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]));
        }
        Collections.sort(time);
        int ret=1440;
        for(int i=0;i<time.size()-1;i++){
            ret=Math.min(ret,time.get(i+1)-time.get(i));
        }
        ret=Math.min(ret,1440+time.get(0)-time.get(time.size()-1));
        return ret;
    }
}