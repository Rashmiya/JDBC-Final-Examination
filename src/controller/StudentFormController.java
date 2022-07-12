package controller;

import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import model.Student;
import org.controlsfx.control.Notifications;
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
        colID.setCellValueFactory(new PropertyValueFactory<>("student_ID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("student_Name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("nic"));

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

        while(result.next()){
            obList.add(new Student(
                    result.getString("student_ID"),
                    result.getString("student_Name"),
                    result.getString("email"),
                    result.getString("contact"),
                    result.getString("address"),
                    result.getString("nic")
                    ));
        }
        tblStudent.setItems(obList);
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
    }

    public void DeleteOnAction(ActionEvent actionEvent) {
    }

    public void textFields_Key_Released(KeyEvent keyEvent) {
    }

    public void SearchStudent(KeyEvent keyEvent) throws SQLException, ClassNotFoundException {
        ObservableList<Student> obList = FXCollections.observableArrayList();
        ResultSet result = CrudUtil.execute("SELECT student_ID,student_Name,email,contact,address,nic FROM student");

        try {
            while (result.next()) {
                obList.add(new Student(
                        result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6)
                ));
            }
            FilteredList<Student> filterData = new FilteredList<>(obList, e -> true);

            txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
                filterData.setPredicate(Student -> {
                    if (newValue.isEmpty() || newValue == null) {
                        return true;
                    }
                    String searchStudent = newValue.toLowerCase();
                    if (Student.getStudent_ID().toLowerCase().indexOf(searchStudent) > -1) {
                        return true;
                    } else if (Student.getStudent_Name().toLowerCase().indexOf(searchStudent) > -1) {
                        return true;
                    } else if (Student.getContact().toLowerCase().indexOf(searchStudent) > -1) {
                        return true;
                    } else if (Student.getAddress().toLowerCase().indexOf(searchStudent) > -1) {
                        return true;
                    } else if (Student.getNic().toLowerCase().indexOf(searchStudent) > -1) {
                        return true;
                    } else {
                        return false;   // not found match values.
                    }
                });
            });

            SortedList<Student> sortedData = new SortedList<>(filterData);
            sortedData.comparatorProperty().bind(tblStudent.comparatorProperty());
            tblStudent.setItems(sortedData);

        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

        public void btnRefresh(MouseEvent mouseEvent) {

    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        Student student = new Student(
                txtID.getText(),txtName.getText(),txtEmail.getText(),txtContact.getText(),txtAddress.getText(),txtNic.getText()
        );
        try{
            boolean effectedRowCount = CrudUtil.execute("INSERT INTO student VALUES (?,?,?,?,?,?)",
                    student.getStudent_ID(),student.getStudent_Name(), student.getEmail(), student.getContact(),student.getAddress(),student.getNic()
            );
            if(effectedRowCount){
                Notifications notify = Notifications.create();
                notify.title("Student Added !");
                notify.text(" You Successfully Added Student.");
                notify.graphic(null);
                notify.hideAfter(Duration.seconds(7));
                notify.position(Pos.BOTTOM_RIGHT);
                notify.showConfirm();

                loadAllStudents();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
}
