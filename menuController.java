package sample.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

public class menuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton menuAddReportButton;

    @FXML
    private JFXButton menuEditProfileButton;

    @FXML
    private JFXButton menuDeleteAccountButton;

    @FXML
    private JFXButton menuLogoutButton;

    @FXML
    void initialize() {
        assert menuAddReportButton != null : "fx:id=\"menuAddReportButton\" was not injected: check your FXML file 'menu.fxml'.";
        assert menuEditProfileButton != null : "fx:id=\"menuEditProfileButton\" was not injected: check your FXML file 'menu.fxml'.";
        assert menuDeleteAccountButton != null : "fx:id=\"menuDeleteAccountButton\" was not injected: check your FXML file 'menu.fxml'.";
        assert menuLogoutButton != null : "fx:id=\"menuLogoutButton\" was not injected: check your FXML file 'menu.fxml'.";

    }
}
