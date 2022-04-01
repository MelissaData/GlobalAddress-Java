@echo off
rd .\target /s /q
mkdir target
javac -classpath "lib\gson-2.8.9.jar;" -d .\target .\src\main\java\com\melissadata\globaladdress\*.java .\src\main\java\com\melissadata\globaladdress\model\*.java .\src\main\java\com\melissadata\globaladdress\view\*.java
xcopy src\main\resources\ target\ /s /q
xcopy lib\ target\lib\ /s /q