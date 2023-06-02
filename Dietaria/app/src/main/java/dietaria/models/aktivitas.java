package dietaria.models;

public class aktivitas {
    private String nama;
    private int kaloriTerbakar;

    public aktivitas(String nama, int kaloriTerbakar) {
        this.nama = nama;
        this.kaloriTerbakar = kaloriTerbakar;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getNama() {
        return nama;
    }
    public void setKaloriTerbakar(int kaloriTerbakar) {
        this.kaloriTerbakar = kaloriTerbakar;
    }
    public int getKaloriTerbakar() {
        return kaloriTerbakar;
    }
}