class Program {

    private static void print(String label, Object target) {
        System.out.printf("%s = %s%n", label, target.toString());
    }
    
    public static void main(String[] args) {
        Interval a = new Interval(4, 65);
        Interval b = new Interval(3, 20);
        Interval c = new Interval(5, 5);
        Interval d = b;
        print("Interval a", a);
        print("Interval b", b);
        print("Interval c", c);
        print("Interval d", d);
        System.out.println("---------------------------");
        System.out.printf("a is identical to b: %b%n", a == b);
        System.out.printf("a is identical to c: %b%n", a == c);
        System.out.printf("d is identical to b: %b%n", d == b);
        System.out.println("---------------------------");
        System.out.printf("a is equal to b: %b%n", a.hashCode() == b.hashCode() && a.equals(b));
        System.out.printf("a is equal to c: %b%n", a.hashCode() == c.hashCode() && a.equals(c));
        System.out.printf("d is equal to b: %b%n", d.hashCode() == b.hashCode() && d.equals(b));
    }
}
