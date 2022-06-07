package test;

import java.sql.*;

public class TestMySqlJDBC {
    public static void main(String[] args) {
        var url = "jdbc:mysql://localhost:3306/testudemy?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
           // Class.forName("com.mysql.cj.jdbc.Driver"); //For Web Apps the most
            Connection connection = DriverManager.getConnection(url,"root", "programmingNow#");
            Statement instruction = connection.createStatement();
            var sql = "SELECT id_person, name, lastname, email, telephone FROM person";
            ResultSet resultSet = instruction.executeQuery(sql);
            while (resultSet.next()){
                System.out.print("Id Person: " + resultSet.getInt("id_person"));
                System.out.print("Name: " + resultSet.getString("name"));
                System.out.print("Lastname: " + resultSet.getString("lastname"));
                System.out.print("Email: " + resultSet.getString("email"));
                System.out.print("Telephone: " + resultSet.getString("telephone"));
                System.out.println("");

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }
}
