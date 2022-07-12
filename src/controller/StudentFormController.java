package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Student;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentFormController {
    public Button btnDelete;
    public AnchorPane StudentForm;
    public TableView<Student> tblStudent;
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
    public TextField txtNic;

    public void initialize(){
        try {
            loadAllStudents();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadAllStudents() throws SQLException, ClassNotFoundException {
        ObservableList<Student> obList = FXCollections.observableArrayList();
        obList.clear();
        ResultSet result = CrudUtil.execute("SELECT * FROM student ORDER BY student_ID ASC");

    }

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
