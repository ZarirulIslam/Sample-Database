package sampledatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MySQLDatabase {
    
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet result = null;
    Scanner sc = null;

    void readData() {
        try {
            connect = ApiClient.getInstance();
            sc = new Scanner(System.in);
            //statement = connect.createStatement();
            // result = statement.executeQuery("SELECT * FROM blood_donation.donor");

            preparedStatement = connect.prepareStatement("SELECT name,age,gender FROM donor_info WHERE blood_group = ?;");

            preparedStatement.setString(1, sc.nextLine());
            result = preparedStatement.executeQuery();

            while (result.next()) {
                System.out.println("name: " + result.getString("name"));
                System.out.println("age: " + result.getString("age"));
                System.out.println("gender: " + result.getString("gender"));
            }

        } catch (ClassNotFoundException | SQLException e) {

        } finally {
            ApiClient.close();
        }

    }

}
