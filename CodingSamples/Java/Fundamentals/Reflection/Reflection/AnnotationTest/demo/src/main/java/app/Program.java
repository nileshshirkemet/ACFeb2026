package app;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;

import finance.Flexible;
import finance.LoanHelper;

public class Program {
    
    public static void main(String[] args) throws Throwable {
        double p = Double.parseDouble(args[0]);
        Class<?> c = Class.forName("finance." + args[1]);
        Object policy = c.getConstructor().newInstance();
        Method scheme = c.getMethod(args[2], double.class, int.class);
        //MethodHandle holds a direct typed reference to the implementation
        //of a method for the object to which it is bound
        MethodHandle schemeHandle = MethodHandles.lookup()
            .unreflect(scheme)
            .bindTo(policy); //verify method and locate implementation
        int m = 10;
        double pf = c.isAnnotationPresent(Flexible.class) ? 0.005 * p : 0;
        for(int n = 1; n <= m; ++n){
            //dispatch call
            float r = (float)schemeHandle.invokeExact(p, n);
            double emi = LoanHelper.monthlyInstallment(p, n, r);
            System.out.printf("%-6d%16.2f%n", n, emi);
        }
        System.out.println("----------------------");
        System.out.printf("Processing Fees: %.2f%n", pf);
    }
}
