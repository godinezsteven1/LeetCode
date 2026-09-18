class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    /**
    
    
    |   |        |  1 |
    | 5  |       | 2  |
    |_4__|.      |_3__|
    stack1      stack2
    
            LILO

    |back  5 4 3   2  1  front|. FIFO
     */

    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }
    

    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        if (stack2.isEmpty()) {
            shiftStacks();
        }
        return stack2.pop();
        
    }
    
    public int peek() {
        if (stack2.isEmpty()) {
            shiftStacks();
        }
        return stack2.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private void shiftStacks() {
        while (!stack1.isEmpty()) {
            int temp = stack1.pop();
            stack2.push(temp);
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */