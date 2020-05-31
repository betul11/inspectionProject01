package sample.database;

import sample.model.customer;
import sample.model.equipment;
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

    //write
    public void signupUser(user user){



     String insert = "INSERT INTO "+Const.USERS_TABLE+"("+Const.USERS_FIRSTNAME+","
              +Const.USERS_LASTNAME+","+Const.USERS_EMAIL+","+Const.USERS_DOB
              +","+Const.USERS_CERTIFICATE+",level)"+"VALUES(?,?,?,?,?,?)";


        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);

            preparedStatement.setString(1,user.getFirstName());
            preparedStatement.setString(2,user.getLastName());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.setString(4,user.getDOB());
            preparedStatement.setString(5,user.getCertificateExpiration());
            preparedStatement.setString(6,user.getLevel());


                preparedStatement.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


    //update
    public void updateRow (user oldUser){




        try {
            String updateString = "UPDATE users SET firstname = ?, lastname = ?, DOB = ?,certificateExpiration = ?,level= ?" +
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
            preparedStatement.setString(5,oldUser.getLevel());
            preparedStatement.setString(6,oldUser.getEmail());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addCustomer(customer customer){

        String insert = "INSERT INTO customer (companyName, address) VALUES(?,?)";


        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);

            preparedStatement.setString(1,customer.getCompanyName());
            preparedStatement.setString(2,customer.getAddress());


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
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

    public void addJobNo(customer customer) {
        String insert = "INSERT INTO orderno (orderNo,company) VALUES(?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);

            preparedStatement.setString(1,customer.getOrderNo());
            preparedStatement.setString(2,customer.getCompanyName());



            preparedStatement.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }

    public void addOffer(customer customer) {
        String insert = "INSERT INTO offerno (offerNo,company) VALUES(?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);

            preparedStatement.setString(1,customer.getOfferNo());
            preparedStatement.setString(2,customer.getCompanyName());



            preparedStatement.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }

    public ResultSet getAllUsers() throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM "+ Const.USERS_TABLE;
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

         return resultSet;


    }

    public void addEquipment(equipment equipment) {
        String insert = "INSERT INTO equipment (equipment,poleDistance,carrierMedium,magTech,lightIntensity,lightDistance) VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);

            preparedStatement.setString(1,equipment.getEquipment());
            preparedStatement.setString(2,equipment.getPoleDistance());
            preparedStatement.setString(3,equipment.getCarrierMedium());
            preparedStatement.setString(4,equipment.getMagTech());
            preparedStatement.setString(5,equipment.getLightIntensity());
            preparedStatement.setString(6,equipment.getLightDistance());



            preparedStatement.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

