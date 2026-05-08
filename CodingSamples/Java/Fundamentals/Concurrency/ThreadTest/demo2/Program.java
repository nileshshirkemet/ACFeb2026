class Program {

    public static void main(String[] args) throws Exception {
        var acc = new JointAccount();
        acc.credit(10000);
        System.out.println("Account opened for Jack and Jill.");
        System.out.printf("Initial Balance: %d%n", acc.balance());
        var first = Thread.ofPlatform().start(() -> {
            System.out.println("Jack is withdrawing 6000...");
            if(acc.debit(6000) == false)
                System.out.println("Jack's transaction failed!");
        });
        var second = Thread.ofPlatform().start(() -> {
            System.out.println("Jill is withdrawing 7000...");
            if(acc.debit(7000) == false)
                System.out.println("Jill's transaction failed!");
        });
        first.join(); //current (main) thread waits for first to exit
        second.join();
        System.out.printf("Final Balance: %d%n", acc.balance());
    }
}
