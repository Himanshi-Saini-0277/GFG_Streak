class Solution {
    public int findKRotation(int arr[]) {
        // Code here
        int low= 0, high= arr.length -1, mid=0, ans= Integer.MAX_VALUE, ind=-1;
        
        while(low<=high)
        {
            mid= (low+high)/2;
            if(arr[mid]>=arr[low]) 
            {
                if(arr[low]<ans)
                {
                    ans=arr[low];
                    ind=low;
                }
                
                low=mid+1;
                
            }
            else
            {
                if(arr[mid]<ans) 
                {
                    ans=arr[mid];
                    ind=mid;
                }
                
                high=mid-1;
            }
        }
        
        return ind;
    }
}