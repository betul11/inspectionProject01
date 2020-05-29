package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.Vector;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.animations.shaker;
import sample.database.databaseHandler;
import sample.model.user;
//github linki: https://github.com/betul11/inspectionProject01


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
    private JFXTextField signupLevelText;

    @FXML
    private JFXButton signupSaveButton;

    @FXML
    private JFXButton signupCancelButton;

    @FXML
    void initialize() {
        signupSaveButton.setOnAction(event -> {
            createUser();


        });

        signupCancelButton.setOnAction(event -> {
            showMainMenu();


        });
    }



    private void createUser(){
        databaseHandler databaseHandler = new databaseHandler();

         user user = new user(signupFirstnameText.getText(), signupLastnameText.getText(), signupEmailText.getText(), signupDOBdatepicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                 signupCertificateDatePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),signupLevelText.getText());

        databaseHandler.signupUser(user);
        
        showMainMenu();


    }

    private void showMainMenu(){

            signupSaveButton.getScene().getWindow().hide();
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
