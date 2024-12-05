import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/biblioteka",
                    "root",
                    "7296"
            );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Ksiazki");
            while (resultSet.next()){
                System.out.println(resultSet.getString("tytul"));
                System.out.println(resultSet.getString("autor"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}