class MinStack {

    private Stack<Integer> minHistory;
    public Stack<Integer> minStack;

    public MinStack() {
        this.minHistory = new Stack<>();
        this.minStack = new Stack<>();
        
    }
    
    public void push(int value) {
        minStack.push(value);
        if (minHistory.empty() || value <= minHistory.peek()) {
            minHistory.push(value);
        }
    }
    
    public void pop() {
        if (minStack.empty()) {
            return;
        }
        if (!minHistory.empty() 
        && minStack.peek().equals(minHistory.peek())) {
            minStack.pop();
            minHistory.pop();
        } else 
        if (!minStack.empty()) {
            minStack.pop();
        }
    }
    
    public int top() {
        return minStack.peek();
    }
    
    public int getMin() {
        return minHistory.peek();
    }
}
