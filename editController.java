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
    private JFXPasswordField editCurrentPasswordText;

    @FXML
    private JFXPasswordField editNewPasswordText;
    @FXML
    private JFXButton editCancelButton;

    @FXML
    private JFXButton editSaveButton;
    private sample.database.databaseHandler databaseHandler;


    @FXML
    void initialize() {
        user user = new user();

        databaseHandler = new databaseHandler();
        editSaveButton.setOnAction(event -> {
            user.setEmail(editEmailText.getText());
            user.setPassword(editCurrentPasswordText.getText());
            ResultSet userRow = databaseHandler.getUser(user);

            int counter = 0;

            try{
                while (userRow.next()){
                    counter++;
                }
                if(counter==1){
                    updateProfile1();
                }else{
                    shaker emailShaker = new shaker(editEmailText);
                    shaker pwdShaker = new shaker(editCurrentPasswordText);
                    emailShaker.shake();
                    pwdShaker.shake();

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
        user oldUser = new user(editFirstnameText.getText(),editLastnameText.getText(),editEmailText.getText(),
                editNewPasswordText.getText(),editDOBText.getText(),editCertificateText.getText());
        databaseHandler.updateRow(oldUser);


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