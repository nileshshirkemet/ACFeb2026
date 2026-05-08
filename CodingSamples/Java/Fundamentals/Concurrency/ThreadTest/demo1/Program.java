class Program {

    static void handleJob(int jobId) {
        Thread handler = Thread.currentThread();
        System.out.printf("Thread<%d> has has accepted job<%d> for %s%n", handler.threadId(), jobId, Activity.client());
        Activity.perform(jobId);
        System.out.printf("Thread<%d> has has finished job<%d> for %s%n", handler.threadId(), jobId, Activity.client());
    }

    public static void main(String[] args) throws Exception {
        int n = args.length > 0 ? Integer.parseInt(args[0]) : 1;
        Thread child = new Thread(() -> {
            Activity.client("Jack");
            handleJob(n);
        });
        if(n > 10)
            child.setDaemon(true); //JVM does not wait for a daemon thread to exit
        child.start();
        Activity.client("Jill");
        handleJob(2);
    }
}
