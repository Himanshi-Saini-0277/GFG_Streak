class Solution {
    public ArrayList<Integer> leafNodes(int[] preorder) {
        // code here
        Stack<Integer>stk = new Stack<>();
        int n = preorder.length;
        ArrayList<Integer>res = new ArrayList<>();
        for(int i =0;i<n;++i)
        {
            if(stk.isEmpty())stk.push(preorder[i]);
            else
            {
                if(stk.peek()<preorder[i])
                {
                    int storage = stk.peek();
                    int counter = 0;
                    while(!stk.isEmpty()&&stk.peek()<preorder[i])
                    {
                        counter++;
                        stk.pop();
                    }
                    if(counter>=2)
                    {
                        res.add(storage);
                    }
                }
                stk.push(preorder[i]);
            }
        }
        if(!stk.isEmpty())res.add(stk.peek());
        return res;
    }
}