class Program {

    public static void main(String[] args) throws Exception {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        System.out.print("Computing...");
        var c = new Computation();
        var job = c.computeAsync(m, n)
            .thenAccept(r -> {
                System.out.println("Done!");
                System.out.printf("Result = %d, computed in %.3f seconds.%n", r, c.time());
            });
        while(!job.isDone()){
            System.out.print(".");
            Thread.sleep(500);
        }
    }
}
