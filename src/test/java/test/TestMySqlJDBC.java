package test;

import java.sql.*;

public class TestMySqlJDBC {
    public static void main(String[] args) {
        var url = "jdbc:mysql://localhost:3306/testudemy?SSL=false&useTimezone=true&serverTimeZone=UTC&allowPublicKeyRetrieval=true";
        try {
           // Class.forName("com.mysql.cj.jdbc.Driver"); //For Web Apps the most
            Connection connection = DriverManager.getConnection(url,"root", "programmingNow#");
            Statement instruction = connection.createStatement();
            var sql = "SELECT id_person, name, lastname, email, telephone FROM person";
            ResultSet resultSet = instruction.executeQuery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }
}