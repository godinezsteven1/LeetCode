class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();

        for(char curr: s.toCharArray()) {
            if (curr == '(' || curr == '{' || curr == '[') {
                if (curr == '(') {
                    stack.push(')');
                } else 
                if (curr == '{') {
                    stack.push('}');
                } else
                if (curr == '[') {
                    stack.push(']');
                }
            } else {
                if (stack.isEmpty() || stack.pop() != curr) {
                    return false;
                }
            }
            
        }
        return stack.isEmpty();
    }
}