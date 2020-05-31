package sample.controller;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import sample.model.customer;
import sample.model.equipment;
import sample.model.user;

public class reportController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    private JFXTextField pageText;

    @FXML
    private JFXTextField reportNoText;

    @FXML
    private JFXTextField reportDateText;

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
    private JFXTextField weldText6;

    @FXML
    private JFXTextField operatorNameText;

    @FXML
    private JFXTextField operatorLevelText;

    @FXML
    private JFXTextField evaluateNameText;

    @FXML
    private JFXTextField evaluateLevelText;

    @FXML
    private JFXTextField confirmNameText;

    @FXML
    private JFXTextField confirmLevelText;

    @FXML
    private JFXTextField customerNameText;

    private user selectedOperator;
    private user selectedEvaluator;
    private user selectedConfirmation;
    private customer selectedCustomer;
    private equipment selectedEquipment;

    public void fillReport(user operator){
   selectedOperator = operator;
   operatorNameText.setText(selectedOperator.getLastName());
   operatorLevelText.setText(selectedOperator.getLevel());





    }

    @FXML
    void initialize() {





    }
}
