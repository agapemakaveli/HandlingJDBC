package datos;

import domain.User;

import java.sql.*;
import java.util.*;

import static datos.Conexion.*;

public class UserDAO {private static final String SQL_SELECT = "SELECT id_user, username, password FROM user";
    private static final String SQL_INSERT = "INSERT INTO user(username, password)VALUE(?,?)";
    private static final String SQL_UPDATE = "UPDATE user SET username=?, password=? WHERE id_user=?";
    private static final String SQL_DELETE = "DELETE FROM user WHERE id_user=?";

    public List<User> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;
        List<User> users = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idUser = rs.getInt("id_user");
                String username = rs.getString("username");
                String password = rs.getString("password");

                user = new User(idUser, username, password);
                users.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return users;
    }

    public int insert(User user){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registers = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());;
            registers = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registers;
    }

    public int update(User user){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registers = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());;
            stmt.setInt(3, user.getIdUser());
            registers = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registers;
    }

    public int delete(User user){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registers = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, user.getIdUser());
            registers = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registers;
    }

    //End of the class
}
