class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder.length==0||postorder.length==1)
        {
            return true;
        }
        return verify(postorder,0,postorder.length-1);
    }
    private boolean verify(int[] postorder,int left,int right)
    {
        if(left>=right)
        {
            return true;
        }
        int root=postorder[right];
        int i=left;
        for(;i<right;i++)
        {
            if(postorder[i]>root)
            {
                break;
            }
        }
        int record=i;
        i++;
        for(;i<right;i++)
        {
            if(postorder[i]<root)
            {
                return false;
            }
        }
        return verify(postorder,left,record-1)&&verify(postorder,record,right-1);
    }
}