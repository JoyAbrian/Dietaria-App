package dietaria.models;

public class aktivitas {
    private String nama;
    private int kaloriTerbakar;
    private int durasi;

    public aktivitas(String nama, int kaloriTerbakar, int durasi) {
        this.nama = nama;
        this.kaloriTerbakar = kaloriTerbakar;
        this.durasi = durasi;
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
    public void setDurasi(int durasi) {
        this.durasi = durasi;
    }
    public int getDurasi() {
        return durasi;
    }
}
