package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
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


        });
    }

    private void createUser(){
        databaseHandler databaseHandler = new databaseHandler();
        user user = new user(signupFirstnameText.getText(),signupLastnameText.getText(),signupEmailText.getText(),
                signupPasswordText.getText(),signupDOBdatepicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),signupCertificateDatePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
         databaseHandler.signupUser(user);

    }



}
