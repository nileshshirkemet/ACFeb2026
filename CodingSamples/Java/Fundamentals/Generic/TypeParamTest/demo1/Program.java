class Program {

    //generic method with type-parameter T which refers to Object type
    private static <T> T select(int choice, T first, T second) {
        if((choice % 2) == 1)
            return first;
        return second;
    }

    //generic method with type-parameter T defined with Comparable<T>
    //as its upper-bound
    private static <T extends Comparable<T>> T select(T first, T second) {
        if(first.compareTo(second) > 0)
            return first;
        return second;
    }
    
    public static void main(String[] args) {
        if(args.length > 0){
            int s = Integer.parseInt(args[0]);
            String ss = select(s, "Sunday", "Monday");
            System.out.printf("Selected String value = %s%n", ss);
            double sd = select(s, 4.56, 7.65);
            System.out.printf("Selected double value = %s%n", sd);
            //double ssd = select(s, "April", 3.14);
        }else{
            String ss = select("Sunday", "Monday");
            System.out.printf("Selected String value = %s%n", ss);
            double sd = select(4.56, 7.65);
            System.out.printf("Selected double value = %s%n", sd);
            Interval si = select(new Interval(4, 30), new Interval(3, 45));
            System.out.printf("Selected Interval value = %s%n", si);
        }
    }
}
