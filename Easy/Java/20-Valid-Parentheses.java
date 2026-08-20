class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>(); 

        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '{' || curr == '(' || curr == '[') {
                stack.push(s.charAt(i));
            } else 
            if (stack.isEmpty()) {
                return false;
            } else 
            if (curr == '}' && stack.peek() == '{') {
                stack.pop();
            } else
            if (curr == ')' && stack.peek() == '(') {
                stack.pop();
            } else
            if (curr == ']' && stack.peek() == '[') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}