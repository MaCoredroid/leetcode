class StackOfPlates {

    private LinkedList<LinkedList<Integer>> list = new LinkedList<>();

    int maxSize;

    public StackOfPlates(int cap) {
        maxSize = cap;
    }

    public void push(int val) {
        if (maxSize == 0) {
            return;
        }
        if (list.size() == 0) {
            list.push(new LinkedList<>());
        }
        LinkedList<Integer> item = list.peek();
        if (item.size() >= maxSize) {
            LinkedList<Integer> newItem = new LinkedList<>();
            newItem.push(val);
            list.push(newItem);
        } else {
            item.push(val);
        }
    }

    public int pop() {
        if (list.isEmpty()) {
            return -1;
        }
        LinkedList<Integer> item = list.peek();
        Integer pop = item.pop();
        if (item.isEmpty()) {
            list.pop();
        }
        return pop;
    }

    public int popAt(int index) {
        if (list.isEmpty() || index >= list.size()) {
            return -1;
        }
        LinkedList<Integer> item = list.get(list.size() - 1 - index);
        Integer pop = item.pop();
        if (item.isEmpty()) {
            list.remove(list.size() - 1 - index);
        }
        return pop;
    }

}
/**
 * Your StackOfPlates object will be instantiated and called as such:
 * StackOfPlates obj = new StackOfPlates(cap);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAt(index);
 */