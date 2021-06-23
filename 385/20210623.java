/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    char[] res;
    public NestedInteger deserialize(String s) {
        res=s.toCharArray();
        return helper(0,s.length()-1);
    }

    private NestedInteger helper(int start,int end){
        if(res[start]!='['){
            return new NestedInteger(Integer.parseInt(new String(res,start,end-start+1)));
        }
        start++;
        end--;
        NestedInteger ret=new NestedInteger();
        int p=start;
        while(p<=end){
            if(res[p]==','){
                p++;
                continue;
            }else if(res[p]=='['){
                int record=p;
                int cnt=0;
                while(p<=end){
                    if(res[p]=='['){
                        cnt++;
                    }else if(res[p]==']'){
                        cnt--;
                        if(cnt==0){
                            break;
                        }
                    }
                    p++;
                }
                if(record!=p){
                    ret.add(helper(record,p));
                }
            }else{
                int base=1;
                if(res[p]=='-'){
                    base=-1;
                    p++;
                }
                int ans=0;
                while(p<=end&&res[p]>='0'&&res[p]<='9'){
                    ans=ans*10+res[p]-'0';
                    p++;
                }
                ret.add(new NestedInteger(ans*base));
            }
            p++;
        }
        return ret;
    }
}