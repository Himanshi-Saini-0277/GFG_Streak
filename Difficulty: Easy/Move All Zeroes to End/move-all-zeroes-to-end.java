class Solution {
    void pushZerosToEnd(int[] arr) {
        // code here
        int j=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                j=i;
                break;
            }
        }
        if(j!=-1){
            for(int i=j+1;i<arr.length;i++){
                if(arr[i]!=0){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                    j++;
                }
                else{
                    continue;
                }
            }
        }
    }
}