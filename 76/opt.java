import javafx.util.Pair; 
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) 
        {
          return "";
        }
        HashMap<Character,Integer> dictT=new HashMap<>();
        for(int i=0;i<t.length();i++)
        {
            dictT.put(t.charAt(i),dictT.getOrDefault(t.charAt(i),0)+1);
        }
        int required=dictT.size();
        List<Pair<Integer,Character>> filteredS=new ArrayList<>();
        for(int i=0;i<s.length();i++)
        {
            if(dictT.containsKey(s.charAt(i)))
            {
                filteredS.add(new Pair<Integer,Character>(i,s.charAt(i)));
            }
        }
        int left=0;
        int right=0;
        int formed=0;
        HashMap<Character,Integer> dictW=new HashMap<>();
        int[] ans = {-1, 0, 0};
        while(right<filteredS.size())
        {
            char c=filteredS.get(right).getValue();
            dictW.put(c,dictW.getOrDefault(c,0)+1);
            if(dictT.containsKey(c)&&dictT.get(c).intValue()==dictW.get(c).intValue())
            {
                formed++;
            }
            while(left<=right&&formed==required)
            {
                char d=filteredS.get(left).getValue();
                int start=filteredS.get(left).getKey();
                int end=filteredS.get(right).getKey();
                if(ans[0]==-1||end-start+1<ans[0])
                {
                    ans[0]=end-start+1;
                    ans[1]=start;
                    ans[2]=end;
                }
                dictW.put(d,dictW.get(d)-1);
                if(dictT.containsKey(d)&&dictW.get(d).intValue()<dictT.get(d).intValue())
                {
                    formed--;
                }
                left++;
            }
            right++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);

    }
}