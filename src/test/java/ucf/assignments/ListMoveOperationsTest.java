package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ListMoveOperationsTest {

    @Test
    void sendListToHTML() {
        ArrayList aList = new ArrayList();
        ArrayList names = new ArrayList();
        ArrayList complete = new ArrayList();
        aList.add("name");
        names.add("name");
        complete.add("incomplete");

        ArrayList bList = new ArrayList();
        bList.add(" ");
        bList.clear();

        ListMoveOperations tManage = new ListMoveOperations(aList,names,"test.html");
        tManage.sendListToHTML();
        bList = tManage.recListFromHTML();
        String expected = "[name]";
        String actual = (String)bList.get(0);
        assertEquals(expected, actual);
    }

    @Test
    void recListFromHTML() {
        ArrayList aList = new ArrayList();
        ArrayList names = new ArrayList();
        aList.add("name");
        names.add("name");

        ArrayList bList = new ArrayList();
        bList.add(" ");
        bList.clear();

        ListMoveOperations tManage = new ListMoveOperations(aList,names,"test.html");
        tManage.sendListToHTML();
        bList = tManage.recListFromHTML();
        String expected = "[name]";
        String actual = (String)bList.get(0);
        assertEquals(expected, actual);
    }
    @Test
    void sendListToTSV() {
        ArrayList aList = new ArrayList();
        ArrayList names = new ArrayList();
        aList.add("name");
        names.add("name");

        ArrayList bList = new ArrayList();
        bList.add(" ");
        bList.clear();


        ListMoveOperations tManage = new ListMoveOperations(aList,names,"test.txt");
        tManage.sendListToTSV();
        //System.out.println("My test:"+tManage.aList);
        bList = tManage.recListFromTSV();
        //System.out.println("My test:"+bList);
        String expected = "[name]";
        String actual = (String)bList.get(0);
        assertEquals(expected, actual);
    }

    @Test
    void recListFromTSV() {
        ArrayList aList = new ArrayList();
        ArrayList names = new ArrayList();
        aList.add("name");
        names.add("name");

        ArrayList bList = new ArrayList();
        bList.add(" ");
        bList.clear();

        ListMoveOperations tManage = new ListMoveOperations(aList,names,"test.txt");
        tManage.sendListToTSV();
        bList = tManage.recListFromTSV();
        String expected = "[name]";
        String actual = (String)aList.get(0);
        assertEquals(expected, actual);
    }
    @Test
    void sendListToJson() {
        ArrayList aList = new ArrayList();
        ArrayList names = new ArrayList();
        ArrayList complete = new ArrayList();
        aList.add("name");
        names.add("name");
        complete.add("incomplete");

        ArrayList bList = new ArrayList();
        bList.add(" ");
        bList.clear();

        ListMoveOperations tManage = new ListMoveOperations(aList,names,"test.json");
        tManage.sendListToJson();
        bList = tManage.recListFromJson();
        String expected = "name";
        String actual = (String)bList.get(0);
        assertEquals(expected, actual);
    }

    @Test
    void recListFromJson() {
        ArrayList aList = new ArrayList();
        ArrayList names = new ArrayList();
        aList.add("name");
        names.add("name");

        ArrayList bList = new ArrayList();
        bList.add(" ");
        bList.clear();

        ListMoveOperations tManage = new ListMoveOperations(aList,names,"test.json");
        tManage.sendListToJson();
        bList = tManage.recListFromJson();
        String expected = "name";
        String actual = (String)bList.get(0);
        assertEquals(expected, actual);
    }



}