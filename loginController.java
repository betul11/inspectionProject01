package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.animations.shaker;
import sample.database.databaseHandler;
import sample.model.user;

public class loginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton loginSignupButton;

    @FXML
    private JFXTextField loginEmailTextfield;

    @FXML
    private JFXPasswordField loginPasswordField;

    @FXML
    private JFXButton loginLoginButton;

    private sample.database.databaseHandler databaseHandler;

    @FXML
    void initialize() {
        databaseHandler = new databaseHandler();

        loginLoginButton.setOnAction(event -> {
            String loginText = loginEmailTextfield.getText().trim();
            String loginpwd = loginPasswordField.getText().trim();

            user user = new user();
            user.setEmail(loginEmailTextfield.getText());
            user.setPassword(loginPasswordField.getText());
            ResultSet userRow = databaseHandler.getUser(user);
            int counter = 0;

            try{
                while (userRow.next()){
                    counter++;
                }
                if(counter==1){
                    showMainmenu();
                }else{
                    shaker emailShaker = new shaker(loginEmailTextfield);
                    shaker pwdShaker = new shaker(loginPasswordField);
                    emailShaker.shake();
                    pwdShaker.shake();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }


        });

        loginSignupButton.setOnAction(event -> {
            //take user to signup screen
            loginSignupButton.getScene().getWindow().hide();
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
            stage.showAndWait();
        });


    }

     private void showMainmenu(){
         //take user to main menu screen
         loginLoginButton.getScene().getWindow().hide();
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
         stage.showAndWait();

     }
}
