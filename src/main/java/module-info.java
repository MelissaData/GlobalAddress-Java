module com.melissadata.globaladdress {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires com.google.gson;
    requires jdk.crypto.ec;
    requires java.xml;

    opens com.melissadata.globaladdress to javafx.fxml;
    opens com.melissadata.globaladdress.model to javafx.fxml;
    opens com.melissadata.globaladdress.view to javafx.fxml;
    exports com.melissadata.globaladdress;
}
