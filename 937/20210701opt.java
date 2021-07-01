class Solution {
    public String[] reorderLogFiles(String[] logs) {
        int n=logs.length;
        int index=n-1;
        for(int i=n-1;i>=0;i--){
            if(!isLetterLogs(logs[i])){
                String temp=logs[index];
                logs[index]=logs[i];
                logs[i]=temp;
                index--;
            }
        }
        Arrays.sort(logs,0,index+1,new StringComparator());
        return logs;
    }
    
    private boolean isLetterLogs(String res){
        char c=res.charAt(res.length()-1);
        return !(c>='0'&&c<='9');
    }
    
    private class StringComparator implements Comparator<String>{
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
}