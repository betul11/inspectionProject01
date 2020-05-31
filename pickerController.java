package sample.controller;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.database.Const;
import sample.database.databaseHandler;
import sample.model.user;

public class pickerController {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;
        @FXML
        private static TableView<user> userTable;

        @FXML
        private TableColumn<user, String> firstNameColumn;
        @FXML
        private TableColumn<user, String> surnameColumn;
        @FXML
        private TableColumn<user, String> levelColumn;
    private sample.database.databaseHandler databaseHandler;

    private ObservableList<user> data;


    @FXML
        void initialize() throws SQLException, ClassNotFoundException {
        data = FXCollections.observableArrayList();
        databaseHandler = new databaseHandler();
        ResultSet resultSet = databaseHandler.getAllUsers();


        try {

            while (resultSet.next()) {
                user user = new user();
                user.setFirstName(resultSet.getString("firstname"));
                user.setLastName(resultSet.getString("lastname"));
                user.setLevel(resultSet.getString("level"));
                data.add(user);
                firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstname"));
                surnameColumn.setCellValueFactory(new PropertyValueFactory<>("lastname"));
                levelColumn.setCellValueFactory(new PropertyValueFactory<>("level"));
                userTable.setItems(data);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }







    }
    }



