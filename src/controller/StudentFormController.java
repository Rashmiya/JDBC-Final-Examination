package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class StudentFormController {
    public Button btnDelete;
    public AnchorPane StudentForm;
    public TableView tblStudent;
    public TableColumn colID;
    public TableColumn colName;
    public TableColumn colEmail;
    public TableColumn colContact;
    public TableColumn colAddress;
    public TableColumn colNIC;
    public TableColumn colModify;
    public Button btnSave;
    public TextField txtID;
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtContact;
    public JFXTextField txtSearch;
    public Button btnUpdate;
    public TextField txtAddress;
    public AnchorPane txtNIC;
    public TextField txtNic;

    public void UpdateOnAction(ActionEvent actionEvent) {
    }

    public void DeleteOnAction(ActionEvent actionEvent) {
    }

    public void textFields_Key_Released(KeyEvent keyEvent) {
    }

    public void SearchStudent(KeyEvent keyEvent) {
    }

    public void btnRefresh(MouseEvent mouseEvent) {
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
    }
}
