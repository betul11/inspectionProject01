package sample.controller;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class menuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton menuAddReportButton;

    @FXML
    private JFXButton menuEditEmployeeButton;

    @FXML
    private JFXButton menuAddEmployeeButton;

    @FXML
    private JFXButton menuDeleteEmployeeButton;

    @FXML
    private JFXButton menuLogoutButton;

    @FXML
    void initialize() {
        menuEditEmployeeButton.setOnAction(event -> {
            showEditProfile();

        });

        menuDeleteEmployeeButton.setOnAction(event -> {
            showDeleteScreen();
        });

        menuAddEmployeeButton.setOnAction(event -> {
            showSignUpScreen();
        });


    }
    private void showEditProfile(){
        //take user to main menu screen
        menuEditEmployeeButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/view/edit.fxml"));
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

    private void showDeleteScreen(){
        menuDeleteEmployeeButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/view/deleteProfile.fxml"));
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

    private void showSignUpScreen(){
        menuDeleteEmployeeButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/view/signup.fxml"));
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
