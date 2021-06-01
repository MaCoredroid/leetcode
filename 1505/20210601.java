class Solution {
    public String minInteger(String num, int k) {
        int n=num.length();
        Queue<Integer>[] pos=new Queue[10];
        for(int i=0;i<10;i++){
            pos[i]=new LinkedList<>();
        }
        for(int i=0;i<num.length();i++){
            pos[num.charAt(i)-'0'].offer(i+1);
        }
        StringBuilder sb=new StringBuilder();
        BIT bit=new BIT(n);
        for(int i=1;i<=n;i++){
            for(int j=0;j<10;j++){
                if(!pos[j].isEmpty()){
                    int behind=bit.query(n)-bit.query(pos[j].peek());
                    int dist=pos[j].peek()+behind-i;
                    if(dist<=k){
                        bit.update(pos[j].poll());
                        sb.append(j);
                        k-=dist;
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }
}

class BIT{
    int n;
    int[] Tree;
    public BIT(int n){
        this.n=n;
        this.Tree=new int[n+1];

    }

    public int lowbit(int x){
        return x&(-x);
    }

    public void update(int x){
        while(x<=n){
            ++Tree[x];
            x+=lowbit(x);
        }
    }

    public int query(int x){
        int ans=0;
        while(x>0){
            ans+=Tree[x];
            x-=lowbit(x);
        }
        return ans;
    }
}