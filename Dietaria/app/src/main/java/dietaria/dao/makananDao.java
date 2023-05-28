package dietaria.dao;

import dietaria.models.makanan;
import dietaria.utils.DatabaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class makananDao {
    private Connection conn;
    private Statement stmt;

    public makananDao() {
        conn = DatabaseConfig.getConnection();
        setupTable();
    }

    private void setupTable() {
        try {
            stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS makanan " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " nama TEXT NOT NULL, " +
                    " porsi INTEGER NOT NULL, " +
                    " kalori INTEGER NOT NULL, " +
                    " protein INTEGER NOT NULL, " +
                    " karbohidrat INTEGER NOT NULL, " +
                    " lemak INTEGER NOT NULL)";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveMakanan(makanan makanan) {
        try {
            String sql = "INSERT INTO makanan(nama, porsi, kalori, protein, karbohidrat, lemak) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, makanan.getNama());
            pstmt.setInt(2, makanan.getPorsi());
            pstmt.setInt(3, makanan.getKalori());
            pstmt.setInt(4, makanan.getProtein());
            pstmt.setInt(5, makanan.getKarbohidrat());
            pstmt.setInt(6, makanan.getLemak());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<makanan> getAllMakanan() {
        List<makanan> makananList = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM makanan");
            while (rs.next()) {
                String nama = rs.getString("nama");
                int porsi = rs.getInt("porsi");
                int kalori = rs.getInt("kalori");
                int protein = rs.getInt("protein");
                int karbohidrat = rs.getInt("karbohidrat");
                int lemak = rs.getInt("lemak");
                makananList.add(new makanan(nama, porsi, kalori, protein, karbohidrat, lemak));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return makananList;
    }
}
