package banking;

//a class defined with 'final' keyword cannot be used as a super-class
final class CurrentAccount extends Account {

    public void withdraw(double amount) throws InsufficientFundsException {
        balance -= amount;
    }

    public void deposit(double amount) {
        if(balance < 0)
            amount -= 500; // charging fine
        balance += amount;
    }
}
