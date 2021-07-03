/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        Random ran=new Random();
        ArrayList<String> list=new ArrayList<>();
        for(String word:wordlist){
            list.add(word);
        }
        int cnt=0;
        while(cnt<10){
            int index=ran.nextInt(list.size());
            int matches=master.guess(list.get(index));
            if(matches==6){
                return;
            }
            ArrayList<String> res=new ArrayList<>();
            for(String a:list){
                if(countMatch(a,list.get(index))==matches){
                    res.add(a);
                }
            }
            list=res;
            cnt++;
        }
    }
    
    private int countMatch(String a,String b){
        int cnt=0;
        for(int i=0;i<6;i++){
            if(a.charAt(i)==b.charAt(i)){
                cnt++;
            }
        }
        return cnt;
    }
}