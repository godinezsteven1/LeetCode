class Solution {
    /**
    constraints: 
        only characters are [,{,(,),},]
        max length? 
        can solution have extra space? 
    
    naive: 
        if _{_ is open then next one has to be _}_ closed 
    
    optimal: 
        stacks 
    
        every time we see an open we add the closed version of it.
        and every time we see a closed version... we pop it . 
        having stack will let us maintain given order, and at the end all we have to do is 
        check if everything has been popped or empty 
    
        Stack<Characters> stack = new Stack<>();
        for(char p: s.toCharArray()) {
            if (p == '{' || p == '(' || p == '[') {
                if (p == '{') {
                    stack.push('}');
                }
                if (p == '(') {
                    stack.push(')');
                }
                if (p == '[') {
                    stack.push(']');
                }
            } else {
            // false if stack return empty too early or if the pop is not our curr
                if (stack.isEmpty() || stack.pop() != p) {
                    return false;
                }
            }
        }
    
        return stack.isEmpty();
    
    
    
    
    
    
    
    
    
    */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char p : s.toCharArray()) {
            if (p == '{' || p == '(' || p == '[') {
                if (p == '{') {
                    stack.push('}');
                }
                if (p == '(') {
                    stack.push(')');
                }
                if (p == '[') {
                    stack.push(']');
                }
            } else {
                if (stack.isEmpty() || stack.pop() != p) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}