package dietaria.dao;

import dietaria.models.aktivitas;
import dietaria.utils.DatabaseConfig;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class aktivitasDao {
    private Connection conn;
    private Statement stmt;

    public aktivitasDao() {
        conn = DatabaseConfig.getConnection();
        setupTable();
    }

    private void setupTable() {
        try {
            DatabaseMetaData meta = conn.getMetaData();
            ResultSet rs = meta.getTables(null, null, "aktivitass", null);
            if (!rs.next()) {
                stmt = conn.createStatement();
                String sql = "CREATE TABLE aktivitas " +
                        "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        " nama TEXT NOT NULL UNIQUE," +
                        " kaloriTerbakar INTEGER NOT NULL, " +
                        " durasi INTEGER NOT NULL)";
                stmt.executeUpdate(sql);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<aktivitas> getAll() throws SQLException {
        try {
            List<aktivitas> listaktivitas = new ArrayList<>();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM aktivitass");
            while (rs.next()) {
                String nama = rs.getString("nama");
                int kaloriTerbakar = rs.getInt("kaloriTerbakar");
                int durasi = rs.getInt("durasi");
                listaktivitas.add(new aktivitas(nama, kaloriTerbakar, durasi));
            }
            return listaktivitas;
        } catch (SQLException e) {
            throw new SQLException();
        }
    }

    public void syncData(List<aktivitas> aktivitass) {
        try {
            stmt.executeUpdate("DELETE FROM aktivitass");
            String sql = "INSERT INTO aktivitass(nama, kaloriTerbakar, durasi) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            for (aktivitas activity : aktivitass) {
                pstmt.setString(1, activity.getNama());
                pstmt.setInt(2, activity.getKaloriTerbakar());
                pstmt.setInt(3, activity.getDurasi());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
