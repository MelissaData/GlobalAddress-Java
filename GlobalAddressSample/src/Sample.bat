@echo off
javac -classpath ".\melissadata\globaladdress\org.apache.sling.commons.json-2.0.20.jar;" .\melissadata\globaladdress\*.java .\melissadata\globaladdress\view\*.java ./melissadata\globaladdress\model\*.java
java -classpath ".\melissadata\globaladdress\org.apache.sling.commons.json-2.0.20.jar;"; melissadata.globaladdress.Main melissadata.globaladdress.view.GlobalAddressController melissadata.globaladdress.view.GlobalAddressTransactionController melissadata.globaladdress.view.RootLayoutController melissadata.globaladdress.model.GlobalAddressOption
del .\melissadata\globaladdress\*.class 
del .\melissadata\globaladdress\view\*.class 
del .\melissadata\globaladdress\model\*.class