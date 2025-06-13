import java.sql.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/Airline"; // Replace with your database URL
        String user = "root"; // Replace with your database username
        String password = "0000"; // Replace with your database password
        String sql="select * from Passenger";
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection successful!");
            // Create a Statement object to execute the query
            Statement stmt = conn.createStatement();

            // Execute the query and retrieve the result set
            ResultSet rs = stmt.executeQuery(sql);

            // Process the result set
            System.out.println("Passenger Table:");
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String contactInfo = rs.getString("contactInfo");

                System.out.println("ID: " + id + ", Name: " + name + ", Contact Info: " + contactInfo);
            }
            
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
	}

}
