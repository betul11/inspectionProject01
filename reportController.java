package sample.controller;

import javafx.print.PrinterJob;
import javafx.scene.control.Alert;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.fontbox.ttf.GlyphSubstitutionTable;
import org.apache.fontbox.ttf.TTFTable;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;



import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

import java.io.File;
import java.io.IOException;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
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
    private JFXTextField surfaceConditionText;

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
    private JFXComboBox<String> currentTypeCombo;

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

        customerNameCombo.valueProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue == null) {
                offerNoCombo.getItems().clear();
                offerNoCombo.setDisable(true);
                jobOrderCombo.getItems().clear();
                jobOrderCombo.setDisable(true);
            } else {
                databaseHandler db = new databaseHandler();
                customer combo = customerNameCombo.getValue();

                    inspectionPlaceText.setText(combo.getAddress());

                ObservableList<jobOrder> jobOrders = null;
                try {
                    jobOrders = db.getJobOrders(combo.getCompanyName());
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                jobOrderCombo.setItems(jobOrders);
                ObservableList<offerNo> offerNos = null;
                try {
                    offerNos = db.getOfferNos(combo.getCompanyName());
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                offerNoCombo.setItems(offerNos);

            }
        });

        ObservableList<String> currentType = FXCollections.observableArrayList();
        currentType.add("AC");
        currentType.add("DC");
        currentTypeCombo.setItems(currentType);

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

    public boolean checkIfEmpty(){
        if(weldText1.getText().isEmpty() || testLengthText1.getText().isEmpty()
        || weldingProcessText1.getText().isEmpty() || thicknessText1.getText().isEmpty()){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("Please fill the necessary fields (*)!");
            errorAlert.showAndWait();
            return true;

        }else if ((resultCombo1.getValue()=="RED" && defectType1.getText().isEmpty())|| (resultCombo1.getValue()=="RED"&& defectLocationText1.getText().isEmpty())){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("Please specify defect location and type (*)!");
            errorAlert.showAndWait();
            return true;

        }else if ((resultCombo2.getValue()=="RED" && defectType2.getText().isEmpty())|| (resultCombo2.getValue()=="RED"&& defectLocationText2.getText().isEmpty())){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("Please specify defect location and type (*)!");
            errorAlert.showAndWait();
            return true;

        }


        return false;

    }


    public void convertEXCELonAction(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        if(checkIfEmpty()==true){

            return;
        }

// we save our template Rapor1 in a FileInputStream Object
        // we can use this to create new workbook based on this template
        // so we don't have to change the template itself
        FileInputStream inputStream = new FileInputStream(new File("D:/TDU/4.dönem/INF202/Rapor1.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        // this should appear at costumer name field
        XSSFRow row1 = sheet.getRow(2);
       // XSSFCell customerCombo = row1.getCell(3);
        // passing value to the cell
       // customerCombo.setCellValue(customerNameCombo.getValue().getCompanyName());
        XSSFCell inspectionProcedure = row1.getCell(19);
        inspectionProcedure.setCellValue(inspectionProcedureText.getText());
        XSSFCell page = row1.getCell(26);
        page.setCellValue(pageText.getText());

        XSSFRow row2 = sheet.getRow(3);
        XSSFCell projectName = row2.getCell(3);
        projectName.setCellValue(projectNameText.getText());
        XSSFCell inspectionScope = row2.getCell(19);
        inspectionScope.setCellValue(inspectionScopeText.getText());
        XSSFCell reportNo = row2.getCell(26);
        reportNo.setCellValue(reportNoText.getText());

        XSSFRow row3 = sheet.getRow(4);
        XSSFCell inspectionPlace = row3.getCell(3);
        inspectionPlace.setCellValue(inspectionPlaceText.getText());

        XSSFCell drawingNo = row3.getCell(19);
        drawingNo.setCellValue(drawingNoText.getText());
        XSSFCell reportDate = row3.getCell(26);
        reportDate.setCellValue(reportDateText.getText());

        XSSFRow row4 = sheet.getRow(5);
        XSSFCell inspectionStandard = row4.getCell(3);
        inspectionStandard.setCellValue(inspectionStandardText.getText());
        XSSFCell surfaceCondition = row4.getCell(19);
      //  surfaceCondition.setCellValue(surfaceConditionCombo.getValue());
        XSSFCell jobOrder = row4.getCell(26);
       // jobOrder.setCellValue(jobOrderCombo.getValue().toString());

        XSSFRow row5 = sheet.getRow(6);
        XSSFCell evaluationStandard = row5.getCell(3);
        evaluationStandard.setCellValue(evaluationStandardText.getText());
        XSSFCell examinationStage = row5.getCell(19);
       // examinationStage.setCellValue(examinationStageCombo.getValue());
        XSSFCell offerNo = row5.getCell(26);
      //  offerNo.setCellValue(offerNoCombo.getValue().getOfferNo());

        XSSFRow row6 = sheet.getRow(8);
        XSSFCell poleDistance = row6.getCell(4);
        poleDistance.setCellValue(poleDistanceText.getText());
        XSSFCell examinationArea = row6.getCell(16);
        examinationArea.setCellValue(examinationAreaText.getText());
        XSSFCell surfaceTemperature = row6.getCell(25);
        surfaceTemperature.setCellValue(surfaceTemperatureText.getText());

        XSSFRow row7 = sheet.getRow(9);
        XSSFCell equipment = row7.getCell(4);
        equipment.setCellValue(equipmentText.getText());
        XSSFCell currentType = row7.getCell(16);
        currentType.setCellValue(currentTypeCombo.getValue());
        XSSFCell gaussField = row7.getCell(25);
        gaussField.setCellValue(gaussFieldText.getText());

        XSSFRow row8 = sheet.getRow(10);
        XSSFCell carrierMedium = row8.getCell(4);
        carrierMedium.setCellValue(mpCarrierMediumText.getText());
        XSSFCell luxmeter = row8.getCell(16);
        luxmeter.setCellValue(luxmeterText.getText());

        XSSFRow row9 = sheet.getRow(11);
        XSSFCell magTech = row9.getCell(4);
        magTech.setCellValue(magTechText.getText());
        XSSFCell testMedium = row9.getCell(16);
        testMedium.setCellValue(testMediumText.getText());
        XSSFCell surfaceConditionTextCell = row9.getCell(25);
        surfaceConditionTextCell.setCellValue(surfaceConditionText.getText());

        XSSFRow row10 = sheet.getRow(12);
        XSSFCell lightIntensity = row10.getCell(4);
        lightIntensity.setCellValue(lightIntensityText.getText());
        XSSFCell demagnet = row10.getCell(16);
        demagnet.setCellValue(demagnetizationText.getText());
        XSSFCell lightEquipID = row10.getCell(25);
        lightEquipID.setCellValue(idOfLightEquipText.getText());

        XSSFRow row11 = sheet.getRow(13);
        XSSFCell lightDistance = row11.getCell(4);
        lightDistance.setCellValue(lightDistanceText.getText());
        XSSFCell heatTreatment = row11.getCell(16);
        heatTreatment.setCellValue(heatTreatmentText.getText());
        XSSFCell liftingTestDate = row11.getCell(25);
        liftingTestDate.setCellValue(liftingTestDateText.getText());
        
        XSSFRow row12 = sheet.getRow(19);
        XSSFCell standardDeviation = row12.getCell(7);
        standardDeviation.setCellValue(standardDeviationText.getText());

        XSSFRow row13 = sheet.getRow(20);
        XSSFCell inspectionDates = row13.getCell(7);
        inspectionDates.setCellValue(inspectionDatesText.getText());

        XSSFRow row14 = sheet.getRow(21);
        XSSFCell description = row14.getCell(7);
        description.setCellValue(descriptionText.getText());

        XSSFRow row15 = sheet.getRow(24);
        XSSFCell weld1 = row15.getCell(1);
        weld1.setCellValue(weldText1.getText());
        XSSFCell testlength1 = row15.getCell(8);
        testlength1.setCellValue(testLengthText1.getText());
        XSSFCell weldingProcess1 = row15.getCell(11);
        weldingProcess1.setCellValue(weldingProcessText1.getText());
        XSSFCell thickness1 = row15.getCell(17);
        thickness1.setCellValue(thicknessText1.getText());
        XSSFCell diameter1 = row15.getCell(18);
        diameter1.setCellValue(diameterText1.getText());
        XSSFCell defectType01 = row15.getCell(22);
        defectType01.setCellValue(defectType1.getText());
        XSSFCell defectLocation1 = row15.getCell(24);
        defectLocation1.setCellValue(defectLocationText1.getText());
        XSSFCell result1 = row15.getCell(27);
      //  result1.setCellValue(resultCombo1.getValue());





        XSSFRow row16 = sheet.getRow(25);
        XSSFCell weld2 = row16.getCell(1);
        weld2.setCellValue(weldText2.getText());
        XSSFCell testlength2 = row16.getCell(8);
        testlength2.setCellValue(testLengthText2.getText());
        XSSFCell weldingProcess2 = row16.getCell(11);
        weldingProcess2.setCellValue(weldingProcessText2.getText());
        XSSFCell thickness2 = row16.getCell(17);
        thickness2.setCellValue(thicknessText2.getText());
        XSSFCell diameter2 = row16.getCell(18);
        diameter2.setCellValue(diameterText2.getText());
        XSSFCell defectType02 = row16.getCell(22);
        defectType02.setCellValue(defectType2.getText());
        XSSFCell defectLocation2 = row16.getCell(24);
        defectLocation2.setCellValue(defectLocationText2.getText());
        XSSFCell result2 = row16.getCell(27);
      //  result2.setCellValue(resultCombo2.getValue());





        XSSFRow row17 = sheet.getRow(26);
        XSSFCell weld3 = row17.getCell(1);
        weld3.setCellValue(weldText3.getText());
        XSSFCell testlength3 = row17.getCell(8);
        testlength3.setCellValue(testLengthText3.getText());
        XSSFCell weldingProcess3 = row17.getCell(11);
        weldingProcess3.setCellValue(weldingProcessText3.getText());
        XSSFCell thickness3 = row17.getCell(17);
        thickness3.setCellValue(thicknessText3.getText());
        XSSFCell diameter3 = row17.getCell(18);
        diameter3.setCellValue(diameterText3.getText());
        XSSFCell defectType03 = row17.getCell(22);
        defectType03.setCellValue(defectType3.getText());
        XSSFCell defectLocation3 = row17.getCell(24);
        defectLocation3.setCellValue(defectLocationText3.getText());
        XSSFCell result3 = row17.getCell(27);
      //  result3.setCellValue(resultCombo3.getValue());


        XSSFRow row18 = sheet.getRow(27);
        XSSFCell weld4 = row18.getCell(1);
        weld4.setCellValue(weldText4.getText());
        XSSFCell testlength4 = row18.getCell(8);
        testlength4.setCellValue(testLengthText4.getText());
        XSSFCell weldingProcess4 = row18.getCell(11);
        weldingProcess4.setCellValue(weldingProcessText4.getText());
        XSSFCell thickness4 = row18.getCell(17);
        thickness4.setCellValue(thicknessText4.getText());
        XSSFCell diameter4 = row18.getCell(18);
        diameter4.setCellValue(diameterText4.getText());
        XSSFCell defectType04 = row17.getCell(22);
        defectType04.setCellValue(defectType4.getText());
        XSSFCell defectLocation4 = row18.getCell(24);
        defectLocation4.setCellValue(defectLocationText4.getText());
        XSSFCell result4 = row18.getCell(27);
      //  result4.setCellValue(resultCombo4.getValue());





        XSSFRow row19 = sheet.getRow(28);
        XSSFCell weld5 = row19.getCell(1);
        weld5.setCellValue(weldText5.getText());
        XSSFCell testlength5 = row19.getCell(8);
        testlength5.setCellValue(testLengthText5.getText());
        XSSFCell weldingProcess5 = row19.getCell(11);
        weldingProcess5.setCellValue(weldingProcessText5.getText());
        XSSFCell thickness5 = row19.getCell(17);
        thickness5.setCellValue(thicknessText5.getText());
        XSSFCell diameter5 = row19.getCell(18);
        diameter5.setCellValue(diameterText5.getText());
        XSSFCell defectType05 = row19.getCell(22);
        defectType05.setCellValue(defectType5.getText());
        XSSFCell defectLocation5 = row19.getCell(24);
        defectLocation5.setCellValue(defectLocationText5.getText());
        XSSFCell result5 = row19.getCell(27);
        //result5.setCellValue(resultCombo5.getValue());

        XSSFRow row20 = sheet.getRow(39);
        XSSFCell operatorName = row20.getCell(5);
        operatorName.setCellValue(operatorNameText.getText());
        XSSFCell evaluatorName = row20.getCell(15);
        evaluatorName.setCellValue(evaluatorNameText.getText());
        XSSFCell confirmerName = row20.getCell(20);
        confirmerName.setCellValue(confirmerNameText.getText());
        XSSFCell customerName = row20.getCell(25);
        customerName.setCellValue(customerNameSurnameText.getText());

        XSSFRow row21 = sheet.getRow(40);
        XSSFCell operatorLevel = row21.getCell(5);
        operatorLevel.setCellValue(operatorLevelText.getText());
        XSSFCell evaluatorLevel = row21.getCell(15);
        evaluatorLevel.setCellValue(evaluatorLevelText.getText());
        XSSFCell confirmerLevel = row21.getCell(20);
        confirmerLevel.setCellValue(confirmerLevelText.getText());

        XSSFRow row22 = sheet.getRow(41);
        XSSFCell date1 = row22.getCell(5);
        XSSFCell date2 = row22.getCell(15);
        XSSFCell date3 = row22.getCell(20);
        date1.setCellValue(reportDateText.getText());
        date2.setCellValue(reportDateText.getText());
        date3.setCellValue(reportDateText.getText());



        // important to save the changes we made to the new file
      //  databaseHandler db = new databaseHandler();
        //int n = db.getNvalue();

        workbook.write(new FileOutputStream("D:/TDU/4.dönem/INF202/ReportExcel.xlsx"));
        workbook.close();
       // n++;
       // db.setNvalue(n);

    }

    public void convertPDFonAction(ActionEvent actionEvent) throws IOException {


        File file = new File("D:/TDU/4.dönem/INF202/Rapor1.pdf");
        PDDocument document = PDDocument.load(file);

         PDPage page = document.getPage(0);

      /*  PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream.beginText();
        contentStream.newLineAtOffset(115, 750);
        contentStream.setFont(PDType1Font.HELVETICA, 7);
        String customer = customerNameCombo.getValue().getCompanyName();
        contentStream.showText(customer);
        contentStream.endText();
        contentStream.close();*/

        PDPageContentStream contentStream1 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream1.beginText();
        contentStream1.newLineAtOffset(115, 730);
        contentStream1.setFont(PDType1Font.HELVETICA, 7);
        contentStream1.showText(projectNameText.getText());
        contentStream1.endText();
        contentStream1.close();

        PDPageContentStream contentStream2 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream2.beginText();
        contentStream2.newLineAtOffset(115, 705);
        contentStream2.setFont(PDType1Font.HELVETICA, 7);
        contentStream2.showText(inspectionPlaceText.getText());
        contentStream2.endText();
        contentStream2.close();

        PDPageContentStream contentStream3 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream3.beginText();
        contentStream3.newLineAtOffset(115, 685);
        contentStream3.setFont(PDType1Font.HELVETICA, 7);
        contentStream3.showText(inspectionStandardText.getText());
        contentStream3.endText();
        contentStream3.close();

       PDPageContentStream contentStream4 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream4.beginText();
        contentStream4.newLineAtOffset(115, 660);
        contentStream4.setFont(PDType1Font.HELVETICA, 7);
        contentStream4.showText(evaluationStandardText.getText());
        contentStream4.endText();
        contentStream4.close();

        PDPageContentStream contentStream5 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream5.beginText();
        contentStream5.newLineAtOffset(115, 626);
        contentStream5.setFont(PDType1Font.HELVETICA, 7);
        contentStream5.showText(poleDistanceText.getText());
        contentStream5.endText();
        contentStream5.close();

        PDPageContentStream contentStream6 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream6.beginText();
        contentStream6.newLineAtOffset(115, 601);
        contentStream6.setFont(PDType1Font.HELVETICA, 7);
        contentStream6.showText(equipmentText.getText());
        contentStream6.endText();
        contentStream6.close();

        PDPageContentStream contentStream7 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream7.beginText();
        contentStream7.newLineAtOffset(115, 579);
        contentStream7.setFont(PDType1Font.HELVETICA, 7);
        contentStream7.showText(mpCarrierMediumText.getText());
        contentStream7.endText();
        contentStream7.close();

        PDPageContentStream contentStream8 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream8.beginText();
        contentStream8.newLineAtOffset(115, 558);
        contentStream8.setFont(PDType1Font.HELVETICA, 7);
        contentStream8.showText(magTechText.getText());
        contentStream8.endText();
        contentStream8.close();

        PDPageContentStream contentStream9 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream9.beginText();
        contentStream9.newLineAtOffset(115, 538);
        contentStream9.setFont(PDType1Font.HELVETICA, 7);
        contentStream9.showText(lightIntensityText.getText());
        contentStream9.endText();
        contentStream9.close();

        PDPageContentStream contentStream10 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream10.beginText();
        contentStream10.newLineAtOffset(115, 517);
        contentStream10.setFont(PDType1Font.HELVETICA, 7);
        contentStream10.showText(lightDistanceText.getText());
        contentStream10.endText();
        contentStream10.close();




         PDPageContentStream contentStream12 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream12.beginText();
        contentStream12.newLineAtOffset(388, 750);
        contentStream12.setFont(PDType1Font.HELVETICA, 7);
        contentStream12.showText(inspectionProcedureText.getText());
        contentStream12.endText();
        contentStream12.close();

        PDPageContentStream contentStream13 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream13.beginText();
        contentStream13.newLineAtOffset(388, 730);
        contentStream13.setFont(PDType1Font.HELVETICA, 7);
        contentStream13.showText(inspectionScopeText.getText());
        contentStream13.endText();
        contentStream13.close();

        PDPageContentStream contentStream14 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream14.beginText();
        contentStream14.newLineAtOffset(388, 705);
        contentStream14.setFont(PDType1Font.HELVETICA, 7);
        contentStream14.showText(drawingNoText.getText());
        contentStream14.endText();
        contentStream14.close();

        PDPageContentStream contentStream15 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream15.beginText();
        contentStream15.newLineAtOffset(388, 685);
        contentStream15.setFont(PDType1Font.HELVETICA, 7);
        contentStream15.showText(surfaceConditionCombo.getValue());
        contentStream15.endText();
        contentStream15.close();

        PDPageContentStream contentStream16 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream16.beginText();
        contentStream16.newLineAtOffset(388, 660);
        contentStream16.setFont(PDType1Font.HELVETICA, 7);
        contentStream16.showText(examinationStageCombo.getValue());
        contentStream16.endText();
        contentStream16.close();

        PDPageContentStream contentStream17 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream17.beginText();
        contentStream17.newLineAtOffset(526, 750);
        contentStream17.setFont(PDType1Font.HELVETICA, 7);
        contentStream17.showText(pageText.getText());
        contentStream17.endText();
        contentStream17.close();

        PDPageContentStream contentStream18 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream18.beginText();
        contentStream18.newLineAtOffset(526, 730);
        contentStream18.setFont(PDType1Font.HELVETICA, 7);
        contentStream18.showText(reportNoText.getText());
        contentStream18.endText();
        contentStream18.close();

        PDPageContentStream contentStream19 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream19.beginText();
        contentStream19.newLineAtOffset(526, 705);
        contentStream19.setFont(PDType1Font.HELVETICA, 7);
        contentStream19.showText(reportDateText.getText());
        contentStream19.endText();
        contentStream19.close();

       /* PDPageContentStream contentStream20 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream20.beginText();
        contentStream20.newLineAtOffset(526, 685);
        contentStream20.setFont(PDType1Font.HELVETICA, 7);
        contentStream20.showText(jobOrderCombo.getValue().getJobOrderNo());
        contentStream20.endText();
        contentStream20.close();*/

      /*  PDPageContentStream contentStream21 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream21.beginText();
        contentStream21.newLineAtOffset(526, 660);
        contentStream21.setFont(PDType1Font.HELVETICA, 7);
        contentStream21.showText(offerNoCombo.getValue().getOfferNo());
        contentStream21.endText();
        contentStream21.close();*/

        PDPageContentStream contentStream22 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream22.beginText();
        contentStream22.newLineAtOffset(316, 626);
        contentStream22.setFont(PDType1Font.HELVETICA, 7);
        contentStream22.showText(examinationAreaText.getText());
        contentStream22.endText();
        contentStream22.close();

        PDPageContentStream contentStream23 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream23.beginText();
        contentStream23.newLineAtOffset(316, 601);
        contentStream23.setFont(PDType1Font.HELVETICA, 7);
        contentStream23.showText(currentTypeCombo.getValue());
        contentStream23.endText();
        contentStream23.close();

        PDPageContentStream contentStream24 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream24.beginText();
        contentStream24.newLineAtOffset(316, 579);
        contentStream24.setFont(PDType1Font.HELVETICA, 7);
        contentStream24.showText(luxmeterText.getText());
        contentStream24.endText();
        contentStream24.close();

        PDPageContentStream contentStream25 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream25.beginText();
        contentStream25.newLineAtOffset(316, 558);
        contentStream25.setFont(PDType1Font.HELVETICA, 7);
        contentStream25.showText(testMediumText.getText());
        contentStream25.endText();
        contentStream25.close();

        PDPageContentStream contentStream26 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream26.beginText();
        contentStream26.newLineAtOffset(316, 538);
        contentStream26.setFont(PDType1Font.HELVETICA, 7);
        contentStream26.showText(demagnetizationText.getText());
        contentStream26.endText();
        contentStream26.close();

        PDPageContentStream contentStream27 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream27.beginText();
        contentStream27.newLineAtOffset(316, 517);
        contentStream27.setFont(PDType1Font.HELVETICA, 7);
        contentStream27.showText(heatTreatmentText.getText());
        contentStream27.endText();
        contentStream27.close();

        PDPageContentStream contentStream28 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream28.beginText();
        contentStream28.newLineAtOffset(506, 626);
        contentStream28.setFont(PDType1Font.HELVETICA, 7);
        contentStream28.showText(surfaceTemperatureText.getText());
        contentStream28.endText();
        contentStream28.close();

        PDPageContentStream contentStream29 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream29.beginText();
        contentStream29.newLineAtOffset(506, 590);
        contentStream29.setFont(PDType1Font.HELVETICA, 7);
        contentStream29.showText(gaussFieldText.getText());
        contentStream29.endText();
        contentStream29.close();

        PDPageContentStream contentStream30 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream30.beginText();
        contentStream30.newLineAtOffset(506, 558);
        contentStream30.setFont(PDType1Font.HELVETICA, 7);
        contentStream30.showText(surfaceConditionText.getText());
        contentStream30.endText();
        contentStream30.close();

        PDPageContentStream contentStream31 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream31.beginText();
        contentStream31.newLineAtOffset(506, 538);
        contentStream31.setFont(PDType1Font.HELVETICA, 7);
        contentStream31.showText(idOfLightEquipText.getText());
        contentStream31.endText();
        contentStream31.close();

        PDPageContentStream contentStream32 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream32.beginText();
        contentStream32.newLineAtOffset(506, 517);
        contentStream32.setFont(PDType1Font.HELVETICA, 7);
        contentStream32.showText(liftingTestDateText.getText());
        contentStream32.endText();
        contentStream32.close();

        PDPageContentStream contentStream33 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream33.beginText();
        contentStream33.newLineAtOffset(159, 420);
        contentStream33.setFont(PDType1Font.HELVETICA, 7);
        contentStream33.showText(standardDeviationText.getText());
        contentStream33.endText();
        contentStream33.close();


        PDPageContentStream contentStream34 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream34.beginText();
        contentStream34.newLineAtOffset(159, 401);
        contentStream34.setFont(PDType1Font.HELVETICA, 7);
        contentStream34.showText(inspectionDatesText.getText());
        contentStream34.endText();
        contentStream34.close();


        PDPageContentStream contentStream35 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream35.beginText();
        contentStream35.newLineAtOffset(159, 382);
        contentStream35.setFont(PDType1Font.HELVETICA, 7);
        contentStream35.showText(descriptionText.getText());
        contentStream35.endText();
        contentStream35.close();

      /*  PDPageContentStream contentStream36 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream36.beginText();
        contentStream36.newLineAtOffset(76, 321);
        contentStream36.setFont(PDType1Font.HELVETICA, 7);
        contentStream36.showText(weldText1.getText());
        contentStream36.endText();
        contentStream36.close();

        PDPageContentStream contentStream37 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream37.beginText();
        contentStream37.newLineAtOffset(171, 321);
        contentStream37.setFont(PDType1Font.HELVETICA, 7);
        contentStream37.showText(testLengthText1.getText());
        contentStream37.endText();
        contentStream37.close();

        PDPageContentStream contentStream38 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream38.beginText();
        contentStream38.newLineAtOffset(236, 321);
        contentStream38.setFont(PDType1Font.HELVETICA, 7);
        contentStream38.showText(weldingProcessText1.getText());
        contentStream38.endText();
        contentStream38.close();

        PDPageContentStream contentStream39 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream39.beginText();
        contentStream39.newLineAtOffset(324, 321);
        contentStream39.setFont(PDType1Font.HELVETICA, 7);
        contentStream39.showText(thicknessText1.getText());
        contentStream39.endText();
        contentStream39.close();


        PDPageContentStream contentStream40 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream40.beginText();
        contentStream40.newLineAtOffset(371, 321);
        contentStream40.setFont(PDType1Font.HELVETICA, 7);
        contentStream40.showText(diameterText1.getText());
        contentStream40.endText();
        contentStream40.close();

        PDPageContentStream contentStream41 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream41.beginText();
        contentStream41.newLineAtOffset(426, 321);
        contentStream41.setFont(PDType1Font.HELVETICA, 7);
        contentStream41.showText(defectType1.getText());
        contentStream41.endText();
        contentStream41.close();

        PDPageContentStream contentStream42 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream42.beginText();
        contentStream42.newLineAtOffset(481, 321);
        contentStream42.setFont(PDType1Font.HELVETICA, 7);
        contentStream42.showText(defectLocationText1.getText());
        contentStream42.endText();
        contentStream42.close();

        PDPageContentStream contentStream43 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream43.beginText();
        contentStream43.newLineAtOffset(556, 321);
        contentStream43.setFont(PDType1Font.HELVETICA, 7);
        contentStream43.showText(resultCombo1.getValue());
        contentStream43.endText();
        contentStream43.close();

        PDPageContentStream contentStream44 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream44.beginText();
        contentStream44.newLineAtOffset(76, 304);
        contentStream44.setFont(PDType1Font.HELVETICA, 7);
        contentStream44.showText(weldText2.getText());
        contentStream44.endText();
        contentStream44.close();

        PDPageContentStream contentStream45 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream45.beginText();
        contentStream45.newLineAtOffset(171, 304);
        contentStream45.setFont(PDType1Font.HELVETICA, 7);
        contentStream45.showText(testLengthText2.getText());
        contentStream45.endText();
        contentStream45.close();

        PDPageContentStream contentStream46 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream46.beginText();
        contentStream46.newLineAtOffset(236, 304);
        contentStream46.setFont(PDType1Font.HELVETICA, 7);
        contentStream46.showText(weldingProcessText2.getText());
        contentStream46.endText();
        contentStream46.close();

        PDPageContentStream contentStream47 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream47.beginText();
        contentStream47.newLineAtOffset(324, 304);
        contentStream47.setFont(PDType1Font.HELVETICA, 7);
        contentStream47.showText(thicknessText2.getText());
        contentStream47.endText();
        contentStream47.close();

        PDPageContentStream contentStream48 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream48.beginText();
        contentStream48.newLineAtOffset(371, 304);
        contentStream48.setFont(PDType1Font.HELVETICA, 7);
        contentStream48.showText(diameterText2.getText());
        contentStream48.endText();
        contentStream48.close();

        PDPageContentStream contentStream49 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream49.beginText();
        contentStream49.newLineAtOffset(426, 304);
        contentStream49.setFont(PDType1Font.HELVETICA, 7);
        contentStream49.showText(defectType2.getText());
        contentStream49.endText();
        contentStream49.close();

        PDPageContentStream contentStream50 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream50.beginText();
        contentStream50.newLineAtOffset(481, 304);
        contentStream50.setFont(PDType1Font.HELVETICA, 7);
        contentStream50.showText(defectLocationText2.getText());
        contentStream50.endText();
        contentStream50.close();

        PDPageContentStream contentStream51 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream51.beginText();
        contentStream51.newLineAtOffset(556, 304);
        contentStream51.setFont(PDType1Font.HELVETICA, 7);
        contentStream51.showText(resultCombo5.getValue());
        contentStream51.endText();
        contentStream51.close();

        PDPageContentStream contentStream52 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream52.beginText();
        contentStream52.newLineAtOffset(76, 287);
        contentStream52.setFont(PDType1Font.HELVETICA, 7);
        contentStream52.showText(weldText3.getText());
        contentStream52.endText();
        contentStream52.close();

        PDPageContentStream contentStream53 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream53.beginText();
        contentStream53.newLineAtOffset(171, 287);
        contentStream53.setFont(PDType1Font.HELVETICA, 7);
        contentStream53.showText(testLengthText3.getText());
        contentStream53.endText();
        contentStream53.close();

        PDPageContentStream contentStream54 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream54.beginText();
        contentStream54.newLineAtOffset(236, 287);
        contentStream54.setFont(PDType1Font.HELVETICA, 7);
        contentStream54.showText(weldingProcessText3.getText());
        contentStream54.endText();
        contentStream54.close();

        PDPageContentStream contentStream55 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream55.beginText();
        contentStream55.newLineAtOffset(324, 287);
        contentStream55.setFont(PDType1Font.HELVETICA, 7);
        contentStream55.showText(thicknessText3.getText());
        contentStream55.endText();
        contentStream55.close();

        PDPageContentStream contentStream56 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream56.beginText();
        contentStream56.newLineAtOffset(371, 287);
        contentStream56.setFont(PDType1Font.HELVETICA, 7);
        contentStream56.showText(diameterText3.getText());
        contentStream56.endText();
        contentStream56.close();

        PDPageContentStream contentStream57 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream57.beginText();
        contentStream57.newLineAtOffset(426, 287);
        contentStream57.setFont(PDType1Font.HELVETICA, 7);
        contentStream57.showText(defectType3.getText());
        contentStream57.endText();
        contentStream57.close();

        PDPageContentStream contentStream58 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream58.beginText();
        contentStream58.newLineAtOffset(481, 287);
        contentStream58.setFont(PDType1Font.HELVETICA, 7);
        contentStream58.showText(defectLocationText3.getText());
        contentStream58.endText();
        contentStream58.close();

        PDPageContentStream contentStream59 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream59.beginText();
        contentStream59.newLineAtOffset(556, 287);
        contentStream59.setFont(PDType1Font.HELVETICA, 7);
        contentStream59.showText(resultCombo3.getValue());
        contentStream59.endText();
        contentStream59.close();

        PDPageContentStream contentStream60 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream60.beginText();
        contentStream60.newLineAtOffset(76, 270);
        contentStream60.setFont(PDType1Font.HELVETICA, 7);
        contentStream60.showText(weldText4.getText());
        contentStream60.endText();
        contentStream60.close();

        PDPageContentStream contentStream61 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream61.beginText();
        contentStream61.newLineAtOffset(171, 270);
        contentStream61.setFont(PDType1Font.HELVETICA, 7);
        contentStream61.showText(testLengthText4.getText());
        contentStream61.endText();
        contentStream61.close();

        PDPageContentStream contentStream62 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream62.beginText();
        contentStream62.newLineAtOffset(236, 270);
        contentStream62.setFont(PDType1Font.HELVETICA, 7);
        contentStream62.showText(weldingProcessText4.getText());
        contentStream62.endText();
        contentStream62.close();

        PDPageContentStream contentStream63 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream63.beginText();
        contentStream63.newLineAtOffset(324, 270);
        contentStream63.setFont(PDType1Font.HELVETICA, 7);
        contentStream63.showText(thicknessText4.getText());
        contentStream63.endText();
        contentStream63.close();

        PDPageContentStream contentStream64 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream64.beginText();
        contentStream64.newLineAtOffset(371, 270);
        contentStream64.setFont(PDType1Font.HELVETICA, 7);
        contentStream64.showText(diameterText4.getText());
        contentStream64.endText();
        contentStream64.close();

        PDPageContentStream contentStream65 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream65.beginText();
        contentStream65.newLineAtOffset(426, 270);
        contentStream65.setFont(PDType1Font.HELVETICA, 7);
        contentStream65.showText(defectType4.getText());
        contentStream65.endText();
        contentStream65.close();

        PDPageContentStream contentStream66 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream66.beginText();
        contentStream66.newLineAtOffset(481, 270);
        contentStream66.setFont(PDType1Font.HELVETICA, 7);
        contentStream66.showText(defectLocationText4.getText());
        contentStream66.endText();
        contentStream66.close();

        PDPageContentStream contentStream67 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream67.beginText();
        contentStream67.newLineAtOffset(556, 270);
        contentStream67.setFont(PDType1Font.HELVETICA, 7);
        contentStream67.showText(resultCombo4.getValue());
        contentStream67.endText();
        contentStream67.close();

        PDPageContentStream contentStream68 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream68.beginText();
        contentStream68.newLineAtOffset(76, 253);
        contentStream68.setFont(PDType1Font.HELVETICA, 7);
        contentStream68.showText(weldText5.getText());
        contentStream68.endText();
        contentStream68.close();

        PDPageContentStream contentStream69 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream69.beginText();
        contentStream69.newLineAtOffset(171, 253);
        contentStream69.setFont(PDType1Font.HELVETICA, 7);
        contentStream69.showText(testLengthText5.getText());
        contentStream69.endText();
        contentStream69.close();

        PDPageContentStream contentStream70 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream70.beginText();
        contentStream70.newLineAtOffset(236, 253);
        contentStream70.setFont(PDType1Font.HELVETICA, 7);
        contentStream70.showText(weldingProcessText5.getText());
        contentStream70.endText();
        contentStream70.close();

        PDPageContentStream contentStream71 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream71.beginText();
        contentStream71.newLineAtOffset(324, 253);
        contentStream71.setFont(PDType1Font.HELVETICA, 7);
        contentStream71.showText(thicknessText5.getText());
        contentStream71.endText();
        contentStream71.close();


        PDPageContentStream contentStream72 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream72.beginText();
        contentStream72.newLineAtOffset(371, 253);
        contentStream72.setFont(PDType1Font.HELVETICA, 7);
        contentStream72.showText(diameterText5.getText());
        contentStream72.endText();
        contentStream72.close();


        PDPageContentStream contentStream73 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream73.beginText();
        contentStream73.newLineAtOffset(426, 253);
        contentStream73.setFont(PDType1Font.HELVETICA, 7);
        contentStream73.showText(defectType5.getText());
        contentStream73.endText();
        contentStream73.close();


        PDPageContentStream contentStream74 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream74.beginText();
        contentStream74.newLineAtOffset(481, 253);
        contentStream74.setFont(PDType1Font.HELVETICA, 7);
        contentStream74.showText(defectLocationText5.getText());
        contentStream74.endText();
        contentStream74.close();


        PDPageContentStream contentStream75 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream75.beginText();
        contentStream75.newLineAtOffset(556, 253);
        contentStream75.setFont(PDType1Font.HELVETICA, 7);
        contentStream75.showText(resultCombo5.getValue());
        contentStream75.endText();
        contentStream75.close();*/

        PDPageContentStream contentStream76 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream76.beginText();
        contentStream76.newLineAtOffset(146, 115);
        contentStream76.setFont(PDType1Font.HELVETICA, 7);
        contentStream76.showText(operatorNameText.getText());
        contentStream76.endText();
        contentStream76.close();

        PDPageContentStream contentStream77 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream77.beginText();
        contentStream77.newLineAtOffset(267, 115);
        contentStream77.setFont(PDType1Font.HELVETICA, 7);
        contentStream77.showText(evaluatorNameText.getText());
        contentStream77.endText();
        contentStream77.close();

        PDPageContentStream contentStream78 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream78.beginText();
        contentStream78.newLineAtOffset(406, 115);
        contentStream78.setFont(PDType1Font.HELVETICA, 7);
        contentStream78.showText(confirmerNameText.getText());
        contentStream78.endText();
        contentStream78.close();

        PDPageContentStream contentStream79 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream79.beginText();
        contentStream79.newLineAtOffset(506, 115);
        contentStream79.setFont(PDType1Font.HELVETICA, 7);
        contentStream79.showText(customerNameSurnameText.getText());
        contentStream79.endText();
        contentStream79.close();

        PDPageContentStream contentStream80 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream80.beginText();
        contentStream80.newLineAtOffset(146, 92);
        contentStream80.setFont(PDType1Font.HELVETICA, 7);
        contentStream80.showText(operatorLevelText.getText());
        contentStream80.endText();
        contentStream80.close();

        PDPageContentStream contentStream81 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream81.beginText();
        contentStream81.newLineAtOffset(267, 92);
        contentStream81.setFont(PDType1Font.HELVETICA, 7);
        contentStream81.showText(evaluatorLevelText.getText());
        contentStream81.endText();
        contentStream81.close();

        PDPageContentStream contentStream82 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream82.beginText();
        contentStream82.newLineAtOffset(406, 92);
        contentStream82.setFont(PDType1Font.HELVETICA, 7);
        contentStream82.showText(confirmerLevelText.getText());
        contentStream82.endText();
        contentStream82.close();

        PDPageContentStream contentStream83 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream83.beginText();
        contentStream83.newLineAtOffset(146, 73);
        contentStream83.setFont(PDType1Font.HELVETICA, 7);
        contentStream83.showText(operatorDateText.getText());
        contentStream83.endText();
        contentStream83.close();

        PDPageContentStream contentStream84 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream84.beginText();
        contentStream84.newLineAtOffset(267, 73);
        contentStream84.setFont(PDType1Font.HELVETICA, 7);
        contentStream84.showText(evaluatorDateText.getText());
        contentStream84.endText();
        contentStream84.close();

        PDPageContentStream contentStream85 = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream85.beginText();
        contentStream85.newLineAtOffset(406, 73);
        contentStream85.setFont(PDType1Font.HELVETICA, 7);
        contentStream85.showText(confirmerDateText.getText());
        contentStream85.endText();
        contentStream85.close();





        document.save("D:/TDU/4.dönem/INF202/PDFRapor.pdf");
        document.close();
    }

   /* public static void test(int x, int y, PDDocument document, PDPage page) throws IOException {
       PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream.beginText();
        contentStream.newLineAtOffset(x, y);
        contentStream.setFont(PDType1Font.HELVETICA, 6);
        String text = "This is me Testing";
        contentStream.showText(text);
        contentStream.endText();
        contentStream.close();
    }*/

}
