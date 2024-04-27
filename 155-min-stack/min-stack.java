class MinStack {

    private Stack<Integer> elementStack;
    private Stack<Integer> minElementStack;


    public MinStack() {
        elementStack = new Stack<>();
        minElementStack = new Stack<>();
    }

     public void push(int val) {
        elementStack.push(val);
        if (!minElementStack.isEmpty()) {
            int mineElement = minElementStack.peek();
            if (val < mineElement) {
                minElementStack.push(val);
            } else {
                minElementStack.push(mineElement);
            }
        } else {
            minElementStack.push(val);
        }

    }

    public void pop() {
        elementStack.pop();
        minElementStack.pop();
    }

    public int top() {
        return elementStack.peek();
    }

    public int getMin() {
        return minElementStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */