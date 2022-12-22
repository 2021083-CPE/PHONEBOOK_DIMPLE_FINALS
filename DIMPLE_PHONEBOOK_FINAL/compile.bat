
:: NOTE->java should be installed and added to Path Environment to work
:: Maybe running this Batch file wont work and if that happens, just copy each line of command to the terminal/cmd and press enter

cd phonebook
:: MAIN COMMANDS
    :: Compiling files
javac CRUD_Interface.java
javac -d . CRUD_Interface.java
javac MainDim.java
javac -d . MainDim.java
javac MinDemi.java
javac -d . MinDemi.java
    :: Running the Main Java File
:: java MinDemi.MinDemi (Optional, uncomment to enable)
    ::Creating Manifest File
echo Main-Class: phonebook.MinDemi > manifest.mf  
    ::Making .jar files
jar -cvfm MinDemi.jar manifest.mf phonebook/ *.class
jar -cvfm ../MinDemi.jar manifest.mf phonebook/ *.class    
    :: Run the .jar file
cd ..
java -jar MinDemi.jar

