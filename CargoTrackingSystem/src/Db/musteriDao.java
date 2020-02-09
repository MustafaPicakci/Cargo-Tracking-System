package Db;

import static Db.CreateDb.password;
import static Db.CreateDb.url2;
import static Db.CreateDb.username;
import dto.allTables;
import dto.musteri;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import layout.Login;
import layout.SendCargo;

public class musteriDao {
    /*
     Aşırı yükleme Burada Kullanıldı ...
    
     */

    public static List<musteri> musteriBilgileri(String userName, int parametre2) {
        List<musteri> result = new ArrayList<>();
        String query = "select * from musteri where musteri.userName=?;";

        try (Connection conn = DriverManager.getConnection(url2, username, password);
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, userName);

            try (ResultSet rs = stmt.executeQuery();) {
                while (rs.next()) {
                    musteri musteri1 = new musteri();
                    musteri1.setMusteri_id(rs.getInt("musteri_id"));
                    musteri1.setFirstName(rs.getString("firstName"));
                    musteri1.setLastName(rs.getString("lastName"));
                    musteri1.setUserName(rs.getString("userName"));
                    musteri1.setPassword(rs.getString("password"));
                    musteri1.setEmail(rs.getString("email"));
                    musteri1.setMobileNo(rs.getString("mobileNo"));
                    musteri1.setAdress(rs.getString("address"));
                    result.add(musteri1);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<musteri> musteriBilgileri(String userName) {
        List<musteri> result = new ArrayList<>();
        String query = "select * from musteri where musteri.userName=?;";

        try (Connection conn = DriverManager.getConnection(url2, username, password);
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, userName);

            try (ResultSet rs = stmt.executeQuery();) {
                while (rs.next()) {
                    musteri musteri1 = new musteri();
                    musteri1.setMusteri_id(rs.getInt("musteri_id"));
                    musteri1.setFirstName(rs.getString("firstName"));
                    musteri1.setLastName(rs.getString("lastName"));
                    musteri1.setUserName(rs.getString("userName"));
                    musteri1.setPassword(rs.getString("password"));
                    musteri1.setEmail(rs.getString("email"));
                    musteri1.setMobileNo(rs.getString("mobileNo"));
                    musteri1.setAdress(rs.getString("address"));
                    result.add(musteri1);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<allTables> Musteri_koordinatlari() {
        List<allTables> result = new ArrayList<>();
        String query = "select lat,lon from iller where iller.isim=(select (musteri.il) from musteri where musteri_id=?);";

        try (Connection conn = DriverManager.getConnection(url2, username, password);
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, Login.online.getMusteriId());
            try (ResultSet rs = stmt.executeQuery();) {
                while (rs.next()) {
                    allTables a = new allTables();
                    a.setLat(rs.getInt("lat"));
                    a.setLon(rs.getInt("lon"));
                    result.add(a);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void addMusteri(String firstName, String lastName, String userName, String password, String email, String mobileNo, String il, String ilce, String address) {
        String query = "INSERT INTO musteri (firstName,lastName,userName,password,email,mobileNo,il,ilce,address) values('" + firstName + "','" + lastName + "','" + userName + "','"
                + password + "','" + email + "','" + mobileNo + "','" + il + "','" +ilce + "','" + address + "')";
        
        CreateDb.execute(url2, query);
    }
    
    public static boolean isAvailable(String userName){
          String isExists = "SELECT musteri.userName FROM musteri WHERE userName=?;";
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
