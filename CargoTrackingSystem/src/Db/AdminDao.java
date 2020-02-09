package Db;

import static Db.CreateDb.password;
import static Db.CreateDb.url2;
import static Db.CreateDb.username;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {

    public static void addAdmin(String firstName, String lastName, String userName, String password, String email, String mobileNo, String il, String ilce, String address) {
        String query = "INSERT INTO admin (firstName,lastName,userName,password,email,mobileNo,il,ilce,address) values('" + firstName + "','" + lastName + "','" + userName + "','"
                + password + "','" + email + "','" + mobileNo + "','" + il + "','" + ilce + "','" + address + "')";

        CreateDb.execute(url2, query);
    }

    public static boolean isAvailable(String userName) {
        String isExists = "SELECT admin.userName FROM admin WHERE userName=?;";
        boolean result = false;
        try (Connection conn = DriverManager.getConnection(url2, username, password);
                PreparedStatement stmt = conn.prepareStatement(isExists)) {
            stmt.setString(1, userName);
            try (ResultSet rs = stmt.executeQuery();) {
                while (rs.next()) {

                    result = true;
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    
    
}
