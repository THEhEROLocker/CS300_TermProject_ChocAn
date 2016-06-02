package company;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by rujo2 on 5/15/16.
 */
public class patientDirectory extends fileReader {

    public patientDirectory() {
        super("Patient.txt");
        try {
            readFromFile();
        }catch(IOException ex) {
            System.out.println(ex.getMessage());
        }


        Collection<Patient> temp = patDir.values();
        Iterator<Patient> temp2 = temp.iterator();

        System.out.println(temp.size());

        while (temp2.hasNext()) {
            temp2.next().displayService();

        }
    }

    private HashMap<Integer, Patient> patDir = new HashMap<Integer, Patient>();

    private int readFromFile() throws IOException{
        String[] filedata = null;
        Patient toAdd;
        int lineCount = 0;

        try{
            filedata = ReadFileData();
            lineCount = getNumberOfLines();
        }
        catch (IIOException itFreakedOut){
            System.out.println(itFreakedOut.getMessage());
        }

        for(int i =1; i < lineCount; ++i){
            String[] toParse = filedata[i].split(":");
            //toAdd = new Patient(toParse[1],Integer.parseInt(toParse[0]),Float.parseFloat(toParse[2]));

            //addPatient(toAdd); //calling the insert function
        }
        return 0;
    }


}
