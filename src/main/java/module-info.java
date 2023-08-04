module com.example.ibmcalculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.ibmcalculator to javafx.fxml;
    exports com.example.ibmcalculator;
}