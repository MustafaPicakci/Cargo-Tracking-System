package Db;

import static Db.CreateDb.password;
import static Db.CreateDb.url2;
import static Db.CreateDb.username;
import dto.allTables;
import dto.kargo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static layout.searchById.durum;
import static layout.searchById.takipNo;

public class kargoDao {

    public static List<allTables> getInfo(String takipNo) {
        String query = "SELECT kargo.urun_tanimi,kargo.takip_no,alici.firstName,alici.lastName,kargo.teslim_adresi,durum.durum_adi"
                + " FROM musteri INNER JOIN kargo ON musteri.musteri_id=kargo.musteri_id"
                + " INNER JOIN durum ON kargo.durum_no=durum.durum_no"
                + " INNER JOIN alici ON alici.alici_id=kargo.alici_id WHERE kargo.takip_no=?;";
        List<allTables> result = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url2, username, password);
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, takipNo);
            try (ResultSet rs = stmt.executeQuery();) {
                while (rs.next()) {
                    allTables info = new allTables();
                    info.setUrun_tanimi(rs.getString("urun_tanimi"));
                    info.setTakip_no(rs.getString("takip_no"));
                    info.setFirstName(rs.getString("firstName"));
                    info.setLastName(rs.getString("lastName"));
                    info.setAdress(rs.getString("teslim_adresi"));
                    info.setDurum_adi(rs.getString("durum_adi"));

                    result.add(info);
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

    public static double getdistance(int musteri_x, int musteri_y, int alici_x, int alici_y) {
        System.out.println(" musterix  " + musteri_x + "   " + " musteriy  " + musteri_y + " alicix   " + alici_x + " aliciy  " + alici_y);
        System.out.println("getDistance Çalıiştı");
        String query = "select ST_Distance_Sphere(point(?, ?),point(?, ?))";
        double result = 0;
        try (Connection conn = DriverManager.getConnection(url2, username, password);
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, musteri_x);
            stmt.setInt(2, musteri_y);
            stmt.setInt(3, alici_x);
            stmt.setInt(4, alici_y);
            try (ResultSet rs = stmt.executeQuery();) {
                while (rs.next()) {
                    result = rs.getDouble(1);
                    System.out.println(result + "asdasf");
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

    public static double getCargoPrice(double distance, double agirlik) {
        double price = 0;
        System.out.println(distance + "----" + agirlik);
        if (distance == 0) {
            price = distance * 1 / 9800 + agirlik * 7 / 10;
            System.out.println("1");
        } else if (distance < 300000) {
            price = distance * 1 / 9800 + agirlik * 5 / 10;
            System.out.println("2");
        } else if (distance < 600000) {
            price = distance * 1 / 9800 + agirlik * 5 / 10;
            System.out.println("3");
        } else {
            price = distance * 1 / 9800 + agirlik * 4 / 10;
            System.out.println("4");
        }
        System.out.println("price:" + price);
        return price;
    }

    public static boolean takip_no_isexist(String takipNo) {
        String isExists = "SELECT takip_no FROM kargo WHERE takip_no=?;";
        boolean result = false;
        try (Connection conn = DriverManager.getConnection(url2, username, password);
                PreparedStatement stmt = conn.prepareStatement(isExists)) {
            stmt.setString(1, takipNo);
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

    //parametre değişkeni bu projede aşırı yüklenme kullanılması zorunlu olduğu için kullanıldı.
    public static void delKargo(String takip_no, int parametre) {
        String delete_kargo = "Delete from kargo where takip_no='" + takipNo + "';";
        if (parametre == 1) {
            if (!((durum.equals("Yola çıktı")) || (durum.equals("Dağıtımda")))) {
                CreateDb.execute(url2, delete_kargo);
                JOptionPane.showMessageDialog(null, "Kargo iadesi başlatıldı.");
            } else {
                JOptionPane.showMessageDialog(null, "Kargo yola çıktı.Kargo teslim edilmeden iade edilemez!");
            }
        } else {
            CreateDb.execute(url2, delete_kargo);
            JOptionPane.showMessageDialog(null, "Kayıt silindi");
        }
    }

    public static void delKargo(String takip_no, double parametre) {
        String delete_kargo = "Delete from kargo where takip_no='" + takip_no + "';";
        if (parametre == 1) {
            if (!((durum.equals("Yola çıktı")) || (durum.equals("Dağıtımda")))) {
                CreateDb.execute(url2, delete_kargo);
                JOptionPane.showMessageDialog(null, "Kargo iadesi başlatıldı.");
            } else {
                JOptionPane.showMessageDialog(null, "Kargo yola çıktı.Kargo teslim edilmeden iade edilemez!");
            }
        } else {
            CreateDb.execute(url2, delete_kargo);
            JOptionPane.showMessageDialog(null, "Kayıt silindi");
        }
    }

    public static void sendKargo(String takip_no, double kar_agirlik, int kirilabilir, String teslim_adresi, int musteri_id, int alici_id, String urun_tanimi, Date gonderme_tarihi, int durum_no, int ucret, int maddi_durumNo) {
        System.out.println("aaaaaaaaaaaaaaaaaaa"+takip_no);
        String insert_kargo = "INSERT INTO kargo (takip_no,kar_agirlik,kirilabilir,teslim_adresi,musteri_id,alici_id,urun_tanimi,gonderme_tarihi,durum_no,ucret,maddi_durumNo) VALUES('" + takip_no + "','"
                + kar_agirlik + "','" + kirilabilir + "','" + teslim_adresi + "','" + musteri_id
                + "','" + alici_id + "','" + urun_tanimi + "','" + gonderme_tarihi + "','" + 1 + "','" + ucret + "','" + maddi_durumNo + "')";
       
        CreateDb.execute(CreateDb.url2, insert_kargo);
    }
}
