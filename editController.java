package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.animations.shaker;
import sample.database.databaseHandler;
import sample.model.user;

//github linki: https://github.com/betul11/inspectionProject01


public class editController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField editFirstnameText;

    @FXML
    private JFXTextField editEmailText;

    @FXML
    private JFXTextField editLastnameText;

    @FXML
    private JFXTextField editCertificateText;
    @FXML
    private JFXTextField editDOBText;

    @FXML
    private JFXButton editCancelButton;

    @FXML
    private JFXButton editSaveButton;

    @FXML
    private JFXTextField editLevelText;



    @FXML
    private JFXButton editSearchButton;
    private sample.database.databaseHandler databaseHandler;
    int counter;
    ResultSet userRow;

    @FXML
    void initialize() {
        user user = new user();


        databaseHandler = new databaseHandler();
        editSearchButton.setOnAction(event -> {
            if(editEmailText.getText().isEmpty()){
                editEmailText.setStyle("-fx-border-color: red ; -fx-border-width: 1px ; ");
                editEmailText.setPromptText("Email was not found!");
                shaker emailShaker = new shaker(editEmailText);
                emailShaker.shake();
            }else {
                user.setEmail(editEmailText.getText());
                userRow = databaseHandler.getUser(user);

                counter = 0;

                try {
                    while (userRow.next()) {
                        counter++;
                        String firstname = userRow.getString("firstname");
                        String lastname = userRow.getString("lastname");
                        String DOB = userRow.getString("DOB");
                        String Certificate = userRow.getString("certificateExpiration");
                        String level = userRow.getString("level");
                        editFirstnameText.setText(firstname);
                        editLastnameText.setText(lastname);
                        editDOBText.setText(DOB);
                        editCertificateText.setText(Certificate);
                        editLevelText.setText(level);
                    }
                    if (counter == 1) {
                        wait();
                    } else {

                        editEmailText.setStyle("-fx-border-color: red ; -fx-border-width: 1px ; ");
                        editEmailText.setPromptText("Email was not found!");
                        shaker emailShaker = new shaker(editEmailText);
                        emailShaker.shake();

                    }
                } catch (SQLException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
    });



        editSaveButton.setOnAction(event -> {

            try{

                if(counter==1){
                    updateProfile1();
                }else{

                    shaker emailShaker = new shaker(editEmailText);
                    emailShaker.shake();
                    editEmailText.setText("");


                }
            } catch (SQLException e){
                e.printStackTrace();
            }

        });


        editCancelButton.setOnAction(event -> {
            showMainmenu();
        });


}

    public void updateProfile1() throws SQLException {
        databaseHandler databaseHandler = new databaseHandler();
        user oldUser = new user(editFirstnameText.getText(),editLastnameText.getText(),editEmailText.getText(),editDOBText.getText(),editCertificateText.getText(),
                editLevelText.getText());
        databaseHandler.updateRow(oldUser);
        showMainmenu();


    }

    private void showMainmenu(){
        //take user to main menu screen
        editCancelButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/view/menu.fxml"));
        try{
            loader.load();
        }catch (IOException e){
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

    }






}