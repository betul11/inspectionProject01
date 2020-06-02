package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.InputMethodEvent;
import javafx.stage.Stage;
import sample.database.databaseHandler;
import sample.model.*;

public class reportController {

    @FXML
    private JFXTextField operatorNameText;
    @FXML
    private JFXComboBox<customer> customerNameCombo;

    @FXML
    private JFXComboBox<jobOrder> jobOrderCombo;

    @FXML
    private JFXTextField inspectionPlaceText;

    @FXML
    private JFXTextField inspectionStandardText;

    @FXML
    private JFXTextField evaluationStandardText;

    @FXML
    private JFXTextField inspectionProcedureText;

    @FXML
    private JFXTextField inspectionScopeText;

    @FXML
    private JFXTextField drawingNoText;

    @FXML
    private JFXComboBox<String> surfaceConditionCombo;

    @FXML
    private JFXComboBox<String> examinationStageCombo;

    @FXML
    private JFXTextField pageText;

    @FXML
    private JFXTextField reportNoText;

    @FXML
    private JFXTextField reportDateText;

    @FXML
    private JFXComboBox<offerNo> offerNoCombo;

    @FXML
    private JFXTextField poleDistanceText;

    @FXML
    private JFXTextField equipmentText;

    @FXML
    private JFXTextField mpCarrierMediumText;

    @FXML
    private JFXTextField magTechText;

    @FXML
    private JFXTextField lightIntensityText;

    @FXML
    private JFXTextField lightDistanceText;

    @FXML
    private JFXTextField examinationAreaText;

    @FXML
    private JFXComboBox<?> currentTypeCombo;

    @FXML
    private JFXTextField luxmeterText;

    @FXML
    private JFXTextField testMediumText;

    @FXML
    private JFXTextField demagnetizationText;

    @FXML
    private JFXTextField heatTreatmentText;

    @FXML
    private JFXTextField surfaceTemperatureText;

    @FXML
    private JFXTextField gaussFieldText;

    @FXML
    private JFXTextField idOfLightEquipText;

    @FXML
    private JFXTextField standardDeviationText;

    @FXML
    private JFXTextField inspectionDatesText;

    @FXML
    private JFXTextField descriptionText;

    @FXML
    private JFXTextField weldText1;

    @FXML
    private JFXTextField weldText2;

    @FXML
    private JFXTextField weldText3;

    @FXML
    private JFXTextField weldText4;

    @FXML
    private JFXTextField weldText5;


    @FXML
    private JFXTextField testLengthText1;

    @FXML
    private JFXTextField weldingProcessText1;

    @FXML
    private JFXTextField thicknessText1;

    @FXML
    private JFXTextField diameterText1;

    @FXML
    private JFXTextField defectType1;

    @FXML
    private JFXTextField defectLocationText1;

    @FXML
    private JFXTextField testLengthText2;

    @FXML
    private JFXTextField weldingProcessText2;

    @FXML
    private JFXTextField thicknessText2;

    @FXML
    private JFXTextField diameterText2;

    @FXML
    private JFXTextField defectType2;

    @FXML
    private JFXTextField defectLocationText2;

    @FXML
    private JFXTextField testLengthText3;

    @FXML
    private JFXTextField weldingProcessText3;

    @FXML
    private JFXTextField thicknessText3;

    @FXML
    private JFXTextField diameterText3;

    @FXML
    private JFXTextField defectType3;

    @FXML
    private JFXTextField defectLocationText3;

    @FXML
    private JFXTextField testLengthText4;

    @FXML
    private JFXTextField weldingProcessText4;

    @FXML
    private JFXTextField thicknessText4;

    @FXML
    private JFXTextField diameterText4;

    @FXML
    private JFXTextField defectType4;

    @FXML
    private JFXTextField defectLocationText4;

    @FXML
    private JFXTextField testLengthText5;

    @FXML
    private JFXTextField weldingProcessText5;

    @FXML
    private JFXTextField thicknessText5;

    @FXML
    private JFXTextField diameterText5;

    @FXML
    private JFXTextField defectType5;

    @FXML
    private JFXTextField defectLocationText5;



    @FXML
    private JFXTextField liftingTestDateText;

     @FXML
    private JFXTextField operatorLevelText;

    @FXML
    private JFXTextField operatorDateText;

    @FXML
    private JFXTextField evaluatorNameText;

    @FXML
    private JFXTextField evaluatorLevelText;

    @FXML
    private JFXTextField evaluatorDateText;

    @FXML
    private JFXTextField confirmerNameText;

    @FXML
    private JFXTextField confirmerLevelText;

    @FXML
    private JFXTextField confirmerDateText;

    @FXML
    private JFXTextField customerNameSurnameText;

    @FXML
    private JFXTextField customerDateText;

    @FXML
    private JFXTextField projectNameText;

    @FXML
    private JFXComboBox<String> resultCombo1;

    @FXML
    private JFXComboBox<String> resultCombo2;

    @FXML
    private JFXComboBox<String> resultCombo3;

    @FXML
    private JFXComboBox<String> resultCombo4;

    @FXML
    private JFXComboBox<String> resultCombo5;

    @FXML
    private JFXButton goBackButton;



    private user selectedOperator;
    private user selectedEvaluator;
    private user selectedConfirmation;
    private customer selectedCustomer;
    private equipment selectedEquipment;
    private String inspectionDates;
    private sample.database.databaseHandler db;


    public String getInspectionDates() {
        return inspectionDates;
    }

    public void setInspectionDates(String inspectionDates) {
        this.inspectionDates = inspectionDates;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    private String reportDate;

    public void fillReport() throws SQLException, ClassNotFoundException {
        operatorNameText.setText(selectedOperator.getFirstName()+" "+selectedOperator.getLastName());
        operatorLevelText.setText(selectedOperator.getLevel());
        operatorDateText.setText(reportDate);
        evaluatorNameText.setText(selectedEvaluator.getFirstName()+" "+selectedEvaluator.getLastName());
        evaluatorLevelText.setText(selectedEvaluator.getLevel());
        evaluatorDateText.setText(reportDate);
        confirmerNameText.setText(selectedConfirmation.getFirstName()+" "+selectedConfirmation.getLastName());
        confirmerLevelText.setText(selectedConfirmation.getLevel());
        confirmerDateText.setText(reportDate);
        equipmentText.setText(selectedEquipment.getEquipment());
        poleDistanceText.setText(selectedEquipment.getPoleDistance());
        mpCarrierMediumText.setText(selectedEquipment.getCarrierMedium());
        magTechText.setText(selectedEquipment.getMagTech());
        lightIntensityText.setText(selectedEquipment.getLightIntensity());
        lightDistanceText.setText(selectedEquipment.getLightDistance());
        inspectionDatesText.setText(inspectionDates);
        reportDateText.setText(reportDate);


    }

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        db = new databaseHandler();


       ObservableList<String> results=FXCollections.observableArrayList();
        results.add("OK");
        results.add("RED");
        resultCombo1.setItems(results);
        resultCombo2.setItems(results);
        resultCombo3.setItems(results);
        resultCombo3.setItems(results);
        resultCombo4.setItems(results);
        resultCombo5.setItems(results);

        ObservableList<customer> customers = db.getAllCustomers();
        customerNameCombo.setItems(customers);

        ObservableList<String> surfaceConditions = db.getSurfaceConditions();
        surfaceConditionCombo.setItems(surfaceConditions);

        ObservableList<String> examinationStages = db.getExaminationStages();
        examinationStageCombo.setItems(examinationStages);




    }

    public void customerComboOnAction() throws SQLException, ClassNotFoundException {



    }

    public user getSelectedOperator() {
        return selectedOperator;
    }

    public void setSelectedOperator(user selectedOperator) {
        this.selectedOperator = selectedOperator;
    }

    public user getSelectedEvaluator() {
        return selectedEvaluator;
    }

    public void setSelectedEvaluator(user selectedEvaluator) {
        this.selectedEvaluator = selectedEvaluator;
    }

    public user getSelectedConfirmation() {
        return selectedConfirmation;
    }

    public void setSelectedConfirmation(user selectedConfirmation) {
        this.selectedConfirmation = selectedConfirmation;
    }

    public customer getSelectedCustomer() {
        return selectedCustomer;
    }

    public void setSelectedCustomer(customer selectedCustomer) {
        this.selectedCustomer = selectedCustomer;
    }

    public equipment getSelectedEquipment() {
        return selectedEquipment;
    }

    public void setSelectedEquipment(equipment selectedEquipment) {
        this.selectedEquipment = selectedEquipment;
    }

    public void customerComboInput(InputMethodEvent inputMethodEvent) throws SQLException, ClassNotFoundException {





    }

    public void jobOrderOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if(!customerNameCombo.getSelectionModel().isEmpty()){
            databaseHandler db = new databaseHandler();
            customer combo = customerNameCombo.getValue();
            ObservableList<jobOrder> jobOrders = db.getJobOrders(combo.getCompanyName());
            jobOrderCombo.setItems(jobOrders);
            ObservableList<offerNo> offerNos = db.getOfferNos(combo.getCompanyName());
            offerNoCombo.setItems(offerNos);

        }
    }


    public void goBackOnAction(ActionEvent actionEvent) {

        goBackButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/view/picker.fxml"));
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

    public void convertEXCELonAction(ActionEvent actionEvent) {


    }

    public void convertPDFonAction(ActionEvent actionEvent) {
    }
}
