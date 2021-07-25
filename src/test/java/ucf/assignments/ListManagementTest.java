package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListManagementTest {
    @Test
    void addName() {
        ListManagement tManage = new ListManagement();
        tManage.addName("first_test");
        String expected = "first_test";
        String actual = (String)tManage.aList.get(0);
        assertEquals(expected, actual);



    }
    @Test
    void addNameLimit() {
        ListManagement tManage = new ListManagement();
        for(int i=0;i<100;i++)
        {
            tManage.addName("first_test");
        }

        String expected = "first_test";
        String actual = (String)tManage.aList.get(99);
        assertEquals(expected, actual);



    }

    @Test
    void addMonValue() {
        ListManagement tManage = new ListManagement();
        tManage.addName("first_test");
        tManage.addMonValue(" 111111111", "1.30");
        String expected = "first_test 111111111 1.30 ";
        String actual = (String)tManage.aList.get(0);
        assertEquals(expected, actual);
    }



    @Test
    void addSerial() {
        ListManagement tManage = new ListManagement();
        tManage.addName("first_test");
        //tManage.addMonValue("000000000", "0.00");
        tManage.addSerial("111111111", "1.25");
        String expected = "first_test 111111111 1.25";
        String actual = (String)tManage.aList.get(0);
        assertEquals(expected, actual);
    }


    @Test
    void remList() {
        ListManagement tManage = new ListManagement();
        tManage.addName("anewname");

        tManage.remList("anewname");
        tManage.addName(" ");
        String expected = " ";
        String actual = (String)tManage.aList.get(0);
        assertEquals(expected, actual);
    }

    @Test
    void clearList() {
        ListManagement tManage = new ListManagement();
        tManage.addName("poop");

        tManage.remList("poop");

        tManage.addName("poop2");

        tManage.clearList();
        tManage.addName(" ");
        String expected = " ";
        String actual = (String)tManage.aList.get(0);
        assertEquals(expected, actual);
    }

    @Test
    void sortByName() {
        ListManagement tManage = new ListManagement();
        tManage.addName("Poop");
        tManage.addName("Orange");
        tManage.addName("Green");
        tManage.sortByName();
        String expected = "Green";
        String actual = (String)tManage.aList.get(0);
        assertEquals(expected, actual);

    }
    @Test
    void sortBySerial() {
        ListManagement tManage = new ListManagement();
        tManage.addName("Poop");
        tManage.addSerial("NNNNNNNNN", "0.00");
        tManage.addName("Orange");
        tManage.addSerial("MMMMMMMMM", "0.00");
        tManage.addName("Green");
        tManage.addSerial("ZZZZZZZZZ", "0.00");
        tManage.sortBySerial();
        String expected = "Orange MMMMMMMMM 0.00";
        String actual = (String)tManage.aList.get(0);
        assertEquals(expected, actual);

    }

    @Test
    void sortByValue() {
        ListManagement tManage = new ListManagement();
        tManage.addName("Poop");
        tManage.addMonValue("NNNNNNNNN", "0.00");
        tManage.addName("Orange");
        tManage.addMonValue("NNNNNNNNN", "1.30");
        tManage.addName("Green");
        tManage.addMonValue("NNNNNNNNN", "5.44");
        tManage.sortByValue();
        String expected = "PoopNNNNNNNNN 0.00 ";
        String actual = (String)tManage.aList.get(0);
        assertEquals(expected, actual);

    }

    @Test
    void editSerial() {
        ListManagement tManage = new ListManagement();
        tManage.itemLocation="first_test";
        tManage.addName("first_test");
        //tManage.addMonValue("000000000", "0.00");
        tManage.addSerial("111111111", "1.25");
        tManage.editSerial("121111111", "1.25");
        String expected = "first_test 1211111111.25";
        String actual = (String)tManage.aList.get(0);
        assertEquals(expected, actual);
    }


    @Test
    void editMonValue() {
        ListManagement tManage = new ListManagement();
        tManage.itemLocation="first_test";
        tManage.addName("first_test");
        //tManage.addMonValue("000000000", "0.00");
        tManage.addMonValue("111111111", "1.25");
        tManage.editMonValue("1.31", "111111111");
        String expected = "first_test111111111 1.31";
        String actual = (String)tManage.aList.get(0);
        assertEquals(expected, actual);
    }

    @Test
    void editName() {
        ListManagement tManage = new ListManagement();
        tManage.itemLocation="first_test";
        tManage.addName("first_test");
        //tManage.addMonValue("000000000", "0.00");
        tManage.addMonValue("111111111", "1.25");
        tManage.editName("John");

        String expected = "John111111111 1.25 ";
        String actual = (String)tManage.aList.get(0);
        assertEquals(expected, actual);
    }

    @Test
    void editLocation() {
        ListManagement tManage = new ListManagement();
        //tManage.itemLocation="first_test";
        tManage.setEditLocation("mycheck");


        String expected = "mycheck";
        String actual = (String)tManage.itemLocation;
        assertEquals(expected, actual);
    }




}