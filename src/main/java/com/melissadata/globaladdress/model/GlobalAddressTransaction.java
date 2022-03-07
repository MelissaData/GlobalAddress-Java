package com.melissadata.globaladdress.model;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.util.stream.Collectors;

public class GlobalAddressTransaction {

    private final String endpoint;

    private GlobalAddressOptions options;
    private String identNumber;

    private String addressLine1, addressLine2, addressLine3, addressLine4, addressLine5, addressLine6, addressLine7, addressLine8;
    private String locality, administrativeArea, postalCode, country, lastName;

    private String format;

    public GlobalAddressTransaction() {
        endpoint            = "https://address.melissadata.net/V3/WEB/GlobalAddress/doGlobalAddress?";
        options             = new GlobalAddressOptions();
        identNumber         = "";
        addressLine1        = "";
        addressLine2        = "";
        addressLine3        = "";
        addressLine4        = "";
        addressLine5        = "";
        addressLine6        = "";
        addressLine7        = "";
        addressLine8        = "";
        locality            = "";
        administrativeArea  = "";
        postalCode          = "";
        country             = "";
        lastName            = "";
        format              = "";
    }

    public String processTransaction(String request) {
        String response = "";
        try {
            URL url = new URL(request);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            String responseBody = in.lines().collect(Collectors.joining());
            response = format.equals("JSON")
                ? getPrettyJSON(responseBody)
                : getPrettyXML(responseBody);

        } catch (Exception e){
            System.out.println("Error sending request: \n" + e);
        }
        return response;
    }

    private String getPrettyJSON(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject responseObject = gson.fromJson(json, JsonObject.class);
        return gson.toJson(responseObject);
    }

    private String getPrettyXML(String xml) {
        String prettyXML = "";
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            String indentSize = "{http://xml.apache.org/xslt}indent-amount";
            t.setOutputProperty(indentSize, "2");
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            Writer writer = new StringWriter();
            t.transform(new StreamSource(new StringReader(xml)),
                        new StreamResult(writer));
            prettyXML = writer.toString();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return prettyXML;
    }

    public String generateRequestString() {
        StringBuilder sb = new StringBuilder();
        sb.append(endpoint)
            .append("&id=" + getIdentNumber())
            .append("&opt=" + options.generateOptionString());
        try {
            sb.append(generateRequestParameter("a1", getAddressLine1()));
            sb.append(generateRequestParameter("a2", getAddressLine2()));
            sb.append(generateRequestParameter("a3", getAddressLine3()));
            sb.append(generateRequestParameter("a4", getAddressLine4()));
            sb.append(generateRequestParameter("a5", getAddressLine5()));
            sb.append(generateRequestParameter("a6", getAddressLine6()));
            sb.append(generateRequestParameter("a7", getAddressLine7()));
            sb.append(generateRequestParameter("a8", getAddressLine8()));
            sb.append(generateRequestParameter("loc", getLocality()));
            sb.append(generateRequestParameter("admarea", getAdministrativeArea()));
            sb.append(generateRequestParameter("postal", getPostalCode()));
            sb.append(generateRequestParameter("ctry", getCountry()));
            sb.append(generateRequestParameter("last", getLastName()));
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported Encoding Exception: " +e);
        }
        sb.append("&format=" + getFormat());

        return sb.toString();
    }

    private String generateRequestParameter(String key, String value) throws UnsupportedEncodingException {
        if(value.equals("")) return "";
        String encodedValue = URLEncoder.encode(value, "UTF-8");
        return "&" + key + "=" + encodedValue;
    }


    public GlobalAddressOptions getOptions() {
        return options;
    }

    public void setOptions(GlobalAddressOptions options) {
        this.options = options;
    }

    public String getIdentNumber() {
        return identNumber;
    }

    public void setIdentNumber(String identNumber) {
        this.identNumber = identNumber;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getAddressLine4() {
        return addressLine4;
    }

    public void setAddressLine4(String addressLine4) {
        this.addressLine4 = addressLine4;
    }

    public String getAddressLine5() {
        return addressLine5;
    }

    public void setAddressLine5(String addressLine5) {
        this.addressLine5 = addressLine5;
    }

    public String getAddressLine6() {
        return addressLine6;
    }

    public void setAddressLine6(String addressLine6) {
        this.addressLine6 = addressLine6;
    }

    public String getAddressLine7() {
        return addressLine7;
    }

    public void setAddressLine7(String addressLine7) {
        this.addressLine7 = addressLine7;
    }

    public String getAddressLine8() {
        return addressLine8;
    }

    public void setAddressLine8(String addressLine8) {
        this.addressLine8 = addressLine8;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getAdministrativeArea() {
        return administrativeArea;
    }

    public void setAdministrativeArea(String administrativeArea) {
        this.administrativeArea = administrativeArea;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getLastName() {
    	return lastName;
    }
    
    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
