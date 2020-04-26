package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.Vector;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.database.databaseHandler;
import sample.model.user;

public class signupController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField signupFirstnameText;

    @FXML
    private JFXTextField signupEmailText;

    @FXML
    private JFXTextField signupLastnameText;

    @FXML
    private JFXDatePicker signupDOBdatepicker;

    @FXML
    private JFXDatePicker signupCertificateDatePicker;

    @FXML
    private JFXPasswordField signupPasswordText;

    @FXML
    private JFXButton signupSignupButton;

    @FXML
    void initialize() {
        signupSignupButton.setOnAction(event -> {
            createUser();
            showLoginScreen();


        });
    }



    private void createUser(){
        databaseHandler databaseHandler = new databaseHandler();

         user user = new user(signupFirstnameText.getText(), signupLastnameText.getText(), signupEmailText.getText(),
                    signupPasswordText.getText(), signupDOBdatepicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), signupCertificateDatePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

         databaseHandler.signupUser(user);




    }

    private void showLoginScreen(){

            //take user to login screen
            signupSignupButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/login.fxml"));
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
