class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int start=Math.max(0,k-nums2.length);
        int end=Math.min(k,nums1.length);
        int[] max=new int[k];
        for(int i=start;i<=end;i++){
            int[] seq1=maxsequence(nums1,i);
            int[] seq2=maxsequence(nums2,k-i);
            int[] merged=merge(seq1,seq2);
            if(compare(merged,0,max,0)>0){
                for(int j=0;j<k;j++){
                    max[j]=merged[j];
                }
            }
        }
        return max;
    }

    private int[] maxsequence(int[] nums,int k){
        int[] ret=new int[k];
        int pointer=-1;
        int remain=nums.length-k;
        for(int num:nums){
            while(pointer>=0&&ret[pointer]<num&&remain>0){
                pointer--;
                remain--;
            }
            if(pointer<k-1){
                ret[++pointer]=num;
            }else{
                remain--;
            }
        }
        return ret;
    }

    private int[] merge(int[] seq1,int[] seq2){
        int[] ret=new int[seq1.length+seq2.length];
        int pointer1=0;
        int pointer2=0;
        for(int i=0;i<ret.length;i++){
            if(compare(seq1,pointer1,seq2,pointer2)>0){
                ret[i]=seq1[pointer1++];
            }else{
                ret[i]=seq2[pointer2++];
            }
        }
        return ret;
    }

    private int compare(int[] seq1,int pointer1,int[] seq2,int pointer2){
        while(pointer1<seq1.length&&pointer2<seq2.length){
            if(seq1[pointer1]==seq2[pointer2]){
                pointer1++;
                pointer2++;
            }else{
                return seq1[pointer1]-seq2[pointer2];
            }
        }
        return (seq1.length-pointer1)-(seq2.length-pointer2);

    }
}