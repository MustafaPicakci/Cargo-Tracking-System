package Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CreateDb {

    static String url = "jdbc:mysql://localhost/?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    public static String url2 = "jdbc:mysql://localhost/CargoTracking?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    // Defines username and password to connect to database server.
    public static String username = " ";  // write your mysql username in here
    public static String password = " ";  // write your mysql password in here

    public static void execute(String url, String query) {
        try (Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.execute();
            conn.close();
        } catch (Exception e) {
        //    e.printStackTrace();
        }

    }

    public CreateDb() throws SQLException {

        String sql = "CREATE DATABASE IF NOT EXISTS CargoTracking;";
        execute(url, sql);
        //Müşteri tablosu 
        String table_musteri
                = "CREATE TABLE IF NOT EXISTS musteri "
                + "(musteri_id INTEGER not NULL AUTO_INCREMENT, "
                + " firstName VARCHAR(50) NOT NULL, "
                + " lastName VARCHAR(50) NOT NULL, "
                + " userName VARCHAR(50)NOT NULL UNIQUE, "
                + " password VARCHAR(20) NOT NULL, "
                + " email VARCHAR(100) NOT NULL, "
                + "mobileNo  VARCHAR(100) NOT NULL,"
                + "il VARCHAR(30) NOT NULL,"
                + "ilce VARCHAR(30) NOT NULL,"
                + "address VARCHAR(250) NOT NULL,"
                + "PRIMARY KEY ( musteri_id ));";

        String table_admin
                = "CREATE TABLE IF NOT EXISTS admin "
                + "(admin_id INTEGER not NULL AUTO_INCREMENT, "
                + " firstName VARCHAR(50) NOT NULL, "
                + " lastName VARCHAR(50) NOT NULL, "
                + " userName VARCHAR(50)NOT NULL UNIQUE, "
                + " password VARCHAR(20) NOT NULL, "
                + " email VARCHAR(100) NOT NULL, "
                + "mobileNo  VARCHAR(100) NOT NULL,"
                + "il VARCHAR(30) NOT NULL,"
                + "ilce VARCHAR(30) NOT NULL,"
                + "address VARCHAR(250) NOT NULL,"
                + "PRIMARY KEY ( admin_id ));";
        
        String admin_ekle="INSERT INTO admin (firstName,lastName,userName,password,email,mobileNo,il,ilce,address) VALUES('Mustafa','Pıçakçı','mustafa','123456','mustafa@deneme.com','123456','ERZURUM','Aşkale','Stadyum');";
                
        //iller tablosu oluşturuluyor
        String table_iller
                = "CREATE TABLE IF NOT EXISTS iller"
                + "(il_no INTEGER NOT NULL UNIQUE,"
                + "isim VARCHAR(50),"
                + "lat INTEGER,"
                + "lon INTEGER,"
                + "PRIMARY KEY(il_no));";

        String table_ilceler = "CREATE TABLE IF NOT EXISTS ilceler("
                + "ilce_no INTEGER NOT NULL,"
                + "isim VARCHAR(50) ,"
                + "il_no INTEGER NOT NULL,"
                + "CONSTRAINT fk_il_no FOREIGN KEY (il_no)"
                + "REFERENCES iller(il_no),"
                + "PRIMARY KEY(ilce_no));";

        String table_durum = "CREATE TABLE IF NOT EXISTS durum("
                + "durum_no INTEGER NOT NULL,"
                + "durum_adi VARCHAR(50),"
                + "PRIMARY KEY(durum_no))";

        
        String table_maddi_durum="CREATE TABLE IF NOT EXISTS maddi_durum("
                + "maddi_durumNo INTEGER NOT NULL,"
                + "maddi_durum_adi VARCHAR(25),"
                + "PRIMARY KEY(maddi_durumNo))";

        
        String table_alici = "CREATE TABLE IF NOT EXISTS alici "
                + "(alici_id INTEGER not NULL AUTO_INCREMENT, "
                + " firstName VARCHAR(50) NOT NULL, "
                + " lastName VARCHAR(50) NOT NULL, "
                + "mobileNo  VARCHAR(100) NOT NULL,"
                + "ilce VARCHAR(100) not NULL,"
                + "il VARCHAR(100) not NULL,"
                + "address VARCHAR(250) NOT NULL,"
                + " PRIMARY KEY ( alici_id ));";

        String table_kargo = "CREATE TABLE IF NOT EXISTS kargo("
                + "kar_id INTEGER NOT NULL AUTO_INCREMENT,"
                + "takip_no VARCHAR(15) not null,"
                + "kar_agirlik DOUBLE NOT NULL,"
                + "kirilabilir INTEGER NOT NULL,"
                + "teslim_adresi VARCHAR(250) NOT NULL,"
                + "musteri_id INTEGER NOT NULL,"
                + "alici_id INTEGER NOT NULL,"
                + "urun_tanimi VARCHAR(250) NOT NULL,"
                + "gonderme_tarihi DATE NOT NULL,"
                + "teslim_tarihi DATE,"
                + "durum_no INTEGER NOT NULL,"
                + "ucret INTEGER NOT NULL,"
                + "maddi_durumNo INTEGER NOT NULL,"
                + "CONSTRAINT fk_durum_no FOREIGN KEY (durum_no)"
                + "REFERENCES durum(durum_no),"
                + "CONSTRAINT fk_maddi_durum_no FOREIGN KEY (maddi_durumNo)"
                + "REFERENCES maddi_durum(maddi_durumNo),"
                + "CONSTRAINT fk_alici_id FOREIGN KEY (alici_id)"
                + "REFERENCES alici(alici_id),"
                + "PRIMARY KEY(kar_id));";

        
        
        String il_ekle = "INSERT INTO iller (il_no, isim,lat,lon) VALUES (1, 'ADANA',37.00000000, 35.32133330),"
                + "(2, 'ADIYAMAN',37.76416670, 38.27616670),"
                + "(3, 'AFYON', 38.76376000, 30.54034000),"
                + "(4, 'AĞRI', 39.72166670, 43.05666670),"
                + "(5, 'AMASYA',40.65000000, 35.83333330),"
                + "(6, 'ANKARA', 39.92077000, 32.85411000),"
                + "(7, 'ANTALYA', 36.88414000, 30.70563000),"
                + "(8, 'ARTVİN',41.18333330, 41.81666670),"
                + "(9, 'AYDIN',37.84440000, 27.84580000),"
                + "(10, 'BALIKESİR', 39.64836900, 27.88261000),"
                + "(11, 'BİLECİK', 40.15013100, 29.98306100),"
                + "(12, 'BİNGÖL', 38.88534900, 40.49829100),"
                + "(13, 'BİTLİS', 38.40000000, 42.11666670),"
                + "(14, 'BOLU', 40.73947900, 31.61156100),"
                + "(15, 'BURDUR', 37.72690900, 30.28887600),"
                + "(16, 'BURSA', 40.18257000, 29.06687000),"
                + "(17, 'ÇANAKKALE', 40.15531200, 26.41416000),"
                + "(18, 'ÇANKIRI', 40.60000000, 33.61666670),"
                + "(19, 'ÇORUM', 40.55055560, 34.95555560),"
                + "(20, 'DENİZLİ', 37.77652000, 29.08639000),"
                + "(21, 'DİYARBAKIR', 37.91441000, 40.23062900),"
                + "(22, 'EDİRNE', 41.66666670, 26.56666670),"
                + "(23, 'ELAZIĞ', 38.68096900, 39.22639800),"
                + "(24, 'ERZİNCA', 39.75000000, 39.50000000),"
                + "(25, 'ERZURUM', 39.90431890, 41.26788530),"
                + "(26, 'ESKİŞEHİR', 39.78430200, 30.51922000),"
                + "(27, 'GAZİANTEP', 37.06622000, 37.38332000),"
                + "(28, 'GİRESUN', 40.91281100, 38.38953000),"
                + "(29, 'GÜMÜŞHANE', 40.46027780, 39.48138890),"
                + "(30, 'HAKKARİ', 37.58333330, 43.73333330),"
                + "(31, 'HATAY', 36.40184880, 36.34980970),"
                + "(32, 'ISPARTA', 37.76666670, 30.55000000),"
                + "(33, 'MERSİN', 36.80000000, 34.63333330),"
                + "(34, 'İSTANBUL', 41.00527000, 28.97696000),"
                + "(35, 'İZMİR', 38.41885000, 27.12872000),"
                + "(36, 'KARS', 40.59267000, 43.07783100),"
                + "(37, 'KASTAMONU', 41.38871000, 33.78273000),"
                + "(38, 'KAYSERİ', 38.73333330, 35.48333330),"
                + "(39, 'KIRKLARELİ', 41.73333330, 27.21666670),"
                + "(40, 'KIRŞEHİR', 39.15000000, 34.16666670),"
                + "(41, 'KOCAELİ', 40.85327040, 29.88152030),"
                + "(42, 'KONYA', 37.86666670, 32.48333330),"
                + "(43, 'KÜTAHYA', 39.41666670, 29.98333330),"
                + "(44, 'MALATYA', 38.35519000, 38.30946000),"
                + "(45, 'MANİSA', 38.61909900, 27.42892100),"
                + "(46, 'KAHRAMANMARAŞ', 37.58333330, 36.93333330),"
                + "(47, 'MARDİN', 37.31223610, 40.73511200),"
                + "(48, 'MUĞLA', 37.21527780, 28.36361110),"
                + "(49, 'MUŞ', 38.74329260, 41.50648230),"
                + "(50, 'NEVŞEHİR', 38.62442000, 34.72396900),"
                + "(51, 'NİĞDE', 37.96666670, 34.68333330),"
                + "(52, 'ORDU', 40.98333330, 37.88333330),"
                + "(53, 'RİZE', 41.02005000, 40.52344900),"
                + "(54, 'SAKARYA', 40.75687930, 30.37813800),"
                + "(55, 'SAMSUN', 41.29278200, 36.33128000),"
                + "(56, 'SİİRT', 37.94429000, 41.93288000),"
                + "(57, 'SİNOP', 42.02642220, 35.15507450),"
                + "(58, 'SİVAS', 39.74766200, 37.01787900),"
                + "(59, 'TEKİRDAĞ', 40.98333330, 27.51666670),"
                + "(60, 'TOKAT', 40.31666670, 36.55000000),"
                + "(61, 'TRABZON', 41.00000000, 39.73333330),"
                + "(62, 'TUNCELİ', 39.10798680, 39.54016720),"
                + "(63, 'ŞANLIURFA', 37.15000000, 38.80000000),"
                + "(64, 'UŞAK', 38.68230100, 29.40819000),"
                + "(65, 'VAN', 38.49416670, 43.38000000),"
                + "(66, 'YOZGAT', 39.82000000, 34.80444440),"
                + "(67, 'ZONGULDAK', 41.45640900, 31.79873100),"
                + "(68, 'AKSARAY', 38.36869000, 34.03698000),"
                + "(69, 'BAYBURT', 40.25516900, 40.22488000),"
                + "(70, 'KARAMAN', 37.17593000, 33.22874800),"
                + "(71, 'KIRIKKALE', 39.84682100, 33.51525100),"
                + "(72, 'BATMAN', 37.88116800, 41.13509000),"
                + "(73, 'ŞIRNAK', 37.51638890, 42.46111110),"
                + "(74, 'BARTIN', 41.63444440, 32.33750000),"
                + "(75, 'ARDAHAN', 41.11048100, 42.70217100),"
                + "(76, 'IĞDIR', 39.91666670, 44.03333330),"
                + "(77, 'YALOVA', 40.65000000, 29.26666670),"
                + "(78, 'KARABÜK', 41.20000000, 32.63333330),"
                + "(79, 'KİLİS', 36.71839900, 37.12122000),"
                + "(80, 'OSMANİYE', 37.06805000, 36.26158900),"
                + "(81, 'DÜZCE', 40.84384900, 31.15654000);";

        String ilce_ekle = "INSERT INTO ilceler (ilce_no,isim,il_no) VALUES (1,'Abana',37),"
                + "(2,'Acıgöl',50),\n"
                + "(3,'Acıpayam',20),\n"
                + "(4,'Adaklı',12),\n"
                + "(5,'Adalar',34),\n"
                + "(6,'Adapazarı',54),\n"
                + "(7,'Adıyaman',2),\n"
                + "(8,'Adilcevaz',13),\n"
                + "(9,'Afşin',46),\n"
                + "(10,'Afyonkarahisar',3),\n"
                + "(11,'Ağaçören',68),\n"
                + "(12,'Ağın',23),\n"
                + "(13,'Ağlasun',15),\n"
                + "(14,'Ağlı',37),\n"
                + "(15,'Ağrı',4),\n"
                + "(16,'Ahırlı',42),\n"
                + "(17,'Ahlat',13),\n"
                + "(18,'Ahmetli',45),\n"
                + "(19,'Akçaabat',61),\n"
                + "(20,'Akçadağ',44),\n"
                + "(21,'Akçakale',63),\n"
                + "(22,'Akçakent',40),\n"
                + "(23,'Akçakoca',81),\n"
                + "(24,'Akdağmadeni',66),\n"
                + "(25,'Akdeniz',33),\n"
                + "(26,'Akhisar',45),\n"
                + "(27,'Akıncılar',58),\n"
                + "(28,'Akkışla',38),\n"
                + "(29,'Akkuş',52),\n"
                + "(30,'Akören',42),\n"
                + "(31,'Akpınar',40),\n"
                + "(32,'Aksaray',68),\n"
                + "(33,'Akseki',7),\n"
                + "(34,'Aksu',7),\n"
                + "(35,'Aksu',32),\n"
                + "(36,'Akşehir',42),\n"
                + "(37,'Akyaka',36),\n"
                + "(38,'Akyazı',54),\n"
                + "(39,'Akyurt',6),\n"
                + "(40,'Alaca',19),\n"
                + "(41,'Alacakaya',23),\n"
                + "(42,'Alaçam',55),\n"
                + "(43,'Aladağ',1),\n"
                + "(44,'Alanya',7),\n"
                + "(45,'Alaplı',67),\n"
                + "(46,'Alaşehir',45),\n"
                + "(47,'Aliağa',35),\n"
                + "(48,'Almus',60),\n"
                + "(49,'Alpu',26),\n"
                + "(50,'Altıeylül',10),\n"
                + "(51,'Altındağ',6),\n"
                + "(52,'Altınekin',42),\n"
                + "(53,'Altınordu',52),\n"
                + "(54,'Altınova',77),\n"
                + "(55,'Altınözü',31),\n"
                + "(56,'Altıntaş',43),\n"
                + "(57,'Altınyayla',15),\n"
                + "(58,'Altınyayla',58),\n"
                + "(59,'Altunhisar',51),\n"
                + "(60,'Alucra',28),\n"
                + "(61,'Amasra',74),\n"
                + "(62,'Amasya',5),\n"
                + "(63,'Anamur',33),\n"
                + "(64,'Andırın',46),\n"
                + "(65,'Antakya',31),\n"
                + "(66,'Araban',27),\n"
                + "(67,'Araç',37),\n"
                + "(68,'Araklı',61),\n"
                + "(69,'Aralık',76),\n"
                + "(70,'Arapgir',44),\n"
                + "(71,'Ardahan',75),\n"
                + "(72,'Ardanuç',8),\n"
                + "(73,'Ardeşen',53),\n"
                + "(74,'Arguvan',44),\n"
                + "(75,'Arhavi',8),\n"
                + "(76,'Arıcak',23),\n"
                + "(77,'Arifiye',54),\n"
                + "(78,'Armutlu',77),\n"
                + "(79,'Arnavutköy',34),\n"
                + "(80,'Arpaçay',36),\n"
                + "(81,'Arsin',61),"
                + "(82,'Arsuz',31),\n"
                + "(83,'Artova',60),\n"
                + "(84,'Artuklu',47),\n"
                + "(85,'Artvin',8),\n"
                + "(86,'Asarcık',55),\n"
                + "(87,'Aslanapa',43),\n"
                + "(88,'Aşkale',25),\n"
                + "(89,'Atabey',32),\n"
                + "(90,'Atakum',55),\n"
                + "(91,'Ataşehir',34),\n"
                + "(92,'Atkaracalar',18),\n"
                + "(93,'Avanos',50),\n"
                + "(94,'Avcılar',34),\n"
                + "(95,'Ayancık',57),\n"
                + "(96,'Ayaş',6),\n"
                + "(97,'Aybastı',52),\n"
                + "(98,'Aydıncık',33),\n"
                + "(99,'Aydıncık',66),\n"
                + "(100,'Aydıntepe',69);";

        String durum_ekle = "INSERT INTO durum (durum_no,durum_adi) VALUES (1, 'Hazırlanıyor'),"
                + "(2, 'Yola çıktı'),"
                + "(3, 'Dağıtımda'),"
                + "(4,'Teslim edildi');";
        
        String maddi_durum_ekle="INSERT INTO maddi_durum (maddi_durumNo,maddi_durum_adi) VALUES (1, 'Ödendi'),"
                + "(2, 'Kapıda Ödeme')";

        execute(url2, table_musteri); // Sorgular çalıştırılıyor
        execute(url2, table_admin);
        execute(url2, table_iller);
        execute(url2, table_ilceler);
        execute(url2, table_durum);
        execute(url2, table_maddi_durum);
        execute(url2, table_alici);
        execute(url2, il_ekle);
        execute(url2, ilce_ekle);
        execute(url2, durum_ekle);
        execute(url2, maddi_durum_ekle);
        execute(url2, table_kargo);
        execute(url2,admin_ekle );
        
    }

 
}
