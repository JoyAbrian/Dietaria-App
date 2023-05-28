package dietaria.utils;

import dietaria.models.login;

public class target {
    private login orang;

    public target(login orang) {
        this.orang = orang;
    }
    
    public int getKaloriDibutuh() {
        if (orang.isMale()) {
            return (int) Math.floor(66.5 + (13.75 * orang.getBerat()) + (5.003 * orang.getTinggi()) - (6.75 * orang.getUmur()));
        } else {
            return (int) Math.floor(655.1 + (9.563  * orang.getBerat()) + (1.850 * orang.getTinggi()) - (4.676 * orang.getUmur()));
        }
    }
    public int surplus() {
        return (this.getKaloriDibutuh() + 500);
    }
    public int maintenance() {
        return (this.getKaloriDibutuh());
    }
    public int defisit() {
        return (this.getKaloriDibutuh() - 500);
    }

    public int getProteinDibutuh() {
        return (int) (Math.ceil(orang.getBerat() * 2.2));
    }

    public int getKarbohidratDibutuh() {
        return (int) (Math.ceil(orang.getBerat() * 8));
    }

    public int getLemakDibutuh() {
        return orang.getBerat();
    }
}