/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package phonebook;

import java.util.LinkedList;

/**
 *
 * @author user
 */
public interface CRUD_Interface {
    public static LinkedList<LinkedList<String>> db = new LinkedList<>();
    public static LinkedList<String> firstNameList = new LinkedList<>();
    public static LinkedList<String> lastNameList = new LinkedList<>();
    public static LinkedList<String> BirthdayList = new LinkedList<>();
    public static LinkedList<String> AddressList = new LinkedList<>();
    public static LinkedList<String> EmailList = new LinkedList<>();
    public static LinkedList<String> numberList = new LinkedList<>();
    //INITIALIZE DB
    public static void DB_Initialize(){
        db.add(firstNameList);
        db.add(lastNameList);
        db.add(BirthdayList);
        db.add(AddressList);
        db.add(EmailList);
        db.add(numberList);
        System.out.println("DB Initialized");
    }
    //CREATE
    public static void addRow(String fName, String lName, String BDay, String Addr,String email, String number){
        firstNameList.add(fName);
        lastNameList.add(lName);
        BirthdayList.add(BDay);
        AddressList.add(Addr);
        EmailList.add(email);
        numberList.add(number);
    }
    //CREATE with specific index
    public static void InsertRow(int row,String fName, String lName, String BDay, String Addr,String email, String number ){
        try {
            db.get(row);
            firstNameList.add(fName);
            lastNameList.add(lName);
            BirthdayList.add(BDay);
            AddressList.add(Addr);
            EmailList.add(email);
            numberList.add(number);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // READ a single row
    public static String[] searchRow(String query, LinkedList<String> field){
            
        try {
            for (int i = 0; i < field.size(); i++) {
                if (field.get(i).equals(query)) {
                    System.out.println("Result:"+firstNameList.get(i)+" "+lastNameList.get(i)+" "+BirthdayList.get(i)+" "+AddressList.get(i)+" "+EmailList.get(i)+" "+numberList.get(i) );
                    String[] result = {firstNameList.get(i),lastNameList.get(i),BirthdayList.get(i),AddressList.get(i),EmailList.get(i),numberList.get(i)};
                    return result;
                }
            }
 
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Query Not Found :(");
        }
        return null;
    }
    public static String[] SearchAllFields(String query){
        int i =0;
        for (LinkedList<String> list: CRUD_Interface.db){
            for(String substring : CRUD_Interface.db.get(i)){
                if (query.equals(substring)){
                   String[] result =  searchRow(query,db.get(i));
                   System.out.println("Query Success");
                   return result;
                }
            }
            i++;
        }
        String[] emptyArray = {};
        System.out.println("Query Failed");
        return emptyArray;
    }
    //READ all rows
    public static void getAllRows() {
        for (int i = 0; i < firstNameList.size(); i++) {
            System.out.println(firstNameList.get(i)+" "+lastNameList.get(i)+" "+BirthdayList.get(i)+" "+AddressList.get(i)+" "+EmailList.get(i)+" "+numberList.get(i) );
        }
    }
    //UPDATE in any field
    public static void updateRow(String fName,LinkedList<String> field, String input) {
        try {
            for (int i = 0; i < firstNameList.size(); i++) {
                if (firstNameList.get(i).equals(fName)) {
                    String oldValue = field.get(i);
                    field.set(i, input);
                    if(!input.equals(oldValue) ){
                        System.out.println(oldValue + " is now " + input);
                    }
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Query Not Found :(");
        }
    }
    //DELETE a row
    public static void deleteRow(String fName,String email){
        try {
            for (int i = 0; i < firstNameList.size(); i++) {
                if (fName.equals(firstNameList.get(i))&&email.equals(EmailList.get(i  ))) {
                    firstNameList.remove(i);
                    lastNameList.remove(i);
                    BirthdayList.remove(i);
                    AddressList.remove(i);
                    EmailList.remove(i);
                    numberList.remove(i);
 
                } 
            }
        } catch (Exception e) {
            System.out.println("Query Not Found :(");
        }
        
    }
    //SORT first name (used for GUI only, not really arranging all fields)
    public static String[] bubbleSort(LinkedList<String> arr){
        String[] array = arr.toArray(String[]::new);
        int size = array.length;  
        for(int i = 0; i<size-1; i++){  
            for (int j = i+1; j<array.length; j++){  
            //compares each elements of the array to all the remaining elements  
                if(array[i].compareTo(array[j])>0){  
                    //swapping array elements  
                    String temp = array[i];  
                    array[i] = array[j];  
                    array[j] = temp;  
                }  
            }  
        }  
        return array; //returns String[]
    }
}
