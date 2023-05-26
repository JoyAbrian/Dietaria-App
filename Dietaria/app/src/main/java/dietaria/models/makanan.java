package dietaria.models;

public class makanan {
    private String nama;
    private int porsi;
    private int kalori; //Per 100gr
    private int protein;
    private int karbohidrat;
    private int lemak;
    
    public String getNama() {
        return nama;
    }
    public int getPorsi() {
        return porsi;
    }
    public int getKalori() {
        return kalori;
    }
    public int getProtein() {
        return protein;
    }
    public int getKarbohidrat() {
        return karbohidrat;
    }
    public int getLemak() {
        return lemak;
    }
}