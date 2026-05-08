class JointAccount {

    private int balance;

    public int balance() {
        return balance;
    }

    public boolean debit(int amount) {
        boolean success = false;
        //a thread can enter a synchronized statement block only
        //after locking the (built-in) monitor associated with
        //the instance refered by 'this' which it unlocks when
        //exits the statement block
        synchronized(this){
            if(balance >= amount){
                balance = calculate(balance, amount, -1);
                success = true;
            }
        }
        return success;
    }

    public synchronized void credit(int amount) {
        balance = calculate(balance, amount, 1);
        //when a thread calls notify method of an object whose
        //monitor it has locked, this monitor is notified 
        this.notify();
    }

    public static int calculate(int bal, int amt, int sgn) {
        try{
            //pause current thread for specified number of milli-seconds
            Thread.sleep(amt / 100);
        }catch(InterruptedException e){}
        return bal + amt * sgn;
    }

    public synchronized boolean debitAfterCredit(int amount) throws InterruptedException {
        //when a thread calls wait() method on an object, the monitor associated
        //with this object is unlocked and the thread is blocked until it can
        //relock the monitor and resume when the monitor is notified by another
        //thread
        this.wait();
        return debit(amount);
    }
}
