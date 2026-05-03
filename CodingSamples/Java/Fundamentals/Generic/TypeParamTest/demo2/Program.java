class Program {

    //using wild-card substitution: SimpleStack<?> === SimpleStack<? extends Object>
    private void printStack(SimpleStack<?> store) {
        while(!store.empty())
            System.out.println(store.pop());
    }

    //non-static main - requires Java 25
    public void main(String[] args) {
        SimpleStack<String> a = new SimpleStack<String>();
        a.push("Monday");
        a.push("Tuesday");
        a.push("Wednesday");
        a.push("Thursday");
        a.push("Friday");
        //a.push(9.8);
        printStack(a);
        System.out.println("-----------------------");
        SimpleStack<Interval> b = new SimpleStack<>(); //type inference
        b.push(new Interval(4, 31));
        b.push(new Interval(6, 12));
        b.push(new Interval(7, 23));
        b.push(new Interval(5, 44));
        printStack(b);
    }
}
