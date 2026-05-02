package app;

import banking.*; //automatically qualify all names from banking package

public class Program {

    //last parameter type declared with varargs modifier(...) is an array which
    //can be initialized with a sequence of arguments of matching type
    private static void payQuarterlyInterest(int quarters, Account... accounts) {
        //for-each loop 
        for(Account acc : accounts){
            if(acc instanceof Profitable p){
                double amount = p.interest(3 * quarters);
                acc.deposit(amount);
            }
        }
    }
    
    public static void main(String[] args) {
        Account jill = Banker.openSavingsAccount();
        jill.deposit(15000);
        Account jack = Banker.openCurrentAccount();
        jack.deposit(30000);
        Account john = Banker.openSavingsAccount();
        john.deposit(35000);
        System.out.printf("Jill's Account ID is %d and Balance is %.2f%n", jill.id(), jill.balance());
        System.out.printf("Jack's Account ID is %d and Balance is %.2f%n", jack.id(), jack.balance());
        System.out.printf("John's Account ID is %d and Balance is %.2f%n", john.id(), john.balance());
        System.out.println("---------------------------------------------");
        if(args.length > 0) {
            try{
                double payment = Double.parseDouble(args[0]);
                System.out.printf("Jill is paying %.2f to Jack...%n", payment);
                jill.transfer(payment, jack);
            }catch(InsufficientFundsException e){
                System.out.println("Payment failed due to lack of funds!");
            }catch(Exception e){
                System.out.printf("ERROR: %s%n", e);
            }
        }else{
            System.out.println("Paying annual interest...");
            //payQuarterlyInterest(4, new Account[]{jill, jack, john});
            payQuarterlyInterest(4, jill, jack, john);
        }
        System.out.println("---------------------------------------------");
        System.out.printf("Jill's closing Balance is %.2f%n", jill.balance());
        System.out.printf("Jack's closing Balance is %.2f%n", jack.balance());
        System.out.printf("John's closing Balance is %.2f%n", john.balance());
    }
}
