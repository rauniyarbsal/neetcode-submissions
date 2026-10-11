class MinStack {

    Deque<Integer> inputStack;
    Deque<Integer> minStack;

    public MinStack() {
        inputStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();

    }
    
    public void push(int val) {
        inputStack.push(val);

        if(minStack.isEmpty() || val <= minStack.peek()) minStack.push(val);
        
    }
    
    public void pop() {
        int poped = inputStack.pop();

        if(poped == minStack.peek()) minStack.pop();
        
    }
    
    public int top() {
        return inputStack.peek();
        
    }
    
    public int getMin() {
        return minStack.peek();
        
    }
}
