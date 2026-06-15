package app.tourism;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SiteRepository {
   
    public List<Visitor> findAllVisitors() {
        try(var con = DriverManager.getConnection("jdbc:h2:file:./data/site")){
            var entries = new ArrayList<Visitor>();
            var stmt = con.createStatement();
            var rs = stmt.executeQuery("select name, visits, recent, rating from visitors");
            while(rs.next()){
                var entry = new Visitor(null);
                entry.id = rs.getString(1);
                entry.visitCount = rs.getInt(2);
                entry.lastVisit = rs.getTimestamp(3);
                entry.rating = rs.getInt(4);
                entries.add(entry);
            }
            rs.close();
            stmt.close();
            return entries;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Visitor findVisitorById(String id) {
        try(var con = DriverManager.getConnection("jdbc:h2:file:./data/site")){
            Visitor entry = null;
            var stmt = con.prepareStatement("select visits, recent, rating from visitors where name=?");
            stmt.setString(1, id);
            var rs = stmt.executeQuery();
            if(rs.next()){
                entry = new Visitor(id);
                entry.visitCount = rs.getInt(1);
                entry.lastVisit = rs.getTimestamp(2);
                entry.rating = rs.getInt(3);
            }
            rs.close();
            stmt.close();
            return entry;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void save(Visitor entry) {
        try(var con = DriverManager.getConnection("jdbc:h2:file:./data/site")){
            var stmt1 = con.prepareStatement("update visitors set visits=?, recent=?, rating=? where name=?");
            stmt1.setInt(1, entry.visitCount);
            stmt1.setTimestamp(2, entry.lastVisit);
            stmt1.setInt(3, entry.rating);
            stmt1.setString(4, entry.id);
            if(stmt1.executeUpdate() == 0){
                stmt1.close();
                var stmt2 = con.prepareStatement("insert into visitors values(?, ?, ?, ?)");
                stmt2.setString(1, entry.id);
                stmt2.setInt(2, entry.visitCount);
                stmt2.setTimestamp(3, entry.lastVisit);
                stmt2.setInt(4, entry.rating);
                stmt2.executeUpdate();
                stmt2.close();
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }


}
