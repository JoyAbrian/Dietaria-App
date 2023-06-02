package dietaria.models;

import dietaria.utils.nutrisi;

public class totalNutrisi {
    private int totalKalori;
    private int totalProtein;
    private int totalKarbo;
    private int totalLemak;

    public totalNutrisi() {
        this.totalKalori = 0;
        this.totalProtein = 0;
        this.totalKarbo = 0;
        this.totalLemak = 0;
    }

    public int getTotalKalori() {
        return totalKalori;
    }

    public void setTotalKalori(int totalKalori) {
        this.totalKalori = totalKalori;
    }

    public int getTotalProtein() {
        return totalProtein;
    }

    public void setTotalProtein(int totalProtein) {
        this.totalProtein = totalProtein;
    }

    public int getTotalKarbo() {
        return totalKarbo;
    }

    public void setTotalKarbo(int totalKarbo) {
        this.totalKarbo = totalKarbo;
    }

    public int getTotalLemak() {
        return totalLemak;
    }

    public void setTotalLemak(int totalLemak) {
        this.totalLemak = totalLemak;
    }

    public void addMakanan(makanan food) {
        nutrisi calculator = new nutrisi();
        totalKalori += calculator.kalkulasiKalori(food);
        totalProtein += calculator.kalkulasiProtein(food);
        totalKarbo += calculator.kalkulasiKarbohidrat(food);
        totalLemak += calculator.kalkulasiLemak(food);
    }

    public void removeMakanan(makanan food) {
        nutrisi calculator = new nutrisi();
        totalKalori -= calculator.kalkulasiKalori(food);
        totalProtein -= calculator.kalkulasiProtein(food);
        totalKarbo -= calculator.kalkulasiKarbohidrat(food);
        totalLemak -= calculator.kalkulasiLemak(food);
    }
}