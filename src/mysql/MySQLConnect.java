package mysql;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnect {
    
    private String sendQuery;
    private String takeQuery;

    public MySQLConnect() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/deneme";
        String username = "root";
        String password = "123456";

        Connection connection = null;
        try {
            // JDBC sürücüsünü yükle

            Class.forName("com.mysql.cj.jdbc.Driver");

            // Veritabanına bağlantı oluştur
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            String insertQuery = "select * from new_table";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(insertQuery);
            
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
            
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
