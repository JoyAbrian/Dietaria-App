package dietaria.dao;

import dietaria.models.login;
import dietaria.utils.DatabaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class loginDao {
    private Connection conn;
    private Statement stmt;

    public loginDao() {
        conn = DatabaseConfig.getConnection();
        setupTable();
    }

    private void setupTable() {
        try {
            stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS login " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " fullname TEXT NOT NULL, " +
                    " username TEXT NOT NULL UNIQUE, " +
                    " password TEXT NOT NULL, " +
                    " isMale BOOLEAN NOT NULL, " +
                    " umur INTEGER NOT NULL, " +
                    " berat INTEGER NOT NULL, " +
                    " tinggi INTEGER NOT NULL)";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(login user) {
        try {
            String sql = "INSERT INTO login(fullname, username, password, isMale, umur, berat, tinggi) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getFullname());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getPassword());
            pstmt.setBoolean(4, user.isMale());
            pstmt.setInt(5, user.getUmur());
            pstmt.setInt(6, user.getBerat());
            pstmt.setInt(7, user.getTinggi());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public login getUserByUsername(String username) {
        try {
            String sql = "SELECT * FROM login WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String fullname = rs.getString("fullname");
                String password = rs.getString("password");
                boolean isMale = rs.getBoolean("isMale");
                int umur = rs.getInt("umur");
                int berat = rs.getInt("berat");
                int tinggi = rs.getInt("tinggi");
                return new login(fullname, username, password, isMale, umur, berat, tinggi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}