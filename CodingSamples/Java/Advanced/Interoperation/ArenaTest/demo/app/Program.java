package app;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

import static java.lang.foreign.ValueLayout.*;

public class Program {
    
    static boolean isFavorite(long p) {
        return (p - 1) % 4 == 0;
    }

    public static void main(String[] args) throws Throwable {
        long m = Long.parseUnsignedLong(args[0]);
        int n = Integer.parseInt(args[1]);
        SymbolLookup primesLibLookup = SymbolLookup.libraryLookup("native/libprimes.so", Arena.global());
        MethodHandle primesFetchHandle = Linker.nativeLinker().downcallHandle(
            primesLibLookup.findOrThrow("primes_fetch"), 
            FunctionDescriptor.ofVoid(JAVA_LONG, JAVA_INT, ADDRESS, ADDRESS)
        );
        try(Arena arena = Arena.ofConfined()){
            MemorySegment primes = arena.allocate(JAVA_LONG, n);
            if(n < 5){
                primesFetchHandle.invoke(m, n, primes, MemorySegment.NULL);
                System.out.println("All primes");
            }else{
                MethodHandle isFavoriteHandle = MethodHandles.lookup().findStatic(
                    Program.class,
                    "isFavorite",
                    MethodType.methodType(boolean.class, long.class)
                );
                MemorySegment isFavoriteStub = Linker.nativeLinker().upcallStub(
                    isFavoriteHandle,
                    FunctionDescriptor.of(JAVA_BOOLEAN, JAVA_LONG),
                    arena
                );
                primesFetchHandle.invoke(m, n, primes, isFavoriteStub);
                System.out.println("Favorite primes");
            }
            for(int i = 0; i < n; ++i)
                System.out.println(primes.getAtIndex(JAVA_LONG, i));
        }
    }
}

