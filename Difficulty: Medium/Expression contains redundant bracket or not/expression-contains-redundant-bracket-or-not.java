class Solution {
    public static boolean checkRedundancy(String s) {
        // code here
        Stack<Character>stack= new Stack<>();
        
        int i=0;
        int n=s.length();
        while(i<n)
        {
            if(s.charAt(i)==')')
            {
                boolean operatorFound=false;
                if(!stack.isEmpty()&&stack.peek()=='(')
                return true;
                while(!stack.isEmpty()&&stack.peek()!='(')
                {
                    if(isOperator(stack.pop()))
                    operatorFound=true;
                }
                
                if(!operatorFound)
                return true;
                
                stack.pop();
            }
            else{
                stack.add(s.charAt(i));
            }
            i++;
        }
        
        if(stack.isEmpty()||containsValidCharacters(stack))
        return false;
        
        return true;
    }
    public static boolean isOperator(Character c)
    {
        if(c=='+'||c=='-'||c=='*'||c=='/')
        return true;
        
        return false;
    }
    public static  boolean containsValidCharacters(Stack<Character>stack)
    {
        for(Character c:stack)
        {
            if(c=='(')
            return false;
            
        }
        return true;
    }
}
