class SimpleStack<E> {
    
    //inner member class
    class Node {

        E value;
        Node below;
    }

    private Node top;

    public void push(E item) {
        var node = new Node();
        node.value = item;
        node.below = top;
        top = node;
    }

    public E pop() {
        E item = top.value;
        top = top.below;
        return item;
    }

    public boolean empty() {
        return top == null;
    }
}
