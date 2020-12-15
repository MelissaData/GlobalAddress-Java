package melissadata.globaladdress.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GlobalAddressOptions {
    private final StringProperty optionDeliveryLines;
    private final StringProperty optionLineSeparator;
    private final StringProperty optionOutputScript;
    private final StringProperty optionOutputGeo;
    private final StringProperty optionCountryOfOrigin;
    private final StringProperty optionUSExtras;

    public GlobalAddressOptions() {
        optionDeliveryLines = new SimpleStringProperty("");
        optionLineSeparator = new SimpleStringProperty("");
        optionOutputScript = new SimpleStringProperty("");
        optionOutputGeo = new SimpleStringProperty("");
        optionCountryOfOrigin = new SimpleStringProperty("");
        optionUSExtras = new SimpleStringProperty("");
    }

    public String generateOptionString() {
        String optionString = "";

        if(!getOptionDeliveryLines().equals(""))
            optionString += "DeliveryLines:" + getOptionDeliveryLines();

        if(!getOptionLineSeparator().equals("") && !optionString.equals(""))
            optionString += ",LineSeparator:" + getOptionLineSeparator();
        else if(!getOptionLineSeparator().equals("") && optionString.equals(""))
            optionString += "LineSeparator:" + getOptionLineSeparator();

        if(!getOptionOutputScript().equals("") && !optionString.equals(""))
            optionString += ",OutputScript:" + getOptionOutputScript();
        else if(!getOptionOutputScript().equals("") && optionString.equals(""))
            optionString += "OutputScript:" + getOptionOutputScript();

        if(!getOptionCountryOfOrigin().equals("") && !optionString.equals(""))
            optionString += ",CountryOfOrigin:" + getOptionCountryOfOrigin();
        else if(!getOptionCountryOfOrigin().equals("") && optionString.equals(""))
            optionString += "CountryOfOrigin:" + getOptionCountryOfOrigin();

        if(!getOptionOutputGeo().equals("") && !optionString.equals(""))
            optionString += ",OutputGeo:" + getOptionOutputGeo();
        else if(!getOptionOutputGeo().equals("") && optionString.equals(""))
            optionString += "OutputGeo:" + getOptionOutputGeo();
        
        if(!getOptionUSExtras().equals("") && !optionString.equals(""))
            optionString += ",USExtras:" + getOptionUSExtras();
        else if(!getOptionUSExtras().equals("") && optionString.equals(""))
            optionString += "USExtras:" + getOptionUSExtras();

        return optionString;
    }

    public String getOptionDeliveryLines() {
        return optionDeliveryLines.get();
    }

    public StringProperty optionDeliveryLinesProperty() {
        return optionDeliveryLines;
    }

    public void setOptionDeliveryLines(String optionDeliveryLines) {
        this.optionDeliveryLines.set(optionDeliveryLines);
    }

    public String getOptionLineSeparator() {
        return optionLineSeparator.get();
    }

    public StringProperty optionLineSeparatorProperty() {
        return optionLineSeparator;
    }

    public void setOptionLineSeparator(String optionLineSeparator) {
        this.optionLineSeparator.set(optionLineSeparator);
    }

    public String getOptionOutputScript() {
        return optionOutputScript.get();
    }

    public StringProperty optionOutputScriptProperty() {
        return optionOutputScript;
    }

    public void setOptionOutputScript(String optionOutputScript) {
        this.optionOutputScript.set(optionOutputScript);
    }

    public String getOptionOutputGeo() {
        return optionOutputGeo.get();
    }

    public StringProperty optionOutputGeoProperty() {
        return optionOutputGeo;
    }

    public void setOptionOutputGeo(String optionOutputGeo) {
        this.optionOutputGeo.set(optionOutputGeo);
    }
    
    public String getOptionUSExtras() {
    	return optionUSExtras.get();
    }
    
    public StringProperty optionUSExtras() {
    	return optionUSExtras;
    }
    
    public void setOptionUSExtras(String optionUSExtra) {
    	this.optionUSExtras.set(optionUSExtra);
    }

    public String getOptionCountryOfOrigin() {
        return optionCountryOfOrigin.get();
    }

    public StringProperty optionCountryOfOriginProperty() {
        return optionCountryOfOrigin;
    }

    public void setOptionCountryOfOrigin(String optionCountryOfOrigin) {
        this.optionCountryOfOrigin.set(optionCountryOfOrigin);
    }
}
