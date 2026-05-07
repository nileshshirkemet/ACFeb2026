package app;

import java.lang.reflect.Method;

import finance.LoanHelper;

public class Program {
    
    public static void main(String[] args) throws Exception {
        double p = Double.parseDouble(args[0]);
        Class<?> c = Class.forName("finance." + args[1]);
        Object policy = c.getConstructor().newInstance(); //dynamic instantiation
        Method scheme = c.getMethod(args[2], double.class, int.class);
        int m = 10;
        for(int n = 1; n <= m; ++n){
            //verify method, locate implementation, box argument and dispatch call
            float r = (float)scheme.invoke(policy, p, n); //late binding
            //unboxing - explicit conversion of Object type to a 
            //primitive type(float) through its wrapper class
            double emi = LoanHelper.monthlyInstallment(p, n, r);
            System.out.printf("%-6d%16.2f%n", n, emi);
        }
    }
}
