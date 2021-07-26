package ucf.assignments;

import com.google.gson.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


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
            FileWriter writeFile = new FileWriter("lists_saved/" +"N"+sendName);
            writeFile.write(String.valueOf(json));
            writeFile.close();
        }
        catch(Exception w)
        {
            System.out.println("There was an error.");
        }
    }

    public void sendListToJson() {
        /*
        JSONObject mylist = new JSONObject();


        int size2 = aList.size();
        for(int i=0;i<size2;i++)
        {

        }

         */
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
            FileWriter writeFile = new FileWriter("lists_saved/" +"N"+sendName);
            writeFile.write(String.valueOf(json));
            writeFile.close();
        }
        catch(Exception w)
        {
            System.out.println("There was an error.");
        }
    }


    public ArrayList recListFromHTML() {
        Document doc = Jsoup.parse("lists_saved/"+sendName);
        Elements tables = doc.select("table");
        for (Element table : tables) {
            Elements trs = table.select("tr");
            String[][] trtd = new String[trs.size()][];
            for (int i = 0; i < trs.size(); i++) {
                Elements tds = trs.get(i).select("th");
                trtd[i] = new String[tds.size()];
                for (int j = 0; j < tds.size(); j++) {
                    trtd[i][j] = tds.get(j).text();
                    aList.add(tds.get(j).text());
                }
            }

        }
        return aList;
    }

    public ArrayList recNamesFromHTML() {
        Document doc = Jsoup.parse("lists_saved/"+sendName);
        Elements tables = doc.select("table");
        for (Element table : tables) {
            Elements trs = table.select("tr");
            String[][] trtd = new String[trs.size()][];
            for (int i = 0; i < trs.size(); i++) {
                Elements tds = trs.get(i).select("th");
                trtd[i] = new String[tds.size()];
                for (int j = 0; j < tds.size(); j++) {
                    trtd[i][j] = tds.get(j).text();
                    names.add(tds.get(j).text());
                }
            }

        }
        return names;

    }





    public ArrayList recListFromTSV() {
        /*
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

         */
        File givenFile = new File("lists_saved/"+sendName);
        String readFile="";
        aList.clear();
        try{
            Scanner readgFile = new Scanner(givenFile);
            while(readgFile.hasNext())
            {
                readFile = readgFile.nextLine();
                aList.add(readFile);
            }
            readgFile.close();

        }
        catch(Exception e)
        {
            System.out.println("There was an error.");
        }
        return aList;
    }

    public ArrayList recNamesFromTSV() {
        /*
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

         */

        File givenFile = new File("lists_saved/"+"N"+sendName);
        String readFile="";
        names.clear();
        try{
            Scanner readgFile = new Scanner(givenFile);
            while(readgFile.hasNext())
            {
                readFile = readgFile.nextLine();
                names.add(readFile);
            }
            readgFile.close();

        }
        catch(Exception e)
        {
            System.out.println("There was an error.");
        }
        return names;

    }

    public ArrayList recListFromJson() {
        /*
        try{
            aList.clear();
            File givenFile = new File("lists_saved/"+"N"+sendName);
            JsonElement fileElement = JsonParser.parseReader(new FileReader(givenFile));
            JsonObject fileObject = fileElement.getAsJsonObject();
            JsonArray jsonArrayofItems = fileObject.get("List").getAsJsonArray();
            for(JsonElement itemElement : jsonArrayofItems)
            {
                JsonObject tempObject = itemElement.getAsJsonObject();
                String tempS = tempObject.get("Item").getAsString();
                aList.add(tempS);
            }

            return aList;

        }
        catch(Exception e)
        {
            System.out.println("Errors.");
        }

         */
        return aList;
    }

    public ArrayList recNamesFromJson() {
        /*
        try {
            aList.clear();
            File givenFile = new File("lists_saved/" + "N" + sendName);
            JsonElement fileElement = JsonParser.parseReader(new FileReader(givenFile));
            JsonObject fileObject = fileElement.getAsJsonObject();
            JsonArray jsonArrayofItems = fileObject.get("List").getAsJsonArray();
            for (JsonElement itemElement : jsonArrayofItems) {
                JsonObject tempObject = itemElement.getAsJsonObject();
                String tempS = tempObject.get("Item").getAsString();
                aList.add(tempS);
            }
            return aList;
        } catch (Exception e) {
            System.out.println("Errors");
        }

         */
        return aList;
    }
}


//This area in general is built the same way as it was in assignment four. there are just added functions for the appropriate areas.
//this assignment focuses on tsv, html and json
