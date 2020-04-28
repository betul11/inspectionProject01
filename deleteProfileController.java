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

//github linki: https://github.com/betul11/inspectionProject01


public class deleteProfileController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField deleteEmailText;

    @FXML
    private JFXPasswordField deletePwdText;

    @FXML
    private JFXButton deleteDeleteButton;

    @FXML
    private JFXButton deleteCancelButton;
    private databaseHandler databaseHandler;

    @FXML
    void initialize() {
        databaseHandler = new databaseHandler();


        deleteCancelButton.setOnAction(event -> {
            showMainmenu();


        });

        deleteDeleteButton.setOnAction(event -> {
            String loginText = deleteEmailText.getText().trim();
            String loginpwd = deletePwdText.getText().trim();

            user user = new user();
            user.setEmail(deleteEmailText.getText());
            user.setPassword(deletePwdText.getText());
            ResultSet userRow = databaseHandler.getUser(user);
            int counter = 0;

            try{
                while (userRow.next()){
                    counter++;
                }
                if(counter==1){
                    deleteAccount();
                    showLoginScreen();

                }else{
                    shaker emailShaker = new shaker(deleteEmailText);
                    shaker pwdShaker = new shaker(deletePwdText);
                    emailShaker.shake();
                    pwdShaker.shake();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }


        });

    }

    public void deleteAccount() {
        databaseHandler databaseHandler = new databaseHandler();
        user oldUser = new user(deleteEmailText.getText(),deletePwdText.getText());
         databaseHandler.deleteUser(oldUser);

    }

    private void showMainmenu(){
        //take user to main menu screen
        deleteCancelButton.getScene().getWindow().hide();
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
    private void showLoginScreen(){

        //take user to login screen
        deleteDeleteButton.getScene().getWindow().hide();
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
