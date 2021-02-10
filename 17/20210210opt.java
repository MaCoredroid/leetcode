class Solution {
    String[] res =new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> collections=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return collections;
        }
        backTrack(new StringBuilder(),digits,0);
        return collections;
    }

    public void backTrack(StringBuilder collection, String digits, int index){
        if(index==digits.length()){
            collections.add(collection.toString());
            return;
        }
        String current=res[digits.charAt(index)-'0'];
        for(int i=0;i<current.length();i++){
            collection.append(current.charAt(i));
            backTrack(collection,digits,index+1);
            collection.deleteCharAt(index);
        }
    }
}