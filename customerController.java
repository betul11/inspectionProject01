package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.database.databaseHandler;
import sample.model.customer;
import sample.model.user;

public class customerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField customerNameText;

    @FXML
    private JFXTextField customerAddressText;

    @FXML
    private JFXButton customerSaveButton;

    @FXML
    private JFXButton customerCancelButton;

    @FXML
    private JFXTextField customerJobOrderText;

    @FXML
    private JFXTextField customerOfferText;

    @FXML
    private JFXButton customerAddJobButton;

    @FXML
    private JFXButton customerAddOfferButton;

    @FXML
    void initialize() {
        customerCancelButton.setOnAction(event -> {
            showMainmenu();
        });

        customerSaveButton.setOnAction(event -> {
            addCustomer();


        });

        customerAddJobButton.setOnAction(event -> {
            addJobNo();


        });

        customerAddOfferButton.setOnAction(event -> {
            addOffer();


        });


    }

   void addJobNo(){
       databaseHandler databaseHandler = new databaseHandler();
       customer customer = new customer(customerJobOrderText.getText());
       databaseHandler.addJobNo(customer);


    }

    void addOffer(){
        databaseHandler databaseHandler = new databaseHandler();
        customer customer = new customer(customerOfferText.getText());
        databaseHandler.addOffer(customer);


    }

   void addCustomer(){
       databaseHandler databaseHandler = new databaseHandler();

       customer customer = new customer(customerNameText.getText(), customerAddressText.getText());

       databaseHandler.addCustomer(customer);

       showMainmenu();

   }











    private void showMainmenu(){
        //take user to main menu screen
        customerCancelButton.getScene().getWindow().hide();
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