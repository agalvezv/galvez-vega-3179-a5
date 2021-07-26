package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.NumberFormat;
/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Alex Galvez-Vega
 */


public class ListController {

    public TextField nameField;
    //public TextField descField;
   // public TextField dateField;
    public TextField serialField;
    public TextField valueField;

    public String nameS;
    //public String descS;
    //public String dateS;
    public String serialS;
    public String valueS;

    public TextField editemField;
    public String editemS;

    public TextField edNameField;
    public TextField edSerField;
    public TextField edValField;

    public String edNameS;
    public String edSerS;
    public String edVal;


    //public TextField edescField;
    //public TextField edateField;
    //public String edescS;
    //public String edateS;

    public TextField sendField;
    public TextField recField;

    public String sendS;
    public String recS;

    public TextField remField;

    public String remS;



    public String dispS ="";
    public TextArea displayField;

    public ArrayList aList = new ArrayList();
    public ArrayList names = new ArrayList();
    public ArrayList complete = new ArrayList();
    public ListManagement lManage = new ListManagement();
    public ArrayList serials = new ArrayList();
    // public ListMoveOperations mManage = new ListMoveOperations();


/*
    public TextField compField;
    public String compS;
    public TextField incompField;
    public String incompS;

 */



    public void sendValue(ActionEvent actionEvent) {
        sendS = sendField.getText();
        ListMoveOperations mManage = new ListMoveOperations(aList,names,sendS);
        mManage.sendListToHTML();
        sendField.setText("Filename: "+sendS);
    }
    public void recValue(ActionEvent actionEvent) {
        recS = recField.getText();
        ListMoveOperations mManage = new ListMoveOperations(aList,names,recS);
        aList.clear();
        aList = mManage.recListFromHTML();

        names.clear();
        names = mManage.recNamesFromHTML();

        recField.setText("Filename: "+recS);
    }
    public void sendValueTSV(ActionEvent actionEvent) {
        sendS = sendField.getText();
        ListMoveOperations mManage = new ListMoveOperations(aList,names,sendS);
        mManage.sendListToTSV();
        sendField.setText("Filename: "+sendS);
    }

    public void sendValueJson(ActionEvent actionEvent) {
        sendS = sendField.getText();
        ListMoveOperations mManage = new ListMoveOperations(aList,names,sendS);
        mManage.sendListToJson();
        sendField.setText("Filename: "+sendS);
    }

    public void recValueTSV(ActionEvent actionEvent) {
        recS = recField.getText();
        ListMoveOperations mManage = new ListMoveOperations(aList,names,recS);
        aList.clear();
        aList = mManage.recListFromTSV();

        names.clear();
        names = mManage.recNamesFromTSV();

        recField.setText("Filename: "+recS);
    }

    public void recValueJson(ActionEvent actionEvent) {
        recS = recField.getText();
        ListMoveOperations mManage = new ListMoveOperations(aList,names,recS);
        aList.clear();
        aList = mManage.recListFromJson();

        names.clear();
        names = mManage.recNamesFromJson();

        recField.setText("Filename: "+recS);
    }
/*
    public void incompListValue(ActionEvent actionEvent) {
        //ignore
    }

 */

    public void totalListValue(ActionEvent actionEvent) {
        displayField.clear();
        dispS = lManage.allDisplay();
        displayField.setText(dispS);
    }

    public void compListValue(ActionEvent actionEvent) {
        //ignore
    }

    public void newListValue(ActionEvent actionEvent) {
        aList.add(" ");
        lManage.setListInformation(aList);
    }

    public void newNameValue(ActionEvent actionEvent) {
        nameS = nameField.getText();
        lManage.addName(nameS);
        //complete = lManage.updateComplete();
        nameField.setText("Current name: "+nameS);


        int length = nameS.length();
        if(length>2&&length<256)
        {
            aList = lManage.updateList();
            names = lManage.updateNames();

            nameField.setText("Name set.");
            lManage.serialS = "AAAAAAAAA";
            lManage.valueS = "0.00";
        }
        else
        {
            nameField.setText("Bad value. Enter a description between 2-256 characters.");
        }
    }



    public void newMonValue(ActionEvent actionEvent) {
        //NumberFormat fmt = NumberFormat.getCurrencyInstance();
        //System.out.println(fmt.format(120.00));
        String mySerial = lManage.serialS;
        valueS = valueField.getText();
        NumberFormat money = NumberFormat.getCurrencyInstance();
        Double valueD = Double.parseDouble(valueS);
        //money.format(valueD);
        valueS = "" + money.format(valueD);

        lManage.addMonValue(valueS, mySerial);
        aList = lManage.updateList();
        valueField.setText("Money value set.");


    }

    public void newSerialNumber(ActionEvent actionEvent) {
        String myValue = lManage.valueS;
        serialS = serialField.getText();

        serials = lManage.getSerialList();
        int size2 = serials.size();

        for(int i=0;i<size2;i++)
        {
            if(serialS.matches((String) serials.get(i)))
            {
                System.out.println("Cannot proceed. Serial number in use.");
                break;
            }
        }


        Pattern pattern = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9]");
        Matcher match = pattern.matcher(serialS);

        if(!match.matches()){
            //response = "The employee ID must be in the format of AA-1234.";
            //printResult(response);
            serialField.setText("Bad value. Enter a date in the form YYYY-MM-DD");

        }
        else{
            //String mydesc= lManage.descS;
            lManage.addSerial(serialS, valueS);
            aList = lManage.updateList();
            serialField.setText("Serial Number Set.");
        }
    }

    public void remValue(ActionEvent actionEvent) {
        remS = remField.getText();
        lManage.remList(remS);
        aList = lManage.updateList();
        names = lManage.updateNames();
        remField.setText("Remove: "+remS);
    }

    public void clearList(ActionEvent actionEvent) {
        aList.clear();
        names.clear();
        lManage.clearList();
    }

    public void editSerialValue(ActionEvent actionEvent) {
        String myValue = lManage.valueS;
        edSerS=edSerField.getText();

        serials = lManage.getSerialList();
        int size2 = serials.size();

        for(int i=0;i<size2;i++)
        {
            if(serialS.matches((String) serials.get(i)))
            {
                System.out.println("Cannot proceed. Serial number in use.");
                break;
            }
        }

        //serialS = serialField.getText();
        Pattern pattern = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9]");
        Matcher match = pattern.matcher(edSerS);

        if(!match.matches()){
            //response = "The employee ID must be in the format of AA-1234.";
            //printResult(response);
            serialField.setText("Bad value. Enter a date in the form YYYY-MM-DD");

        }
        else{
            //String mydesc= lManage.descS;
            lManage.editSerial(edSerS, valueS);
            aList = lManage.updateList();
            serialField.setText("Serial Number Set.");
        }
    }


    public void editMonValue(ActionEvent actionEvent) {
        String mySerial = lManage.serialS;
        edVal=edValField.getText();
        //valueS = valueField.getText();
        NumberFormat money = NumberFormat.getCurrencyInstance();
        Double valueD = Double.parseDouble(edVal);
        //money.format(valueD);
        edVal = "" + money.format(valueD);

        lManage.editMonValue(edVal, mySerial);
        aList = lManage.updateList();
        valueField.setText("Money value set.");
    }
/*
    public void compValue(ActionEvent actionEvent) {
        //not used
    }

    public void incompValue(ActionEvent actionEvent) {
        //not used
    }

 */

    public void editName(ActionEvent actionEvent) {
        edNameS = edNameField.getText();
        //nameS = nameField.getText();
        lManage.addName(edNameS );
        //complete = lManage.updateComplete();
        //nameField.setText("Current name: "+edNameS );


        int length = edNameS.length();
        if(length>2&&length<256)
        {
            //aList = lManage.updateList();
            //names = lManage.updateNames();
            lManage.editName(edNameS);

            nameField.setText("Name set.");
            //lManage.serialS = "AAAAAAAAA";
            //lManage.valueS = "0.00";
        }
        else
        {
            nameField.setText("Bad value. Enter a description between 2-256 characters.");
        }
    }

    public void editListItem(ActionEvent actionEvent) {
        editemS = editemField.getText();
        /*
        public TextField editemField;
        public String editemS;
         */
        lManage.setEditLocation(editemS);
    }

    public void sortByName(ActionEvent actionEvent) {
        lManage.sortByName();
    }

    public void sortBySerial(ActionEvent actionEvent) {
        lManage.sortBySerial();
    }

    public void sortByValue(ActionEvent actionEvent) {
        lManage.sortByValue();
    }


    //This is going to carry strong similarities to the previous applications



    //This will be for the launching of the UI----correction, this is the control class for all buttons and fields

    //fields are required, not just the array lists and strings
    //list of list variable will manage all lists in play
    //this is the application center
    //main will comme into existence here

    //the template of the UI will exist through this

    //This area will require a significant amount of research

    //function to take in field
    //turn it into a string
    //use the list management class to adjust list accordingly
    //this is true for making a list
    //naming a item on the list
    //serial number on the list
    //dollar value on the list

    //Send and Write functions
    //open a MoveOperations object
    //send information via constructor
    //open and close functions accordingly

    //clear function
    //just use the clear option with the lists as needed
    //function to find and select the appropriate name of something to be altered
    //function to change the name
    //edit the serial number and dollar value will function similarly to the date and desc button
    //there will be a arrray holder of serial numbers to make sure there isn't a repeat when changing a name or entering
    //one in the first place


    //display function for list items





    //all previous pseudocode is mostly wrong, mainly in terms of location


    //this area will keep track of the gui interface
    //and will be location that holds variables, specifically list variables
    //(single lists to lists of lists) that move between list management and list mov operations.

    //one function will represent making a new object that represent a new list
    //this function will make use of the listmanagement function

    //one function will represent the button that allows to add new items to the list
    //again, this will make sue of a listmanagement function


    //one function will represent the button that allows to store single+ list
    //this function will use a loop to check how many lists will be checked
    //single and multiple read to external storage will use same function
    //List Move Operations class will be called with this list
    //appropriate text file will be created
    //appropriate information will be displayed on UI

    //one function will represent the button that allows to receive single+ list
    //single and multiple read to external storage will use same function
    //two functions, same esssential logic
    //list receiving from multiple list will use loop that grabs from each object to properly receive correct information
    //this will all go into the same list
    //display will be through UI

    //List Move Operations class will be called with this list
    //function that calls function from list move operations
    //will draw from the appropriate text file
    //asking for the name of the text file will come from this side using scanner
    //scan in a new with a string variable,
    //this will be sent to list move operations when the function is called
    //appropriate information will be displayed on UI


}
