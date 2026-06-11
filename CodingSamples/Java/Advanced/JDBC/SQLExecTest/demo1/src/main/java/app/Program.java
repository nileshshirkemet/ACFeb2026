package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Program {
    
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/sales", "root", "root");
        Statement stmt = con.createStatement();
        if(args.length == 0){
            ResultSet rs = stmt.executeQuery("select pno, 1.05 * price, stock from products");
            while(rs.next())
                System.out.printf("%d\t%.2f\t%d%n", rs.getInt("pno"), rs.getDouble(2), rs.getInt("stock"));
            rs.close();
        }else{
            int id = Integer.parseInt(args[0]);
            int n = stmt.executeUpdate("update products set stock=stock+5 where pno=" + id);
            if(n == 0)
                System.out.println("No such product!");
        }
        stmt.close();
        con.close();
    }

}

