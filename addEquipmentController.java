package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import sample.database.databaseHandler;
import sample.model.equipment;

public class addEquipmentController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField equipmentNameText;

    @FXML
    private JFXTextField equipmentPoleDistanceText;

    @FXML
    private JFXTextField equipmentLightDistanceText;

    @FXML
    private JFXButton equipmentSaveButton;

    @FXML
    private JFXTextField equipmentCarrierMediumText;

    @FXML
    private JFXButton equipmentCancelButton;

    @FXML
    private JFXTextField equipmentMagTechText;

    @FXML
    private JFXTextField equipmentLightIntensityText;

    @FXML
    void initialize() {
       equipmentCancelButton.setOnAction(event -> {
           showMainMenu();

       });
       equipmentSaveButton.setOnAction(event -> {
           addEquipment();
       });

    }


    private void showMainMenu(){

        equipmentCancelButton.getScene().getWindow().hide();
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

    public void addEquipment(){
        if(equipmentNameText.getText().isEmpty()
        || equipmentCarrierMediumText.getText().isEmpty()
        || equipmentLightDistanceText.getText().isEmpty()
        || equipmentMagTechText.getText().isEmpty()
        || equipmentLightIntensityText.getText().isEmpty()
        || equipmentPoleDistanceText.getText().isEmpty()){

            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("Please fill all the required fields !");
            errorAlert.showAndWait();
            return;
        }


        databaseHandler databaseHandler = new databaseHandler();
        equipment equipment = new equipment(equipmentNameText.getText(), equipmentPoleDistanceText.getText(),
                equipmentLightIntensityText.getText(),equipmentCarrierMediumText.getText(),equipmentLightDistanceText.getText(), equipmentMagTechText.getText());
        databaseHandler.addEquipment(equipment);
        showMainMenu();

    }
}
