package datos;

import domain.Person;

import java.sql.*;
import java.util.*;
import static datos.Conexion.*;

public class PersonDAO {
    private static final String SQL_SELECT = "SELECT id_person, name, lastname, email, telephone FROM person";
    private static final String SQL_INSERT = "INSERT INTO person(name, lastname, email, telephone)VALUE(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE person SET name=?, lastname=?, email=?, telephone=? WHERE id_person=?";
    private static final String SQL_DELETE = "DELETE FROM person WHERE id_person=?";

    public List<Person> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Person person = null;
        List<Person> persons = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPerson = rs.getInt("id_person");
                String name = rs.getString("name");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String telephone = rs.getString("telephone");

                person = new Person(idPerson, name, lastname, email, telephone);
                persons.add(person);
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

        return persons;
    }

    public int insert(Person person){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registers = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, person.getName());
            stmt.setString(2, person.getLastname());
            stmt.setString(3, person.getEmail());
            stmt.setString(4, person.getTelephone());
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

    public int update(Person person){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registers = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, person.getName());
            stmt.setString(2, person.getLastname());
            stmt.setString(3, person.getEmail());
            stmt.setString(4, person.getTelephone());
            stmt.setInt(5, person.getIdPerson());
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

    public int delete(Person person){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registers = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, person.getIdPerson());
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
