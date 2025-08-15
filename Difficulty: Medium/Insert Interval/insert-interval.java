class Solution {
    public ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        // code here
        ArrayList<int []> ll =new ArrayList<>();
        boolean flag=true;
        for(int [] item:intervals) 
        {
            if(newInterval[0]<item[0] && flag==true)
            {
                ll.add(newInterval);
                flag=false;
            }
            ll.add(item);
        }
        if(ll.size()==intervals.length) ll.add(newInterval);
        ArrayList<int[]> ans=new ArrayList<>();
        int minEnd=Integer.MIN_VALUE;
        for(int [] item:ll)
        {
            if(item[0]>minEnd)
            {
                ans.add(item);
                minEnd=item[1];
            }
            else{
                int [] arr=ans.get(ans.size()-1);
                arr[1]=Math.max(item[1],arr[1]);
                minEnd=Math.max(minEnd,item[1]);
            }
        }
        
        return ans;
    }
}
