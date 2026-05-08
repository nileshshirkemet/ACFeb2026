import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

class Computation {
    
    private long start = 0;

    private static long calculate(int count) {
        try{
            Thread.sleep(100 * count);
        }catch(InterruptedException e){}
        return count * count;
    }

    public long compute(int first, int last){
        start = System.nanoTime();
        return IntStream.range(first, last + 1)
            .parallel() //split the stream into sub-streams which can be executed on different cores
            .mapToLong(Computation::calculate)
            .sum();
    }

    public CompletableFuture<Long> computeAsync(int first, int last) {
        //the evaluation of supplied expression is delegated to a 
        //worker thread (from fork-join pool) allowing the caller thread
        //to continue and obtain the result of evaluation at any time
        //in future when the evaluation is completed
        return CompletableFuture.supplyAsync(() -> compute(first, last));
    }

    public double time() {
        long stop = System.nanoTime();
        return (stop - start) / 1e9;
    }

}
