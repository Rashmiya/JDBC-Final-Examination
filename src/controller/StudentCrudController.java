package controller;

import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentCrudController {
    public static String getStudentID(int column) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT student_ID FROM student ORDER BY student_ID DESC LIMIT 1");

        if (result.next()) {
//            return result.getString(1);
            String id = result.getString(column);
            String[] splitted = id.split("(S)");
            return String.format("S%03d", (Integer.valueOf(splitted[1]) + 1));
        }
        return "S001";
    }
}
