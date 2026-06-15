package app.components;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class CustomerModelBean {
    
    private static final HikariDataSource pool = new HikariDataSource(
        new HikariConfig("db.properties")
    );

    private String id;

    public final String getId() {
        return id;
    }

    public boolean authenticate(String customerId, String password) {
        try(var con = pool.getConnection()){
            var stmt = con.prepareStatement("select count(cust_id) from customers where cust_id=? and pwd=?");
            stmt.setString(1, customerId);
            stmt.setString(2, password);
            var rs = stmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            rs.close();
            stmt.close();
            if(count == 1){
                id = customerId;
                return true;
            }
            return false;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<CustomerOrder> getOrders() {
        try(var con = pool.getConnection()){
            var stmt = con.prepareStatement("select pno, qty, ord_date from orders where cust_id=?");
            stmt.setString(1, id);
            var rs = stmt.executeQuery();
            var orders = new ArrayList<CustomerOrder>();
            while(rs.next()){
                var order = new CustomerOrder(rs);
                orders.add(order);
            }
            rs.close();
            stmt.close();
            return orders;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
