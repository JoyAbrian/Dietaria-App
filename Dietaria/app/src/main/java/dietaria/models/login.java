package dietaria.models;

public class login {
    private String fullname;
    private String username;
    private String password;
    private boolean isMale;
    private int umur;
    private int berat;
    private int tinggi;

    public login(String fullname, String username, String password, boolean isMale, int umur, int berat, int tinggi) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.isMale = isMale;
        this.umur = umur;
        this.berat = berat;
        this.tinggi = tinggi;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setMale(boolean isMale) {
        this.isMale = isMale;
    }
    public void setUmur(int umur) {
        this.umur = umur;
    }
    public void setBerat(int berat) {
        this.berat = berat;
    }
    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }
    public String getFullname() {
        return fullname;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public boolean isMale() {
        return isMale;
    }
    public int getUmur() {
        return umur;
    }
    public int getBerat() {
        return berat;
    }
    public int getTinggi() {
        return tinggi;
    }
}
