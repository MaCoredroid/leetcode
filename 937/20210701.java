class Solution {
    public String[] reorderLogFiles(String[] logs) {
        int n=logs.length;
        String[] ret=new String[n];
        int left=0;
        int right=n-1;
        for(int i=n-1;i>=0;i--){
            if(isLetterLogs(logs[i])){
                ret[left++]=logs[i];
            }else{
                ret[right--]=logs[i];
            }
        }
        sort(ret,0,left-1);
        return ret;
    }
    
    private boolean isLetterLogs(String res){
        char c=res.charAt(res.length()-1);
        return !(c>='0'&&c<='9');
    }
    
    private void sort(String[] logs, int left,int right){
        if(left>=right){
            return;
        }
        int l=left;
        int r=right;
        String pivot=logs[l];
        while(l<r){
            while(l<r&&compare(pivot,logs[r])<=0){
                r--;
            }
            logs[l]=logs[r];
            while(l<r&&compare(pivot,logs[l])>=0){
                l++;
            }
            logs[r]=logs[l];
        }
        logs[l]=pivot;
        sort(logs,left,l-1);
        sort(logs,l+1,right);
    }
    
    public int compare(String a, String b){
        String[] arr1=a.split(" ");
        String[] arr2=b.split(" ");
        for(int i=1;i<Math.min(arr1.length,arr2.length);i++){
            if(arr1[i].compareTo(arr2[i])!=0){
                return arr1[i].compareTo(arr2[i]);
            }
        }
        if(arr1.length==arr2.length){
            return arr1[0].compareTo(arr2[0]);
        }
        return arr1.length-arr2.length;
    }
}