package dietaria.models;

public class makanan {
    private String nama;
    private int porsi;
    private int kalori;
    private int protein;
    private int karbohidrat;
    private int lemak;

    public makanan(String nama, int porsi, int kalori, int protein, int karbohidrat, int lemak) {
        this.nama = nama;
        this.porsi = porsi;
        this.kalori = kalori;
        this.protein = protein;
        this.karbohidrat = karbohidrat;
        this.lemak = lemak;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setPorsi(int porsi) {
        this.porsi = porsi;
    }
    public void setKalori(int kalori) {
        this.kalori = kalori;
    }
    public void setProtein(int protein) {
        this.protein = protein;
    }
    public void setKarbohidrat(int karbohidrat) {
        this.karbohidrat = karbohidrat;
    }
    public void setLemak(int lemak) {
        this.lemak = lemak;
    }
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