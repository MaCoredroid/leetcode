class Solution {
    public String reformatDate(String date) {
        String[] res=date.split(" ");
        StringBuilder sb=new StringBuilder();
        sb.append(res[2]);
        sb.append("-");
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        Map<String, Integer> s2month = new HashMap<String, Integer>();
        for (int i = 1; i <= 12; i++) {
            s2month.put(months[i - 1], i);
        }
        int month=s2month.get(res[1]);
        if(month<10){
            sb.append('0');
        }
        sb.append(month);
        sb.append('-');
        int day=Integer.parseInt(res[0].substring(0,res[0].length()-2));
        if(day<10){
            sb.append('0');
        }
        sb.append(day);
        return sb.toString();
    }
}