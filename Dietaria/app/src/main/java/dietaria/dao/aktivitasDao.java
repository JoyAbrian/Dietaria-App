package dietaria.dao;

import dietaria.models.aktivitas;
import dietaria.utils.DatabaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class aktivitasDao {
    private static Connection conn;
    private static Statement stmt;

    // public makananDao() {
    //     conn = DatabaseConfig.getConnection();
    //     setupTable();
    // }

    public static void getConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:db/dietaria.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void setupTableAktivitas() {
        getConnection();
        try {
            stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS aktivitas " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " nama TEXT NOT NULL, " +
                    " kaloriTerbakar INTEGER NOT NULL, " +
                    " durasi INTEGER NOT NULL, ";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean saveAktivitas(aktivitas aktivitas) {
        setupTableAktivitas();
        try {
            String sql = "INSERT INTO makanan(nama, kaloriTerbakar, durasi) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, aktivitas.getNama());
            pstmt.setInt(2, aktivitas.getKaloriTerbakar());
            pstmt.setInt(3, aktivitas.getDurasi());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<aktivitas> getAllAktivitas() {
        List<aktivitas> aktivitasList = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM aktivitas");
            while (rs.next()) {
                String nama = rs.getString("nama");
                int kaloriTerbakar = rs.getInt("kaloriTerbakar");
                int durasi = rs.getInt("durasi");
                aktivitasList.add(new aktivitas(nama, kaloriTerbakar, durasi));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aktivitasList;
    }
}
