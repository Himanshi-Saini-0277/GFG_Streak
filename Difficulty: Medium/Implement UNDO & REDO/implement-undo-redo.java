class Solution {
    Stack<Character> st = new Stack<>();
    StringBuilder sb = new StringBuilder();
    public void append(char x) {
        sb.append(x);
        
    }

    public void undo() {
        st.push(sb.charAt(sb.length()-1));
        sb.deleteCharAt(sb.length()-1);
    }

    public void redo() {
        sb.append(st.pop());
    }

    public String read() {
        return sb.toString();
    }
}