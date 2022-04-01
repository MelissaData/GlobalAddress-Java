@echo off
cd target
java -classpath "lib\gson-2.8.9.jar;" com.melissadata.globaladdress.Main com.melissadata.globaladdress.view.GlobalAddressController com.melissadata.globaladdress.view.RootLayoutController com.melissadata.globaladdress.model.GlobalAddressOptions com.melissadata.globaladdress.model.GlobalAddressTransaction
cd ..