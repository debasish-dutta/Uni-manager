package com.tetradlazydragons;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Vector;
import java.util.Date;
import java.io.FileInputStream;
import java.io.InputStream;

import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.JDatePanelImpl;

import javax.swing.table.DefaultTableModel;

public class DBHandler {
    private static String login;
    private static String password;
    static String databaseUrl;
    static Connection con = null;
    private final static String studentsTable;

    public DBHandler() {

    }

    static {
        login = "root";
        databaseUrl = "jdbc:mysql://localhost:3306/student_management_system?useSSL=false";
        password = "111222344";
        studentsTable = "student_data";
    }

    public static String getLogin() {
        return login;
    }

    public static void setLogin(final String login) {
        DBHandler.login = login;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(final String password) {
        DBHandler.password = password;
    }

    public static void setDatabaseUrl(final String databaseUrl) {
        DBHandler.databaseUrl = databaseUrl;
    }

    public static String getDatabaseUrl() {
        return databaseUrl;
    }

    public static String getStudentsTable() {
        return studentsTable;
    }

    public static boolean checkIfTableExists(final String tableName) {
        try {
            String driver = "com.mysql.jdbc.Driver";
            System.setProperty(driver, "");
            System.out.println(driver);
            System.out.println(login);
            System.out.println(password);
            System.out.println(databaseUrl);
            Connection connection = DriverManager.getConnection(databaseUrl, login, password);
            // Check if a table with tableName name already exists
            DatabaseMetaData dbmData = connection.getMetaData();
            ResultSet resultSet = dbmData.getTables(null, null, tableName, null);
            while (resultSet.next()) {
                if (resultSet.getString(3).equals(tableName)) {
                    // Return true if the table has been found
                    return true;
                }
            }

            connection.close();
            resultSet.close();

            // Return false if no table has been found
            return false;
        } catch (SQLException e) {
            e.printStackTrace();

            // Return false if an exception has been thrown
            return false;
        }
    }

    public static boolean createTables() {
        try {
            String driver = "com.mysql.jdbc.Driver";
            System.setProperty(driver, "");

            Connection con = DriverManager.getConnection(databaseUrl, login, password);
            Statement statement = con.createStatement();
            System.out.println(con);

            if (!checkIfTableExists(studentsTable)) {
                // Creating a table of students
                statement.executeUpdate("create table " + studentsTable + "( id VARCHAR(36) NOT NULL, "
                        + " `roll no` VARCHAR(50) NOT NULL, "
                        + " `name` VARCHAR(50), "
                        + " `date of birth` DATE, "
                        + " phone VARCHAR(50), "
                        + " email VARCHAR(50), "
                        + " gender VARCHAR(50), "
                        + " `present address` VARCHAR(150), "
                        + " `registration no` VARCHAR(50), "
                        + " `father name` VARCHAR(50), "
                        + " `mother name` VARCHAR(50), "
                        + " `guardian phone` VARCHAR(50), "
                        + " `permanent address` VARCHAR(150), "
                        + " degree VARCHAR(5), "
                        + " batch VARCHAR(50), "
                        + " department VARCHAR(25), "
                        + " PRIMARY KEY (id, `roll no`))");
            }

            // connection.close();
            con.close();
            statement.close();

            // Return true if no exception has been thrown
            return true;

        } catch (SQLException e) {
            e.printStackTrace();

            // Return false if an exception has been thrown
            return false;
        }
    }

    public static boolean addStudent() {
        try {
            Connection connection = DriverManager.getConnection(databaseUrl, login, password);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into " + studentsTable
                    + " (id, `roll no`, `name`, `date of birth`, `phone`, email, gender, `present address`, `registration no`, `father name`, `mother name`, `guardian phone`, `permanent address`, degree, batch, department, pp_blob) values "
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            String id = java.util.UUID.randomUUID().toString();
            Date dob = (Date) RegForm.datePicker.getModel().getValue();
            // java.sql.Date dob = (java.sql.Date) datePicker.getModel().getValue();
            String sgender = "";
            if (RegForm.maleradio.isSelected()) {
                sgender = "Male";
            } else if (RegForm.femaleradio.isSelected()) {
                sgender = "Female";
            } else if (RegForm.genderfradio.isSelected()) {
                sgender = "Gender-Fluid";
            } else {
                sgender = "";
            }
            String presAdd = RegForm.spresst.getText() + "' " + RegForm.spresdist.getText()
                    + "' " + RegForm.presstatecombo.getItemAt(
                            RegForm.presstatecombo.getSelectedIndex())
                    + ", "
                    + RegForm.sprespin.getText();
            String permAdd = RegForm.spermst.getText() + "' "
                    + RegForm.spermdist.getText()
                    + "' " + RegForm.permstatecombo.getItemAt(
                            RegForm.permstatecombo.getSelectedIndex())
                    + "' "
                    + RegForm.spermpin.getText();
            String course = RegForm.courseComboBox.getItemAt(RegForm.courseComboBox.getSelectedIndex());
            String degree = course.replaceAll("(?<=\s).*", "");
            InputStream in = new FileInputStream(RegForm.filename);

            preparedStatement.setString(1, id);
            preparedStatement.setString(2, RegForm.roll.getText());
            preparedStatement.setString(3, RegForm.sname.getText());
            preparedStatement.setDate(4, new java.sql.Date(dob.getTime()));
            preparedStatement.setString(5, RegForm.sphone.getText());
            preparedStatement.setString(6, RegForm.semail.getText());
            preparedStatement.setString(7, sgender);
            preparedStatement.setString(8, presAdd);
            preparedStatement.setString(9, RegForm.reg.getText());
            preparedStatement.setString(10, RegForm.fname.getText());
            preparedStatement.setString(11, RegForm.mname.getText());
            preparedStatement.setString(12, RegForm.gphone.getText());
            preparedStatement.setString(13, permAdd);
            preparedStatement.setString(14, degree);
            preparedStatement.setString(15, RegForm.batch.getText());
            preparedStatement.setString(16, RegForm.deptComboBox.getItemAt(RegForm.deptComboBox.getSelectedIndex()));
            preparedStatement.setBinaryStream(17, in);

            int result = preparedStatement.executeUpdate();
            System.out.println(result + " records affected");
            connection.close();
            preparedStatement.close();

            // updateStudents();

            // Return true if no exception has been thrown
            return true;
        } catch (SQLException e) {
            e.printStackTrace();

            // Return false if an exception has been thrown
            return false;
        } catch (Exception e) {
            e.printStackTrace();

            // Return false if an exception has been thrown
            return false;
        }
    }

    public static Object searchStudents(String searchQuery) {

        Object studentData = null;
        int howManyColumns = 0, currentColumn = 0;

        try {
            Connection connection = DriverManager.getConnection(databaseUrl, login, password);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from " + studentsTable
                    + " WHERE id LIKE ?" + " OR " +
                    "`roll no` LIKE ?" + " OR " +
                    "name LIKE ?" + " OR " +
                    "`date of birth` LIKE ?" + " OR " +
                    "phone LIKE ?" + " OR " +
                    "email LIKE ?" + " OR " +
                    "gender LIKE ?" + " OR " +
                    "`present address` LIKE ?" + " OR " +
                    "`registration no` LIKE ?" + " OR " +
                    "`father name` LIKE ?" + " OR " +
                    "`mother name` LIKE ?" + " OR " +
                    "`guardian phone` LIKE ?" + " OR " +
                    "`permanent address` LIKE ?" + " OR " +
                    "degree LIKE ?" + " OR " +
                    "batch LIKE ?" + " OR " +
                    "department LIKE ?" + " ;");

            preparedStatement.setString(1, searchQuery);
            preparedStatement.setString(2, searchQuery);
            preparedStatement.setString(3, searchQuery);
            preparedStatement.setString(4, searchQuery);
            preparedStatement.setString(5, searchQuery);
            preparedStatement.setString(6, searchQuery);
            preparedStatement.setString(7, searchQuery);
            preparedStatement.setString(8, searchQuery);
            preparedStatement.setString(9, searchQuery);
            preparedStatement.setString(10, searchQuery);
            preparedStatement.setString(11, searchQuery);
            preparedStatement.setString(12, searchQuery);
            preparedStatement.setString(13, searchQuery);
            preparedStatement.setString(14, searchQuery);
            preparedStatement.setString(15, searchQuery);
            preparedStatement.setString(16, searchQuery);
            // Reading data from table
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData rsmData = resultSet.getMetaData();
            howManyColumns = rsmData.getColumnCount();

            // System.out.println(rsmData);
            System.out.println(howManyColumns);
            System.out.println("-------------");
            while (resultSet.next()) {
                Vector columnData = new Vector();

                String id = resultSet.getString(1);
                String rollNo = resultSet.getString(2);
                String name = resultSet.getString(3);
                String dob = resultSet.getString(4);
                String ph = resultSet.getString(5);
                String eml = resultSet.getString(6);
                String gn = resultSet.getString(7);
                String pAddr = resultSet.getString(8);
                String regNo = resultSet.getString(9);
                String fName = resultSet.getString(10);
                String mName = resultSet.getString(11);
                String gPh = resultSet.getString(12);
                String prAddr = resultSet.getString(13);
                String deg = resultSet.getString(14);
                String batch = resultSet.getString(15);
                String dept = resultSet.getString(16);
                String pp_blob = resultSet.getString(17);
                // Sets Records in TextFields
                System.out.println(id + rollNo + name + dob + ph + eml + gn + pAddr + regNo + fName + mName + gPh
                        + prAddr + deg + batch + dept);
            }
            // else {
            // // JOptionPane.showMessageDialog(null, "Name not Found");
            // }
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }

        return studentData;
    }

    public static boolean updateStudents() {
        int howManyColumns = 0, currentColumn = 0;

        try {
            Connection connection = DriverManager.getConnection(databaseUrl, login, password);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from " + studentsTable);

            // Reading data from table
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData rsmData = resultSet.getMetaData();

            howManyColumns = rsmData.getColumnCount();

            // DefaultTableModel recordTable = (DefaultTableModel)
            // UpdateForm.table.getModel();
            // recordTable.setRowCount(0);

            // while (resultSet.next()) {
            // Vector columnData = new Vector();

            // for (currentColumn = 1; currentColumn <= howManyColumns; currentColumn++) {
            // columnData.add(resultSet.getString("ID"));
            // columnData.add(resultSet.getString("Name"));
            // columnData.add(resultSet.getString("Surname"));
            // columnData.add(resultSet.getString("Age"));
            // columnData.add(resultSet.getString("Gender"));
            // columnData.add(resultSet.getString("Course"));
            // columnData.add(resultSet.getString("Started"));
            // columnData.add(resultSet.getString("Graduation"));
            // }

            // recordTable.addRow(columnData);
            // }

            // updateAttendees();

            // connection.close();
            // preparedStatement.close();
            // resultSet.close();

            // Return true if no exception has been thrown
            return true;
        } catch (SQLException e) {
            e.printStackTrace();

            // Return false if exception has been thrown
            return false;
        }
    }

    /**
     * Deletes the selected student from the table
     * 
     * @return True if no exception has been thrown, false otherwise
     */
    public static boolean deleteStudent() {
        // Getting row that user selected
        // DefaultTableModel recordTable = (DefaultTableModel)
        // UpdateForm.table.getModel();
        // int selectedRow = UpdateForm.table.getSelectedRow();
        // UpdateForm.table.clearSelection();

        // try {
        // Geting the ID of the student in the selected row
        // final int ID = Integer.parseInt(recordTable.getValueAt(selectedRow,
        // 0).toString());

        // Connection connection = DriverManager.getConnection(databaseUrl, login,
        // password);
        // PreparedStatement preparedStatement = connection
        // .prepareStatement("delete from " + studentsTable + " where id = ?");

        // preparedStatement.setInt(1, ID);
        // preparedStatement.executeUpdate();

        // connection.close();
        // preparedStatement.close();

        // updateStudents();

        // Return true if no exception has been thrown
        return true;
        // } catch (SQLException e) {
        // e.printStackTrace();

        // // Return false if exception has been thrown
        // return false;
        // }
    }

}