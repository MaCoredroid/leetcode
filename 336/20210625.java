class Solution {
    Node root=new Node();
    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        for (int i = 0; i < n; i++) {
            insert(words[i], i);
        }
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            int m = words[i].length();
            for (int j = 0; j <= m; j++) {
                if(isPalindrome(words[i], j, m - 1)){
                    int leftId = findWord(words[i], 0, j - 1);
                    if (leftId != -1 && leftId != i) {
                        ret.add(Arrays.asList(i, leftId));
                    }
                }
                if(j!=0&&isPalindrome(words[i],0,j-1)){
                    int rightId = findWord(words[i], j, m - 1);
                    if (rightId != -1 && rightId != i) {
                        ret.add(Arrays.asList(rightId, i));
                    }
                }
            }
        }
        return ret;
    }

    public void insert(String s,int id){
        int len=s.length();
        Node node=root;
        for(int i=0;i<len;i++){
            int x=s.charAt(i)-'a';
            if(node.ch[x]==null){
                node.ch[x]=new Node();
            }
            node=node.ch[x];
        }
        node.flag=id;
    }

    public boolean isPalindrome(String s, int left, int right) {
        int len = right - left + 1;
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(left + i) != s.charAt(right - i)) {
                return false;
            }
        }
        return true;
    }

    public int findWord(String s,int left,int right){
        Node node=root;
        for(int i=right;i>=left;i--){
            int x=s.charAt(i)-'a';
            if(node.ch[x]==null){
                return -1;
            }
            node=node.ch[x];
        }
        return node.flag;
    }
}

class Node {
    Node[] ch = new Node[26];
    int flag;

    public Node() {
        flag = -1;
    }
}
