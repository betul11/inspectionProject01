package sample.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class databaseHandler extends configs {
  Connection dbConnection;
  public Connection getDbConnection() throws ClassNotFoundException, SQLException {


      String connectionString = "jdbc:mysql://"+ dbHost+":"
              + dbPort +"/inspection?verifyServerCertificate=false&useSSL=true";
      Class.forName("com.mysql.jdbc.Driver");

      dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);
      return dbConnection;
  }

    //write
    public void signupUser(String firstname, String lastname, String email, String password, String DOB, String CertExp){
     String insert = "INSERT INTO "+Const.USERS_TABLE+"("+Const.USERS_FIRSTNAME+","
              +Const.USERS_LASTNAME+","+Const.USERS_EMAIL+","+Const.USERS_PASSWORD+","+Const.USERS_DOB
              +","+Const.USERS_CERTIFICATE+")"+"VALUES(?,?,?,?,?,?)";




        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);

            preparedStatement.setString(1,firstname);
            preparedStatement.setString(2,lastname);
            preparedStatement.setString(3,email);
            preparedStatement.setString(4,password);
            preparedStatement.setString(5,DOB);
            preparedStatement.setString(6,CertExp);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //read


}
