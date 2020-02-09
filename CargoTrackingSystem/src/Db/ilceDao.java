package Db;

import static Db.CreateDb.password;
import static Db.CreateDb.url2;
import static Db.CreateDb.username;
import dto.ilceler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ilceDao {

    public static List<ilceler> ilceGoster(String il_adi) {
        List<ilceler> result = new ArrayList<>();
        String query = "select * from ilceler inner join iller on ilceler.il_no=iller.il_no where iller.isim=?;";
        
        try (Connection conn = DriverManager.getConnection(url2, username, password);
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, il_adi);
            

            try(ResultSet rs = stmt.executeQuery();){
            while (rs.next()) {
                ilceler ilc = new ilceler();   
                ilc.setIl_no(rs.getInt("il_no"));
                ilc.setIlce_no(rs.getInt("ilce_no"));
                ilc.setIsim(rs.getString("isim"));
                result.add(ilc);
            }
           }catch( SQLException e){
               System.out.println(e);
           }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
