package app;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;

public class Program {
    
    public static void main(String[] args) throws Throwable {
        double p = Double.parseDouble(args[0]);
        int l = Integer.parseInt(args[1]);
        //dynamically links to a library with specified canonical name, 
        //looking for this library in each directory specified in
        //the java.library.path property of JVM
        System.loadLibrary(args[2]);
        //restricted method - can only be called from a module
        //for which native access is enabled
        MethodHandle depr = Linker.nativeLinker().downcallHandle(
            SymbolLookup.loaderLookup().findOrThrow("depreciation"), 
            FunctionDescriptor.of(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT)
        );
        for(int n = 1; n < l; ++n)
        {
            double d = (double)depr.invoke(l, n);
            System.out.printf("%-4d%16.2f%n", n, p * (1 - d));
        }
    }
}

