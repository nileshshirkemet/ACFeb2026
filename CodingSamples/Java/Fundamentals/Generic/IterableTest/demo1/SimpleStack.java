import java.util.Iterator;

//this class supports standard iteration for its object
//required by for-each loop syntax
class SimpleStack<E> implements Iterable<E> {
    
    //inner member class
    class Node {

        E value;
        Node below = top; //refering to instance member of outer class
    }

    private Node top;

    public void push(E item) {
        var node = new Node();
        node.value = item;
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


    public Iterator<E> iterator() {
        //returning a new instance of an inner local anonymous class
        //which implements Iterator<E>
        return new Iterator<E>(){

            private Node current = top;

            public boolean hasNext() {
                return current != null;
            }

            public E next() {
                E item = current.value;
                current = current.below;
                return item;
            }
        };
    }
}
