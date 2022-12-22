/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package phonebook;


/**
 *
 * @author user
 */
public class MinDemi implements CRUD_Interface {

    public static void main(String[] args) {
        //Initialize Data Structure
        CRUD_Interface.DB_Initialize();
        //Insert Sample Data
        System.out.println("Adding Sample Data");
        
        CRUD_Interface.addRow("Kazuha", "Kaedahara", "12/16/2002", "Inazuma", "ih8teEI@ub.edu.ph", "09612702112");
        //Initialize GUI
        MainDim app = new MainDim();
        app.setVisible(true);
        System.out.println("Hello World!");
        
        
    }
}
