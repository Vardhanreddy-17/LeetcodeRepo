class MinStack {

    Stack<Long> st;
    long min;

    public MinStack() {
        st = new Stack<>();
        min = Long.MAX_VALUE;
    }

    public void push(int value) {

        long val = value;

        if (st.isEmpty()) {
            st.push(val);
            min = val;
        } 
        else if (val >= min) {
            st.push(val);
        } 
        else {
            st.push(2 * val - min);
            min = val;
        }
    }

    public void pop() {

        if (st.isEmpty()) {
            return;
        }

        long value = st.pop();

        if (value < min) {
            min = 2 * min - value;
        }
    }

    public int top() {

        long value = st.peek();

        if (value < min) {
            return (int) min;
        }

        return (int) value;
    }

    public int getMin() {
        return (int) min;
    }
}