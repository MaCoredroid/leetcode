class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        List<Node> nodes=new ArrayList<>();
        for(int i=0;i<indices.length;i++){
            nodes.add(new Node(sources[i],targets[i],indices[i]));
        }
        Collections.sort(nodes,(o1,o2)->(o1.indice-o2.indice));
        StringBuilder sb=new StringBuilder();
        sb.append(s);
        for(int i=nodes.size()-1;i>=0;i--){
            int p=nodes.get(i).indice;
            while(p<nodes.get(i).indice+nodes.get(i).source.length()){
                if(sb.charAt(p)!=nodes.get(i).source.charAt(p-nodes.get(i).indice)){
                    break;
                }
                p++;
            }
            if(p==nodes.get(i).indice+nodes.get(i).source.length()){
                sb.delete(nodes.get(i).indice,p);
                sb.insert(nodes.get(i).indice,nodes.get(i).target);
            }
        }
        return sb.toString();
    }
}

class Node{
    String source;
    String target;
    int indice;
    public Node(String source,String target, int indice){
        this.source=source;
        this.target=target;
        this.indice=indice;
    }
}