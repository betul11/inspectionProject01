package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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

    @FXML
    void initialize() {
        String loginText = loginEmailTextfield.getText().trim();
        String loginpwd = loginPasswordField.getText().trim();
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
        loginLoginButton.setOnAction(event -> {
            if(!loginpwd.equals("") || !loginText.equals("")) {
                loginUser(loginText,loginpwd);
            }else {
                System.out.println("error login");
            }
        });

    }

    private void loginUser(String email, String password) {
    }
}
