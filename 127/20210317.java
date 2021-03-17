class Solution {
    Map<String, Integer> wordId = new HashMap<String, Integer>();
    List<List<Integer>> edge = new ArrayList<List<Integer>>();
    int nodeNum = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for(String word:wordList){
            addEdge(word);
        }
        addEdge(beginWord);
        if(!wordId.containsKey(endWord)){
            return 0;
        }
        int[] toBegin=new int[nodeNum];
        int[] toEnd=new int [nodeNum];
        Arrays.fill(toBegin,Integer.MAX_VALUE);
        Arrays.fill(toEnd,Integer.MAX_VALUE);
        Queue<Integer> front=new LinkedList<>();
        front.offer(wordId.get(beginWord));
        toBegin[wordId.get(beginWord)]=0;
        Queue<Integer> end=new LinkedList<>();
        end.offer(wordId.get(endWord));
        toEnd[wordId.get(endWord)]=0;
        while(!front.isEmpty()&&!end.isEmpty()){
            int size=front.size();
            for(int i=0;i<size;i++){
                int node = front.poll();
                if(toEnd[node]!=Integer.MAX_VALUE){
                    return (toBegin[node]+toEnd[node])/2+1;
                }
                for(int edges:edge.get(node)){
                    if(toBegin[edges]==Integer.MAX_VALUE){
                        toBegin[edges]=toBegin[node]+1;
                        front.offer(edges);
                    }
                }
            }

            size=end.size();
            for(int i=0;i<size;i++){
                int node=end.poll();
                if(toBegin[node]!=Integer.MAX_VALUE){
                    return (toBegin[node]+toEnd[node])/2+1;
                }
                for(int edges:edge.get(node)){
                    if(toEnd[edges]==Integer.MAX_VALUE){
                        toEnd[edges]=toEnd[node]+1;
                        end.offer(edges);
                    }
                }
            }
        }
        return 0;

    }

    private void addEdge(String word){
        addWord(word);
        char[] ch=word.toCharArray();
        int id1=wordId.get(word);
        for(int i=0;i<word.length();i++){
            char temp = ch[i];
            ch[i] = '*';
            String newWord= new String(ch);
            addWord(newWord);
            int id2=wordId.get(newWord);
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            ch[i]=temp;
        }
    }
    private void addWord(String word){
        if(!wordId.containsKey(word)){
            wordId.put(word,nodeNum);
            nodeNum++;
            edge.add(new ArrayList<>());
        }
    }
}