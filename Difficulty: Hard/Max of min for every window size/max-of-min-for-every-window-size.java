class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        // code here
        int n = arr.length;
        int[] arr2 = new int[n];
        int[] ns = new int[n];
        int[] ps = new int[n];
        
        Stack<Integer> s = new Stack<>();
        for(int i = n-1; i >= 0; i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) s.pop();
            ns[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }
        
        s = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) s.pop();
            ps[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }
        
        for(int i = 0; i < n; i++){
            int idx = ns[i] - ps[i] - 2;
            arr2[idx] = Math.max(arr2[idx],arr[i]);
        }
        
        for(int i = n-2; i >= 0; i--){
            arr2[i] = Math.max(arr2[i],arr2[i+1]);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int k : arr2) list.add(k);
        
        return list;
    }
}