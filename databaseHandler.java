package sample.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.model.*;

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

    public void addJobNo(jobOrder jobOrder) {
        String insert = "INSERT INTO orderno (orderNo,company) VALUES(?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);

            preparedStatement.setString(1,jobOrder.getJobOrderNo());
            preparedStatement.setString(2,jobOrder.getCompanyName());



            preparedStatement.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }

    public void addOffer(offerNo offerNo) {
        String insert = "INSERT INTO offerno (offerNo,company) VALUES(?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);

            preparedStatement.setString(1, offerNo.getOfferNo());
            preparedStatement.setString(2,offerNo.getCompanyName());



            preparedStatement.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }

    public ObservableList<user> getAllOperators() throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM "+ Const.USERS_TABLE+ " WHERE level = 1 OR level = 2";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        ObservableList<user> operators = FXCollections.observableArrayList();
        while(resultSet.next()){
            operators.add(new user(
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7)
            ));
        }

         return operators;
    }
    public ObservableList<user> getAllConfirmers() throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM "+ Const.USERS_TABLE + " WHERE level = 3";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        ObservableList<user> confirmers = FXCollections.observableArrayList();
        while(resultSet.next()){
            confirmers.add(new user(
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7)
            ));
        }

        return confirmers;
    }

    public ObservableList<equipment> getAllEquipments() throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM equipment ";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        ObservableList<equipment> equipments = FXCollections.observableArrayList();
        while(resultSet.next()){
            equipments.add(new equipment(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            ));
        }

        return equipments;
    }

    public ObservableList<customer> getAllCustomers() throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM customer ";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        ObservableList<customer> customers = FXCollections.observableArrayList();
        while(resultSet.next()){

            customers.add(new customer(
                    resultSet.getString("companyName"),
                    resultSet.getString("address")

            ));
        }

        return customers;
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

    public ObservableList<jobOrder> getJobOrders(String companyName) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM orderno WHERE company = ? ";

        PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
        preparedStatement.setString(1,companyName);

        ResultSet resultSet = preparedStatement.executeQuery();

        ObservableList<jobOrder> jobOrders = FXCollections.observableArrayList();
        while(resultSet.next()){

            jobOrders.add(new jobOrder(
                    resultSet.getString("company"),
                    resultSet.getString("orderNo")

            ));
        }

        return jobOrders;



    }

    public ObservableList<offerNo> getOfferNos(String companyName) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM offerno WHERE company = ? ";

        PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
        preparedStatement.setString(1,companyName);

        ResultSet resultSet = preparedStatement.executeQuery();

        ObservableList<offerNo> offerNos = FXCollections.observableArrayList();
        while(resultSet.next()){

            offerNos.add(new offerNo(
                    resultSet.getString("company"),
                    resultSet.getString("offerno")

            ));
        }

        return offerNos;



    }

    public void addSurfaceCondition(String surfaceCondition) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO surfacecondition (surfacecondition) VALUES(?)";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
        preparedStatement.setString(1,surfaceCondition);
        preparedStatement.executeUpdate();


    }

    public void addExaminationStage(String examinationStage) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO examinationstage (examinationstage) VALUES(?)";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
        preparedStatement.setString(1,examinationStage);
        preparedStatement.executeUpdate();

    }

    public ObservableList<String> getSurfaceConditions() throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM surfacecondition ";

        PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        ObservableList<String> surfaceConditions = FXCollections.observableArrayList();
        while(resultSet.next()){
            surfaceConditions.add(resultSet.getString("surfacecondition"));


        }

        return surfaceConditions;


    }

    public ObservableList<String> getExaminationStages() throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM examinationstage ";

        PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        ObservableList<String> examinationStages = FXCollections.observableArrayList();
        while(resultSet.next()){
            examinationStages.add(resultSet.getString("examinationstage"));


        }

        return examinationStages;
    }


    public int getNvalue() throws SQLException, ClassNotFoundException {
      String query = "SELECT * FROM counter ORDER BY counter DESC LIMIT 1";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        int n = resultSet.getInt("counter");
        return n;


    }

    public void setNvalue(int n) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO counter (counter) VALUES (?)";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
        preparedStatement.setInt(1,n);
        preparedStatement.executeUpdate();


    }
}

