package dto;

public class kargo {

    private int kar_id;
    private String takip_no;
    private int agirlik;
    private boolean kirilabilir;
    private String teslim_adresi;
    private int musteri_id;
    private int alici_id;
    private String urun_tanimi;
    private int durum_no;

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
}
