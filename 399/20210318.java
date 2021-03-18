class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int count=0;
        HashMap<String,Integer> map=new HashMap<>();
        UnionFind uf=new UnionFind(2*equations.size());
        for(int i=0;i<equations.size();i++){
            if(!map.containsKey(equations.get(i).get(0))){
                map.put(equations.get(i).get(0),count++);
            }
            if(!map.containsKey(equations.get(i).get(1))){
                map.put(equations.get(i).get(1),count++);
            }
            uf.Union(map.get(equations.get(i).get(0)),map.get(equations.get(i).get(1)),values[i]);
        }
        double[] ret=new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            Integer val1=map.get(queries.get(i).get(0));
            Integer val2=map.get(queries.get(i).get(1));
            if(val1==null||val2==null){
                ret[i]=-1.0d;
            }else{
                ret[i]=uf.isConnected(val1,val2);
            }
        }
        return ret;
    }

    private class UnionFind{
        private int[] parent;
        private double[] weight;

        public UnionFind(int n){
            parent=new int[n];
            weight=new double[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
                weight[i]=1.0d;
            }
        }

        public void Union(int val1,int val2,double value){
            int root1=find(val1);
            int root2=find(val2);
            if(root1!=root2){
                weight[root1]=(weight[val2]*value)/weight[val1];
                parent[root1]=root2;
            }
        }

        public int find(int x){
            if(x!=parent[x]){
                int origin = parent[x];
                parent[x]=find(parent[x]);
                weight[x]*=weight[origin];
            }
            return parent[x];
        }

        public double isConnected(int val1,int val2){
            int root1=find(val1);
            int root2=find(val2);
            if(root1==root2){
                return weight[val1]/weight[val2];
            }else{
                return -1.0d;
            }

        }
    }
}