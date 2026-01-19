class Solution {
    public String removeKdig(String s, int k) {
        // code here
        Stack<Character> st = new Stack<>();
        int n=s.length();
        if(k==n)
            return "0";
        for(int x=0; x<n; x++)
        {
            // int y=x;
            char ch= s.charAt(x);
            while(!st.isEmpty() && k>0 && ch<st.peek() )
            {
                st.pop();
                k--;
            }
            
            st.push(ch);
            
        }
        
        while(k>0)
        {
            k--;
            st.pop();
        }
        
        StringBuilder sb= new StringBuilder();
        Collections.reverse(st);
        while(!st.isEmpty() && st.peek()=='0')
            st.pop();
        
        if(!st.isEmpty())
        {
            while(!st.isEmpty())
            {
                char ch=st.pop();
                sb= sb.append(ch);
            }
            return sb.toString();
        }
        
        return "0";
    }
}