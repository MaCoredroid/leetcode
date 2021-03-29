class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        List<List<Character>> res=new ArrayList<>();
        char[] ch=s.toCharArray();
        int count=0;
        boolean direction=true;
        for(int i=0;i<ch.length;i++){
            if(res.size()==count){
                res.add(new ArrayList<Character>());
            }
            res.get(count).add(ch[i]);
            if(direction){
                if(count==numRows-1){
                    count--;
                    direction=false;
                }else{
                    count++;
                }
            }else{
                if(count==0){
                    count++;
                    direction=true;
                }else{
                    count--;
                }
            }
        }
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<res.size();i++){
            for(Character c:res.get(i)){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}