/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map=new HashMap<>();
        for(Employee e:employees){
            map.put(e.id,e);
        }
        return helper(id,map);
        
    }
    
    public int helper(int id,HashMap<Integer,Employee> map){
        int ans=map.get(id).importance;
        for(int next:map.get(id).subordinates){
            ans+=helper(next,map);
        }
        return ans;
    }
}