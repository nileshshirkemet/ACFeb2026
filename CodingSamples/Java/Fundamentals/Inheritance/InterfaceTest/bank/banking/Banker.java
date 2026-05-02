package banking;

public class Banker {
    
    private static int count = 0;

    public static Account openCurrentAccount() {
        //implicitly typed local inferred from initializer
        var acc = new CurrentAccount(); //var = CurrentAccount
        acc.id = ++count + 100000000;
        return acc;
    }

    public static Account openSavingsAccount() {
        var acc = new SavingsAccount();
        acc.id = ++count + 200000000;
        return acc;
    }

    //all members are static so there is no need to create new instances
    private Banker() {}
}
