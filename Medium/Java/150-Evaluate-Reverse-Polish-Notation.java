class Solution {

    private Stack<Integer> tokenStack = new Stack<>();

    public int evalRPN(String[] tokens) {
        int value = 0;
        int n = 0;
        int n1 = 0;
        // base cases, no operators, empty, just operators

        for (String token: tokens) {
            if (isOperator(token)) {
                n = tokenStack.pop();
                n1 = tokenStack.pop();
                performOperation(token, n, n1);
            }
             else {
                tokenStack.push(Integer.parseInt(token));
            }
        }
        return tokenStack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") 
        || token.equals("-")
        || token.equals("*")
        || token.equals("/");
    }

    private void performOperation(String token, int n, int n1) {
        if (token.equals("+")) { // + abelian commulative group
                tokenStack.push(n + n1);
            } else
            if (token.equals("-")) { // not commulative left to right 
                tokenStack.push(n1 - n);
            } else 
            if (token.equals("/")) { // not commulative left to right
                tokenStack.push(n1 / n);
            } else 
            if (token.equals("*")) { // * abelian commulative group 
                tokenStack.push(n1 * n);
            }
    }
}