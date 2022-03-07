@echo off
mkdir target
javac -classpath "lib\gson-2.8.9.jar;" -d .\target .\src\main\java\com\melissadata\globaladdress\*.java .\src\main\java\com\melissadata\globaladdress\model\*.java .\src\main\java\com\melissadata\globaladdress\view\*.java
xcopy src\main\resources\ target\ /s /q
cd target
java -classpath "../lib\gson-2.8.9.jar;" com.melissadata.globaladdress.Main com.melissadata.globaladdress.view.GlobalAddressController com.melissadata.globaladdress.view.RootLayoutController com.melissadata.globaladdress.model.GlobalAddressOptions com.melissadata.globaladdress.model.GlobalAddressTransaction
cd ..
rd .\target /s /q