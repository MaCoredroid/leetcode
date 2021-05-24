class Solution {
    public int nextGreaterElement(int n) {
        char[] a = ("" + n).toCharArray();
        int i=a.length-2;
        while(i>=0&&a[i]>=a[i+1]){
            i--;
        }
        if(i==-1){
            return -1;
        }
        int j=a.length-1;
        while(j>0&&a[j]<=a[i]){
            j--;
        }
        swap(a,i,j);
        reverse(a,i+1,a.length-1);
        try {
            return Integer.parseInt(new String(a));
        } catch (Exception e) {
            return -1;
        }
    }

    private void swap(char[] a ,int i,int j){
        char temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    private void reverse(char[] a,int i,int j){
        while(i<j){
            swap(a,i,j);
            i++;
            j--;
        }
    }
}