package dto;

public class allTables {

    private int alici_id;
    private String firstName;
    private String lastName;
    private String mobileNo;
    private String address;
    private String il;
    private String ilce;
    private int kar_id;
    private String takip_no;
    private int agirlik;
    private boolean kirilabilir;
    private String teslim_adresi;
    private int musteri_id;
    private String urun_tanimi;
    private int durum_no;
    private String durum_adi;
    private int lat;
    private int lon;
    
    public int getAlici_Id() {
        return alici_id;
    }

    public void setAlici_Id(int id) {
        this.alici_id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    } 

    public void setLastName(String lName) {
        this.lastName = lName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

     public String getAdress(){
        return address;
    }
    
    public void setAdress(String address) {
        this.address = address;
    }

    public String getIl() {
        return il;
    }

    public void setIl(String il) {
        this.il = il;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }
    
    public int getKar_id() {
        return kar_id;
    }

    public void setKar_id(int kar_id) {
        this.musteri_id = kar_id;
    }

    public String getTakip_no() {
        return takip_no;
    }

    public void setTakip_no(String takipNo) {
        this.takip_no = takipNo;
    }

    public boolean getKirilabilir() {
        return kirilabilir;
    }

    public void setKirilabilir(boolean kirilabilir) {
        this.kirilabilir = kirilabilir;
    }

    public String getTeslim_adresi() {
        return teslim_adresi;
    }

    public void setTeslim_adresi(String teslim_adresi) {
        this.teslim_adresi = teslim_adresi;
    }

    public int getMusteri_id() {
        return musteri_id;
    }

    public void setMusteri_id(int musteri_id) {
        this.musteri_id = musteri_id;
    }
    
    public int getAlici_id() {
        return alici_id;
    }

    public void setAlici_id(int alici_id) {
        this.alici_id= alici_id;
    }
    
    public String getUrun_tanimi() {
        return urun_tanimi;
    }

    public void setUrun_tanimi(String urun_tanimi) {
        this.urun_tanimi = urun_tanimi;
    }
    
    public int getDurum_no() {
        return durum_no;
    }

    public void setDurum_no(int durum_no) {
        this.durum_no = durum_no;
    }
    
    public String getDurum_adi() {
        return durum_adi;
    }

    public void setDurum_adi(String durum_adi) {
        this.durum_adi = durum_adi;
    }


    public int getLat() {
        return lat;
    }

 
    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getLon() {
        return lon;
    }

 
    public void setLon(int lon) {
        this.lon = lon;
    }
}
