package ucf.assignments;

import com.google.gson.Gson;
import org.jsoup.Jsoup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ListMoveOperations {
    public ArrayList aList = new ArrayList();
    public ArrayList names = new ArrayList();
    public ArrayList complete = new ArrayList();
    String sendName;
    String sendInfo;

    public ListMoveOperations(ArrayList aList, ArrayList names, String sendS) {
        for (Object o : this.aList = aList) {

        }
        for (Object o : this.names = names) {

        }


        sendName=sendS;
    }

    public void sendListToHTML() {
        String pathway="lists_saved/"+sendName;
        try {
            FileWriter myWriter = new FileWriter(pathway);
            myWriter.write("<!DOCTYPE html>\n");
            myWriter.write("<html>\n");
            myWriter.write("<!--Newly Generated Website-->\n");
            myWriter.write("<head>\n");
            myWriter.write("<title>"+sendName+"</title>\n");
            myWriter.write("<meta name=\""+"Unknown"+"\" content=\"HTML\">\n");
            myWriter.write("</head>\n");
            myWriter.write("<body>\n");
            myWriter.write("<p>My site is currently empty save for the title and meta stuff!</p>\n");
            myWriter.write("\n <table>");
            int size = aList.size();
            for(int i=0; i<size; i++)
            {
                myWriter.write("<tr>");
                myWriter.write("<th>");
                myWriter.write((char[]) aList.get(i));
                myWriter.write("</th>");
                myWriter.write("</tr>");
            }
            myWriter.write("\n </table> \n");
            myWriter.write("</body>\n");
            myWriter.write("</html>\n");
            myWriter.close();
            //System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        sendNameToHTML();
    }

    private void sendNameToHTML() {
        String pathway="lists_saved/"+sendName;
        try {
            FileWriter myWriter = new FileWriter(pathway);
            myWriter.write("<!DOCTYPE html>\n");
            myWriter.write("<html>\n");
            myWriter.write("<!--Newly Generated Website-->\n");
            myWriter.write("<head>\n");
            myWriter.write("<title>"+sendName+"</title>\n");
            myWriter.write("<meta name=\""+"Unknown"+"\" content=\"HTML\">\n");
            myWriter.write("</head>\n");
            myWriter.write("<body>\n");
            myWriter.write("<p>My site is currently empty save for the title and meta stuff!</p>\n");
            myWriter.write("\n <table>");
            int size = names.size();
            for(int i=0; i<size; i++)
            {
                myWriter.write("<tr>");
                myWriter.write("<th>");
                myWriter.write((char[]) names.get(i));
                myWriter.write("</th>");
                myWriter.write("</tr>");
            }
            myWriter.write("\n </table> \n");
            myWriter.write("</body>\n");
            myWriter.write("</html>\n");
            myWriter.close();
            //System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void sendListToTSV() {
        try
        {
            FileWriter writeFile = new FileWriter("lists_saved/" +sendName);
            writeFile.write(String.valueOf(aList));
            writeFile.close();
        }
        catch(Exception w)
        {
            System.out.println("There was an error.");
        }
        sendNameToTSV();
    }
    private void sendNameToTSV() {
        String json = new Gson().toJson(names);
        try
        {
            FileWriter writeFile = new FileWriter("lists_saved/" +sendName+ "N");
            writeFile.write(String.valueOf(json));
            writeFile.close();
        }
        catch(Exception w)
        {
            System.out.println("There was an error.");
        }
    }

    public void sendListToJson() {
        String json = new Gson().toJson(aList);
        try
        {
            FileWriter writeFile = new FileWriter("lists_saved/" +sendName);
            writeFile.write(String.valueOf(json));
            writeFile.close();
        }
        catch(Exception w)
        {
            System.out.println("There was an error.");
        }
        sendNameToText();

    }
    private void sendNameToText() {
        String json = new Gson().toJson(names);
        try
        {
            FileWriter writeFile = new FileWriter("lists_saved/" +sendName+ "N");
            writeFile.write(String.valueOf(json));
            writeFile.close();
        }
        catch(Exception w)
        {
            System.out.println("There was an error.");
        }
    }


    public ArrayList recListFromHTML() {
    }

    public ArrayList recNamesFromHTML() {

    }





    public ArrayList recListFromTSV() {
        ArrayList<String[]> Data = new ArrayList<>(); //initializing a new ArrayList out of String[]'s
        try (BufferedReader TSVReader = new BufferedReader(new FileReader("lists_saved/"+ sendName))) {
            String line = null;
            while ((line = TSVReader.readLine()) != null) {
                String[] lineItems = line.split("\t"); //splitting the line and adding its items in String[]
                Data.add(lineItems); //adding the splitted line array to the ArrayList
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
        return Data;
    }

    public ArrayList recNamesFromTSV() {
        ArrayList<String[]> Data = new ArrayList<>(); //initializing a new ArrayList out of String[]'s
        try (BufferedReader TSVReader = new BufferedReader(new FileReader("lists_saved/"+ sendName))) {
            String line = null;
            while ((line = TSVReader.readLine()) != null) {
                String[] lineItems = line.split("\t"); //splitting the line and adding its items in String[]
                Data.add(lineItems); //adding the splitted line array to the ArrayList
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
        return Data;
    }

    public ArrayList recListFromJson() {
    }

    public ArrayList recNamesFromJson() {
    }
}
