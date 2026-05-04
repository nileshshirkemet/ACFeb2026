class Program {

    public static void main(String[] args) {
        var a = new SimpleStack<String>();
        a.push("Monday");
        a.push("Tuesday");
        a.push("Wednesday");
        a.push("Thursday");
        a.push("Friday");
        for(var i = a.iterator(); i.hasNext();)
            System.out.println(i.next());
        System.out.println("------------------------");
        while(!a.empty())
            System.out.println(a.pop());      
        System.out.println("------------------------");
        var b = new SimpleStack<Double>();
        b.push(23.41);
        b.push(64.12);
        b.push(58.23);
        b.push(75.54);
        for(double e : b)
            System.out.println(e);
    }
}
