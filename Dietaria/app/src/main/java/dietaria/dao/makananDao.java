package dietaria.dao;

import dietaria.models.makanan;
import dietaria.utils.DatabaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class makananDao {
    private static Connection conn;
    private static Statement stmt;

    public static void getConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:db/dietaria.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void setupTableMakanan() {
        getConnection();
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

    public static boolean saveMakanan(makanan makanan) {
        setupTableMakanan();
        try {
            String sql = "INSERT INTO makanan(nama, porsi, kalori, protein, karbohidrat, lemak) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, makanan.getNama());
            pstmt.setInt(2, makanan.getPorsi());
            pstmt.setInt(3, makanan.getKalori());
            pstmt.setInt(4, makanan.getProtein());
            pstmt.setInt(5, makanan.getKarbohidrat());
            pstmt.setInt(6, makanan.getLemak());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static ArrayList<makanan> getAllMakanan() {
        ArrayList<makanan> makananList = new ArrayList<>();
        getConnection();
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
