class Program {

    private static Object select(int choice, Object first, Object second) {
        if((choice % 2) == 1)
            return first;
        return second;
    }
    
    public static void main(String[] args) {
        if(args.length > 0){
            int s = Integer.parseInt(args[0]);
            String ss = (String)select(s, "Sunday", "Monday");
            System.out.printf("Selected String value = %s%n", ss);
            //auto-boxing - automatically converting a primitive type(double)
            //value to an object of its wrapper class(Double) so that it can be
            //passed in place of Object
            double sd = (double)select(s, 4.56, 7.65);
            System.out.printf("Selected double value = %s%n", sd);
            //double ssd = (double)select(s, "April", 3.14);
        }
    }
}
