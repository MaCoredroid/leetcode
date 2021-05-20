class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans=new ArrayList<>();
        while(k>0){
            ans.add(0,k%10);
            k/=10;
        }
        List<Integer> ret=new ArrayList<>();
        int overflow=0;
        int pointer1=num.length-1,pointer2=ans.size()-1;
        while(pointer1>=0||pointer2>=0||overflow!=0){
            int num1=pointer1>=0?num[pointer1--]:0;
            int num2=pointer2>=0?ans.get(pointer2--):0;
            int temp=num1+num2+overflow;
            if(temp>=10){
                temp-=10;
                overflow=1;
            }else{
                overflow=0;
            }
            ret.add(0,temp);

        }
        return ret;
    }
}