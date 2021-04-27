/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    List<Integer> ans;
    int pointer=0;
    public NestedIterator(List<NestedInteger> nestedList) {
        ans=new ArrayList<>();
        iniate(ans,nestedList);

    }

    private void iniate(List<Integer> ans,List<NestedInteger> nestedList){
        for(NestedInteger temp:nestedList){
            if(temp.isInteger()){
                ans.add(temp.getInteger());
            }else{
                iniate(ans,temp.getList());
            }
        }
    }
    @Override
    public Integer next() {
        if(pointer<ans.size()){
            pointer++;
            return ans.get(pointer-1);
        }else{
            return -1;
        }
    }

    @Override
    public boolean hasNext() {
        return pointer<ans.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */