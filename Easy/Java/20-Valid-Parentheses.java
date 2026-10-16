class Solution {
    /**
    constraints: 
        only parenthesis (,{,[,],},)
        can i expect any other symbols, letters, special character?
        longest string i can expect? 
        shortest? 

    naive: 
        every time we see opening the first closing we see must be of that same type. 

    optimal: 
        stack: if we see an opening parenthesis we push a close parenthesis to the stack 
        ex if we see ( we push a ) 

        if we see a close ) we know that the stack pop() has to also be a closed one otherwise we would be in violation  
        
        if (stack.isEmpty() || curr != stack.pop() {
            return false;
        }     
    */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>(); 

        for(char curr: s.toCharArray()) {
            if (curr == '{' || curr == '(' || curr == '[') {
                if (curr == '[') {
                    stack.push(']');
                }
                if (curr == '{') {
                    stack.push('}');
                }
                if (curr == '(') {
                    stack.push(')');
                }
            } else {
                if (stack.isEmpty() || curr != stack.pop()) {
                    return false; 
                }
            }
        }

        return stack.isEmpty(); 
    }
}