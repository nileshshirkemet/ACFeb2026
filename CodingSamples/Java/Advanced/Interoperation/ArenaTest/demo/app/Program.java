package app;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;
import static java.lang.foreign.ValueLayout.*;

public class Program {
    
    public static void main(String[] args) throws Throwable {
        long m = Long.parseUnsignedLong(args[0]);
        int n = Integer.parseInt(args[1]);
        SymbolLookup primesLibLookup = SymbolLookup.libraryLookup("native/libprimes.so", Arena.global());
        MethodHandle primesFetchHandler = Linker.nativeLinker().downcallHandle(
            primesLibLookup.findOrThrow("primes_fetch"), 
            FunctionDescriptor.ofVoid(JAVA_LONG, JAVA_INT, ADDRESS, ADDRESS)
        );
        
    }
}

