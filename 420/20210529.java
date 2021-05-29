class Solution {
    public int strongPasswordChecker(String password) {
        int[] cnt=new int[3];
        char[] ch=password.toCharArray();
        if(ch.length==0){
            return 6;
        }
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> a % 3 - b % 3);
        int[] temp=new int[]{0,0,0};
        for(int i=0;i<ch.length;i++){
            if(ch[i]>='a'&&ch[i]<='z'){
                cnt[0]++;
            }else if(ch[i]>='A'&&ch[i]<='Z'){
                cnt[1]++;
            }else if(ch[i]>='0'&&ch[i]<='9'){
                cnt[2]++;
            }
            if(temp[2]!=(int)ch[i]){
                if(temp[1]-temp[0]>=2){
                    queue.offer(temp[1]-temp[0]+1);
                }
                temp[2]=(int)ch[i];
                temp[0]=i;
                temp[1]=i;
            }else{
                temp[1]=i;
            }
        }
        if(temp[1]-temp[0]>=2){
            queue.offer(temp[1]-temp[0]+1);
        }
        int needType=0;
        for(int i=0;i<3;i++){
            if(cnt[i]==0){
                needType++;
            }
        }
        if(ch.length<6){
            return Math.max(6-ch.length,needType);
        }
        int len=ch.length;
        int ans=0;
        while (!queue.isEmpty() && len > 20) {
            int cur = queue.remove();
            ans ++;
            len --;
            if (-- cur >= 3) queue.add(cur);
        }
        if (len > 20) return ans + len - 20 + needType;
        int n = 0;
        while (!queue.isEmpty()) {
            n += queue.remove() / 3;
        }
        return ans+Math.max(n,needType);



    }

    
}