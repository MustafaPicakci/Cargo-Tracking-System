package dto;

public class musteri {
    private int musteri_id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private String mobileNo;
    private String address;
    private String il;
    private String ilce;
    
    public int getMusteriId(){
        return musteri_id;
    }
    
    public void setMusteri_id(int id){
        this.musteri_id=id;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
     public void setFirstName(String name){
        this.firstName=name;
    }
     
    public String getLastName(){
        return lastName;
    }
    
     public void setLastName(String lName){
        this.lastName=lName;
    }
     
     public String getUserName(){
        return userName;
    }
    
     public void setUserName(String uName){
        this.userName=uName;
    }
    
      public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password=password;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email=email;
    }
    
    public String getMobileNo(){
        return mobileNo;
    }
    
    public void setMobileNo(String mobileNo){
        this.mobileNo=mobileNo;
    }
    
    public String getAdress(){
        return password;
    }
    
    public void setAdress(String address){
        this.address=address;
    }
    
    public String getIl(){
        return il;
    }
    
    public void setIl_no(String il){
        this.il=il;
    }
    
     public String getIlce(){
        return ilce;
    }
    
    public void setIlce_no(String ilce){
        this.ilce=ilce;
    }
    
}
