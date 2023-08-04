package com.example.ibmcalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javax.xml.namespace.QName;
import java.io.IOException;
import java.net.URL;
import java.security.spec.ECField;
import java.sql.*;
import java.util.ResourceBundle;

public class Controlller implements Initializable , AutoCloseable{

    @FXML
    private TextField BMI;

    @FXML
    private TextField Height;

    @FXML
    private TextField Weight;

    @FXML
    private Button button;

    @FXML
    private TextField category;
    @FXML
    private Label empty;

    @FXML
    private Label invalid;

    @FXML
    public void calculateIBM(ActionEvent event) throws Exception {

      realcalucaltion();
      //  Button button = (Button) event.getSource();
       // AnchorPane parentPane = (AnchorPane) button.getParent();
       // parentPane.setStyle("-fx-background-color: black;");
        String sql = " insert into ibm values (? , ? , ? , ? , ?)";
        pst = con.prepareStatement(sql);

        pst.setString(1 ,name.getText());
        pst.setString(2 ,Height.getText());
        pst.setString(3 ,Weight.getText());
        pst.setString(4 ,string);
        pst.setString(5,phrase);
        pst.executeUpdate(  );



    }
    String string;
    String phrase;

    public void realcalucaltion() throws Exception {
        try{
        if (Height.getText().isEmpty() && Weight.getText().isEmpty()){
            empty.setText(" Error; please fill the blanks");
        }
        String height= Height.getText();
        Float heigt1= Float.parseFloat(height);
        String weight= Weight.getText();
        Float weight1= Float.parseFloat(weight);
        Float RESULT =weight1/(heigt1*heigt1);
         string = String.valueOf(RESULT);
        if ( RESULT> 10 && RESULT < 18.5 ){
            phrase="UNDERWEIGHT";
        } else if ( RESULT > 18.5 && RESULT<24.9) {
            phrase="Normal Wright";
        }else if ( RESULT > 25 && RESULT<29.9) {
            phrase="OverWright";
        }else if ( RESULT > 30 && RESULT<34.9) {
            phrase="Obesity";
        }else if ( RESULT > 35 && RESULT<39.9) {
            phrase="Extreme Obesity";
        }
        else {
            phrase="undefined";
        }
        category.setText(phrase);
        BMI.setText(string);
        }
        catch (Exception e){
            invalid.setText("invalid data");
        }
    }

    @FXML
    void checkButton(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("checkScene.fxml" , "CHECK");
    }
    @FXML
    private TextField name;

    @FXML
    void GETNAME(ActionEvent event) {

    }
    Connection con ;
    PreparedStatement pst;
    public void connect(){
        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost/students", "root", "houssein123");
            System.out.println("Database connection established.");
        } catch ( SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        connect();
        /*
        try {
            //history();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        */

    }

    @Override
    public void close() throws Exception {

    }
  /*  public void history() throws SQLException {

        String sql = " select * from ibm";
        pst = con.prepareStatement(sql);
       ResultSet rs = pst.executeQuery();
       while ( rs.next()){
        String name = rs.getString("name");
           String height = rs.getString("height");
           String weight = rs.getString("weight");
           String bmi = rs.getString("bmi_value");
           System.out.println(" name is " + name + " " + " height is " + height + " " + "weight is " + weight + " bmi is " + bmi);


       }

    }*/


}





