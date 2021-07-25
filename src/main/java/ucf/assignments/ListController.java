package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;

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
    // public ListMoveOperations mManage = new ListMoveOperations();


/*
    public TextField compField;
    public String compS;
    public TextField incompField;
    public String incompS;

 */



    public void sendValue(ActionEvent actionEvent) {
    }

    public void incompListValue(ActionEvent actionEvent) {
    }

    public void totalListValue(ActionEvent actionEvent) {
    }

    public void compListValue(ActionEvent actionEvent) {
    }

    public void newListValue(ActionEvent actionEvent) {
    }

    public void newNameValue(ActionEvent actionEvent) {
    }

    public void recValue(ActionEvent actionEvent) {
    }

    public void newMonValue(ActionEvent actionEvent) {
    }

    public void newSerialNumber(ActionEvent actionEvent) {
    }

    public void remValue(ActionEvent actionEvent) {
    }

    public void clearList(ActionEvent actionEvent) {
    }

    public void editSerialValue(ActionEvent actionEvent) {
    }

    public void editMonValue(ActionEvent actionEvent) {
    }

    public void compValue(ActionEvent actionEvent) {
    }

    public void incompValue(ActionEvent actionEvent) {
    }

    public void editName(ActionEvent actionEvent) {
    }

    public void editListItem(ActionEvent actionEvent) {
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
