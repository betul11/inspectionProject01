package sample.database;

import sample.model.user;

import java.sql.*;

//github linki: https://github.com/betul11/inspectionProject01
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
    public void signupUser(user user){



     String insert = "INSERT INTO "+Const.USERS_TABLE+"("+Const.USERS_FIRSTNAME+","
              +Const.USERS_LASTNAME+","+Const.USERS_EMAIL+","+Const.USERS_DOB
              +","+Const.USERS_CERTIFICATE+")"+"VALUES(?,?,?,?,?)";




        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);

            preparedStatement.setString(1,user.getFirstName());
            preparedStatement.setString(2,user.getLastName());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.setString(4,user.getDOB());
            preparedStatement.setString(5,user.getCertificateExpiration());


                preparedStatement.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public ResultSet getUser (user user){
      ResultSet resultSet = null;
      if(!user.getEmail().equals("")){
      String query = "SELECT * FROM "+ Const.USERS_TABLE+ " WHERE "+ Const.USERS_EMAIL+ "=?";
          try {
              PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
              preparedStatement.setString(1, user.getEmail());

              resultSet = preparedStatement.executeQuery();



          } catch (SQLException throwables) {
              throwables.printStackTrace();
          } catch (ClassNotFoundException e) {
              e.printStackTrace();
          }

      }else{
          System.out.println("Please enter your correct login information!");
      }

      return resultSet;
    }

  /* public int checkIfExists (user user) throws SQLException, ClassNotFoundException {

    String checker = ("SELECT * FROM users WHERE email =? ");
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(checker);

        preparedStatement.setString(1,user.getEmail());
        String b = preparedStatement.executeQuery();



      return b;


    }*/




    //update
    public void updateRow (user oldUser){




        try {
            String updateString = "UPDATE users SET firstname = ?, lastname = ?, DOB = ?,certificateExpiration = ?" +
                    " WHERE email = ?";

            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = getDbConnection().prepareStatement(updateString);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            preparedStatement.setString(1,oldUser.getFirstName());
            preparedStatement.setString(2,oldUser.getLastName());
            preparedStatement.setString(3,oldUser.getDOB());
            preparedStatement.setString(4,oldUser.getCertificateExpiration());
            preparedStatement.setString(5,oldUser.getEmail());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }








    public void deleteUser(user oldUser) {
        try {
            String query = "DELETE FROM users WHERE email = ?";
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = getDbConnection().prepareStatement(query);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


            preparedStatement.setString(1,oldUser.getEmail());

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
}
