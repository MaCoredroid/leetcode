class Solution {
    int[] parent;
    int count=0;
    public int numSimilarGroups(String[] strs) {
        int n=strs.length;
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        count=n;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(find(i)!=find(j)&&check(i,j,strs)){
                    union(i,j);
                }
            }
        }
        return count;

    }

    public int find(int index){
        if(index!=parent[index]){
            parent[index]=find(parent[index]);
        }
        return parent[index];
    }

    public void union(int index1,int index2){
        int rootA=find(index1);
        int rootB=find(index2);
        if(rootA!=rootB){
            count--;
            parent[rootA]=rootB;
        }
    }

    public boolean check(int index1,int index2, String[] strs){
        String a=strs[index1];
        String b=strs[index2];
        int cnt=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                cnt++;
                if(cnt>2){
                    return false;
                }
            }
        }
        return true;
    }
}