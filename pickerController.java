package sample.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.database.databaseHandler;
import sample.model.equipment;
import sample.model.user;

import static javax.swing.UIManager.getString;

public class pickerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXComboBox<user> pickerEvaluator;

    @FXML
    private JFXComboBox<user> pickerOperator;

    @FXML
    private JFXComboBox<user> pickerConfirmer;

    @FXML
    private JFXButton createReportButton;


    @FXML
    private JFXComboBox<equipment> pickerEquipment;

    @FXML
    private JFXDatePicker pickerReportDate;

    @FXML
    private JFXTextField pickerInspectionDatesText;

    @FXML
    private JFXButton pickerCancelButton;

    @FXML
    private JFXTextField surfaceConditionText;

    @FXML
    private JFXTextField examinationStageText;

    @FXML
    private JFXButton pickerAddSurfaceCondition;

    @FXML
    private JFXButton pickerAddExaminationStage;

   private databaseHandler db;

    private sample.database.databaseHandler databaseHandler;


    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        db = new databaseHandler();
        ObservableList<user> operators = db.getAllOperators();
        pickerOperator.setItems(operators);
        ObservableList<user> evaluators = db.getAllOperators();
        pickerEvaluator.setItems(evaluators);
        ObservableList<user> confirmers = db.getAllConfirmers();
        pickerConfirmer.setItems(confirmers);
        ObservableList<equipment> equipments = db.getAllEquipments();
        pickerEquipment.setItems(equipments);


    }
    @FXML
    void operatorOnAction(ActionEvent event) {
        System.out.println(pickerOperator.getValue());
        user operator = pickerOperator.getValue();
        System.out.println(operator.getEmail());
    }

    @FXML
    void evaluatorOnAction(ActionEvent event) {
        System.out.println(pickerEvaluator.getValue());
        user evaluator = pickerEvaluator.getValue();
        System.out.println(evaluator.getEmail());
    }


    @FXML
    public void confirmerOnAction(ActionEvent actionEvent) {
        user confirmer = pickerConfirmer.getValue();

    }

    @FXML
    void reportButtonOnAction(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/view/report.fxml"));
        Parent root = fxmlLoader.load();
        reportController reportController = fxmlLoader.getController() ;


        reportController.setSelectedOperator(pickerOperator.getValue());
        reportController.setSelectedConfirmation(pickerConfirmer.getValue());
        reportController.setSelectedEvaluator(pickerEvaluator.getValue());
        reportController.setSelectedEquipment(pickerEquipment.getValue());
        reportController.setReportDate(pickerReportDate.getValue().toString());
        reportController.setInspectionDates(pickerInspectionDatesText.getText());


        reportController.fillReport();


        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.sizeToScene();
        stage.show();
    }


    public void inspectionDatesOnAction(ActionEvent actionEvent) {
    }

    public void reportDateOnAction(ActionEvent actionEvent) {
    }



    public void cancelButtonOnAction(ActionEvent actionEvent) {
        //take user to main menu screen
        pickerCancelButton.getScene().getWindow().hide();
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
        stage.sizeToScene();
        stage.show();
    }

    public void equipmentOnAction(ActionEvent actionEvent) {
    }

    public void surfaceConditionButtonOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if(!surfaceConditionText.getText().isEmpty()) {

            databaseHandler db = new databaseHandler();
            db.addSurfaceCondition(surfaceConditionText.getText());
            surfaceConditionText.setText("");
        }

    }

    public void examinationStageButtonOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if(!examinationStageText.getText().isEmpty()) {
            databaseHandler db = new databaseHandler();
            db.addExaminationStage(examinationStageText.getText());
            examinationStageText.setText("");
        }
    }
}



