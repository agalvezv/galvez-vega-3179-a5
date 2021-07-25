package ucf.assignments;

import java.util.ArrayList;
import java.util.Collections;

public class ListManagement {
    public String serialS;
    public String valueS;
    public String nameS;

    public String sendS;
    public String recS;
    
    public String itemLocation;



    public String remS;
    public ArrayList aList = new ArrayList();
    public ArrayList names = new ArrayList();
    public ArrayList serials = new ArrayList();
    public ArrayList values = new ArrayList();
    //public ArrayList complete = new ArrayList();


    public ListManagement(ArrayList aList) {
        for (Object o : this.aList = aList) {

        }

        for (Object o : names = aList) {

        }
        //complete.add("not applicable");
        nameS= "";
        serialS= "";
        valueS= "";

    }

    public ListManagement() {
        nameS= "";
        serialS= "";
        valueS= "";

    }

    public String allDisplay() {
        String holder = "\n";
        int size = aList.size();
        for(int i=0; i<size;i++)
        {
            holder = holder + aList.get(i)+"\n";
        }
        return holder;
    }

    public void setListInformation(ArrayList aList) {
        //not needed
    }

    public void addName(String nameS) {
        aList.add(nameS);

        names.add(nameS);

        //complete.add("incomplete");

        this.nameS=nameS;
    }
    public void addSerial(String serialS, String valueS) {
        this.valueS = valueS;
        serials.add(serialS);
        int size = aList.size();
        this.serialS= " " + serialS + " ";
        for(int i=0; i<size;i++)
        {
            if(nameS.equals(names.get(i)))
            {
                String lDate = nameS + this.serialS + this.valueS;
                aList.set(i,lDate);
            }
        }
    }

    public void addMonValue(String serialTemp, String valueS) {
        serialS = serialTemp;
        values.add(valueS);
        int size = aList.size();
        this.valueS= " " + valueS + " ";
        for(int i=0; i<size;i++)
        {
            if(nameS.equals(names.get(i)))
            {
                String description = nameS + this.serialS + this.valueS;
                //aList.set(i,aList.get(i)+description);
                aList.set(i,description);
            }
        }

    }


    public ArrayList updateList(){
        return aList;
    }

    public ArrayList updateNames() {
        return names;
    }



    public void remList(String remS) {
        int size = aList.size();
        String removal="";
        for(int i=0; i<size;i++)
        {
            if(remS.equals(names.get(i)))
            {
                removal = (String)aList.get(i);
            }
        }
        aList.remove(removal);
        names.remove(remS);
    }

    public void clearList() {
        aList.clear();
        names.clear();
        serials.clear();
        values.clear();

    }



    public void sortByName() {
        ArrayList nametemp = new ArrayList(names);
        ArrayList atemp = new ArrayList();
        Collections.sort(nametemp);

        String temp = "";

        int size = aList.size();
        for(int i=0; i<size;i++)
        {

            for(int j=0;j<size;j++)
            {
                temp = "" + aList.get(j);
                if(temp.contains((CharSequence) nametemp.get(i)))
                {
                    atemp.add(aList.get(j));
                }

            }
        }
        aList.clear();

        for(int i=0; i<size;i++)
        {
            aList.add(atemp.get(i));
        }

    }

    public void sortBySerial() {
        ArrayList serialtemp = new ArrayList(serials);
        ArrayList atemp = new ArrayList();
        Collections.sort(serialtemp);

        String temp = "";

        ArrayList nametemp = new ArrayList(names);

        int size = aList.size();
        for(int i=0; i<size;i++)
        {
            //temp = "" + aList.get(i);
            for(int j=0;j<size;j++)
            {
                temp = "" + aList.get(j);
                if(temp.contains((CharSequence) serialtemp.get(i)))
                {
                    atemp.add(aList.get(j));
                    nametemp.add(names.get(j));
                }

            }
        }
        aList.clear();
        names.clear();

        for(int i=0; i<size;i++)
        {
            aList.add(atemp.get(i));
            names.add(nametemp.get(i));
        }

    }

    public void sortByValue() {
        ArrayList valuetemp = new ArrayList(values);
        ArrayList atemp = new ArrayList();
        Collections.sort(valuetemp);

        ArrayList nametemp = new ArrayList(names);

        String temp = "";

        int size = aList.size();
        for(int i=0; i<size;i++)
        {
            //temp = "" + aList.get(i);
            for(int j=0;j<size;j++)
            {
                temp = "" + aList.get(j);
                if(temp.contains((CharSequence) valuetemp.get(i)))
                {
                    atemp.add(aList.get(j));
                    nametemp.add(names.get(j));
                }

            }
        }
        aList.clear();
        names.clear();

        for(int i=0; i<size;i++)
        {
            aList.add(atemp.get(i));
            names.add(nametemp.get(i));
        }

    }

    public void setEditLocation(String editemS) {
        itemLocation = editemS;
    }

    public void editSerial(String edSerS, String valueS) {
        this.valueS = valueS;
        int size = aList.size();
        this.serialS= " " + edSerS;
        for(int i=0; i<size;i++)
        {
            if(itemLocation.equals(names.get(i)))
            {
                String lDate = nameS + this.serialS + this.valueS;
                aList.set(i,lDate);
                serials.set(i,edSerS);
            }
        }
    }

    public void editMonValue(String edVal, String mySerial) {

        serialS = mySerial;
        //values.add(edVal);
        int size = aList.size();
        this.valueS=" " + edVal;
        for(int i=0; i<size;i++)
        {
            if(itemLocation.equals(names.get(i)))
            {
                String description = nameS + this.serialS + this.valueS;
                //aList.set(i,aList.get(i)+description);
                aList.set(i,description);
                values.set(i,edVal);
            }
        }
    }

    public void editName(String edNameS) {
        nameS = edNameS;
        //values.add(edVal);
        int size = aList.size();
        //this.nameS=" " + edVal;
        for(int i=0; i<size;i++)
        {
            if(itemLocation.equals(names.get(i)))
            {
                String description = nameS + this.serialS + this.valueS;
                //aList.set(i,aList.get(i)+description);
                aList.set(i,description);
                names.set(i,nameS);
            }
        }
    }
}
