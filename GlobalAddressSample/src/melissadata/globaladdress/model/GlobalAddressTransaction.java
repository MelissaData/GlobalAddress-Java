package melissadata.globaladdress.model;
import org.apache.sling.commons.json.JSONObject;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;

public class GlobalAddressTransaction {

    private final String endpoint;

    private GlobalAddressOptions options;
    private String identNumber;

    private String addressLine1, addressLine2, addressLine3, addressLine4, addressLine5, addressLine6, addressLine7, addressLine8;
    private String locality, administrativeArea, postalCode, country, lastName;

    private String format;

    public GlobalAddressTransaction() {
        endpoint            = "http://address.melissadata.net/V3/WEB/GlobalAddress/doGlobalAddress?";
        options             =  new GlobalAddressOptions();
        identNumber         =  "";
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
        lastName			= "";
        format              = "";
    }

    public String processTransaction(String request) {
        String response = "";
        URI uri;
        URL url;
        try {
            uri = new URI(request);
            url = new URL(uri.toURL().toString());

            HttpURLConnection urlConn = (HttpURLConnection)(url.openConnection());

            BufferedReader in = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

            StringReader reader;
            StringWriter writer = new StringWriter();
            StringBuilder jsonResponse = new StringBuilder();
            String inputLine = "";

            if (format.equals("JSON"))
            {
                while ((inputLine = in.readLine()) != null) {
                    jsonResponse.append(inputLine);
                }
                @SuppressWarnings("deprecation")
                JSONObject test = new JSONObject(jsonResponse.toString());
                response = test.toString(10);
            } else {

                String xmlLine = "";
                String xmlString = "";

                while((xmlLine = in.readLine()) != null) {
                    xmlString += xmlLine + "\n";
                }

                TransformerFactory tf = TransformerFactory.newInstance();
                Transformer t = tf.newTransformer();
                t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "10");
                t.setOutputProperty(OutputKeys.INDENT, "yes");

                reader = new StringReader(xmlString);
                try {
                    t.transform(new javax.xml.transform.stream.StreamSource(reader), new javax.xml.transform.stream.StreamResult(writer));
                } catch (TransformerException e) {
                    e.printStackTrace();
                }
                response = writer.toString();

            }
        } catch (Exception e){
            System.out.println("Error sending request: \n" + e);
        }
        return response;
    }

    public String generateRequestString() {
        String request = "";
        request = endpoint;
        request += "&id=" + getIdentNumber();
        request += "&opt=" + options.generateOptionString();
        try {
            if(!getAddressLine1().equals(""))
                request += "&a1=" + URLEncoder.encode(getAddressLine1(), "UTF-8");

            if(!getAddressLine2().equals(""))
                request += "&a2=" + URLEncoder.encode(getAddressLine2(), "UTF-8");

            if(!getAddressLine3().equals(""))
                request += "&a3=" + URLEncoder.encode(getAddressLine3(), "UTF-8");

            if(!getAddressLine4().equals(""))
                request += "&a4=" + URLEncoder.encode(getAddressLine4(), "UTF-8");

            if(!getAddressLine5().equals(""))
                request += "&a5=" + URLEncoder.encode(getAddressLine5(), "UTF-8");

            if(!getAddressLine6().equals(""))
                request += "&a6=" + URLEncoder.encode(getAddressLine6(), "UTF-8");

            if(!getAddressLine7().equals(""))
                request += "&a7=" + URLEncoder.encode(getAddressLine7(), "UTF-8");

            if(!getAddressLine8().equals(""))
                request += "&a8=" + URLEncoder.encode(getAddressLine8(), "UTF-8");

            if(!getLocality().equals(""))
                request += "&loc=" + URLEncoder.encode(getLocality(), "UTF-8");

            if(!getAdministrativeArea().equals(""))
                request += "&admarea=" + URLEncoder.encode(getAdministrativeArea(), "UTF-8");

            if(!getPostalCode().equals(""))
                request += "&postal=" + URLEncoder.encode(getPostalCode(), "UTF-8");

            if(!getCountry().equals(""))
                request += "&ctry=" + URLEncoder.encode(getCountry(), "UTF-8");
            
            if (!getLastName().equals(""))
            	request += "&lastname=" + URLEncoder.encode(getLastName(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported Encoding Exception: " +e);
        }
        request += "&format=" + getFormat();

        return request;
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
