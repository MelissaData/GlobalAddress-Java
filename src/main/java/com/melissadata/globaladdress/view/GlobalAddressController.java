package com.melissadata.globaladdress.view;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import com.melissadata.globaladdress.model.GlobalAddressTransaction;
import com.melissadata.globaladdress.model.GlobalAddressOptions;
import com.melissadata.globaladdress.Main;

public class GlobalAddressController  {

    private Main main;
    private GlobalAddressOptions option;
    private GlobalAddressTransaction Transaction;

    @FXML
    private Button buttonSend;
    @FXML
    private Button buttonClear;
    @FXML
    private TabPane tabPane;
    private final int CONFIGURATION_TAB = 0;
    private final int RESPONSE_TAB = 1;

    @FXML
    private TextField inputLicenseKeyText;
    @FXML
    private TextField inputAddressLine1Text;
    @FXML
    private TextField inputAddressLine2Text;
    @FXML
    private TextField inputAddressLine3Text;
    @FXML
    private TextField inputAddressLine4Text;
    @FXML
    private TextField inputAddressLine5Text;
    @FXML
    private TextField inputAddressLine6Text;
    @FXML
    private TextField inputAddressLine7Text;
    @FXML
    private TextField inputAddressLine8Text;
    @FXML
    private TextField inputLocalityText;
    @FXML
    private TextField inputAdministrativeAreaText;
    @FXML
    private TextField inputPostalCodeText;
    @FXML
    private TextField inputCountryText;
    @FXML
    private TextField inputLastNameText;

    @FXML
    private ComboBox<String> optionDeliveryLinesBox;
    @FXML
    private ComboBox<String> optionLineSeperatorBox;
    @FXML
    private ComboBox<String> optionOutputScriptBox;
    @FXML
    private ComboBox<String> optionOutputGeoCodingBox;
    @FXML
    private TextField optionCountryOfOriginBox;
    @FXML
    private ComboBox<String> optionUSExtrasBox;

    @FXML
    private TextArea RequestTextArea;
    @FXML
    private TextArea ResponseTextArea;

    @FXML
    private RadioButton jsonResponseFormatRadio;
    @FXML
    private RadioButton xmlResponseFormatRadio;
    /**
     * The constructor. The constructor is called before the initialize()
     * method.
     */
    public GlobalAddressController() {
        Transaction = new GlobalAddressTransaction();
        option = new GlobalAddressOptions();
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        setupOptionSelections();
        initializeFormatRadioButtons();
        initializeTextFields();
        sendButtonAction();
        clearButtonAction();
        updateRequestText();
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * //@param mainApp
     */
    public void setMainApp(Main main) {
        this.main = main;
    }

    public void sendButtonAction() {
        buttonSend.setOnAction((event) -> {
            ResponseTextArea.setText(Transaction.processTransaction(RequestTextArea.getText()));
            tabPane.getSelectionModel().select(RESPONSE_TAB);
        });
    }

    public void clearButtonAction(){
        buttonClear.setOnAction((event) -> {
            inputAddressLine1Text.clear();
            inputAddressLine2Text.clear();
            inputAddressLine3Text.clear();
            inputAddressLine4Text.clear();
            inputAddressLine5Text.clear();
            inputAddressLine6Text.clear();
            inputAddressLine7Text.clear();
            inputAddressLine8Text.clear();
            inputLocalityText.clear();
            inputAdministrativeAreaText.clear();
            inputPostalCodeText.clear();
            inputCountryText.clear();
            inputLastNameText.clear();
            returnToConfiguration();
        });
    }

    public void initializeTextFields(){
        inputLicenseKeyText.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setIdentNumber(newvalue);
            updateRequestText();
            returnToConfiguration();
        });

        inputAddressLine1Text.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setAddressLine1(newvalue);
            updateRequestText();
            returnToConfiguration();
        });

        inputAddressLine2Text.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setAddressLine2(newvalue);
            updateRequestText();
            returnToConfiguration();
        });

        inputAddressLine3Text.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setAddressLine3(newvalue);
            updateRequestText();
            returnToConfiguration();

        });

        inputAddressLine4Text.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setAddressLine4(newvalue);
            updateRequestText();
            returnToConfiguration();
        });

        inputAddressLine5Text.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setAddressLine5(newvalue);
            updateRequestText();
            returnToConfiguration();
        });

        inputAddressLine6Text.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setAddressLine6(newvalue);
            updateRequestText();
            returnToConfiguration();
        });

        inputAddressLine7Text.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setAddressLine7(newvalue);
            updateRequestText();
            returnToConfiguration();
        });

        inputAddressLine8Text.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setAddressLine8(newvalue);
            updateRequestText();
            returnToConfiguration();
        });

        inputLocalityText.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setLocality(newvalue);
            updateRequestText();
            returnToConfiguration();
        });

        inputAdministrativeAreaText.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setAdministrativeArea(newvalue);
            updateRequestText();
            returnToConfiguration();
        });

        inputPostalCodeText.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setPostalCode(newvalue);
            updateRequestText();
            returnToConfiguration();
        });

        inputCountryText.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setCountry(newvalue);
            updateRequestText();
            returnToConfiguration();
        });
        
        inputLastNameText.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setLastName(newvalue);
            updateRequestText();
            returnToConfiguration();
        });

        optionCountryOfOriginBox.textProperty().addListener((observable, oldvalue, newvalue) -> {
            option.setOptionCountryOfOrigin(newvalue);
            Transaction.setOptions(option);
            updateRequestText();
            returnToConfiguration();
        });

    }
    // Define what values each combo box can hold
    private void setupOptionSelections() {
        optionDeliveryLinesBox.setItems(FXCollections.observableArrayList("", "OFF", "ON"));
        optionLineSeperatorBox.setItems(FXCollections.observableArrayList("", "SEMICOLON", "PIPE", "CR", "LF", "CRLF", "TAB", "BR"));
        optionOutputScriptBox.setItems(FXCollections.observableArrayList("", "NOCHANGE", "LATN", "NATIVE"));
        optionOutputGeoCodingBox.setItems(FXCollections.observableArrayList("", "ON", "OFF"));
        optionUSExtrasBox.setItems(FXCollections.observableArrayList("", "ON", "OFF"));
    }

    public void setOptionDeliveryLines() {
        option.setOptionDeliveryLines(optionDeliveryLinesBox.getValue());
        Transaction.setOptions(option);
        updateRequestText();
        returnToConfiguration();
    }
    public void setOptionLineSeparator() {
        option.setOptionLineSeparator(optionLineSeperatorBox.getValue());
        Transaction.setOptions(option);
        updateRequestText();
        returnToConfiguration();
    }

    public void setOptionOutputScript() {
        option.setOptionOutputScript(optionOutputScriptBox.getValue());
        Transaction.setOptions(option);
        updateRequestText();
        returnToConfiguration();
    }

    public void setOptionOutputGeoCoding() {
        option.setOptionOutputGeo(optionOutputGeoCodingBox.getValue());
        Transaction.setOptions(option);
        updateRequestText();
        returnToConfiguration();
    }
    
    public void setOptionUSExtras() {
        option.setOptionUSExtras(optionUSExtrasBox.getValue());
        Transaction.setOptions(option);
        updateRequestText();
        returnToConfiguration();
    }

    private void initializeFormatRadioButtons(){
        jsonResponseFormatRadio.setOnAction((event) -> {
            Transaction.setFormat("JSON");
            xmlResponseFormatRadio.setSelected(false);
            updateRequestText();
        });

        xmlResponseFormatRadio.setOnAction((event) -> {
            Transaction.setFormat("XML");
            jsonResponseFormatRadio.setSelected(false);
            updateRequestText();
        });
    }

    private void returnToConfiguration(){
        if(tabPane.getSelectionModel().getSelectedIndex() != 0)	tabPane.getSelectionModel().select(CONFIGURATION_TAB);

    }




    private void updateRequestText(){
        RequestTextArea.setText(Transaction.generateRequestString());
    }
}
