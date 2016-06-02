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
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


        Collection<Patient> temp = patDir.values();
        Iterator<Patient> temp2 = temp.iterator();

        while (temp2.hasNext()) {
            temp2.next().display();

        }
    }

    private HashMap<Integer, Patient> patDir = new HashMap<Integer, Patient>();

    public int insertServices(String []filedata,int id){

        Patient match = retrievePatient(id);
        int len = filedata.length;

        for(int i = 0; i < len; ++i){
            basicService temp = new basicService(
            match.addService();
        }
        return 1;
    }

    private int readFromFile() throws IOException {
        String[] filedata = null;
        Patient toAdd;
        int lineCount = 0;

        try {
            filedata = ReadFileData();
            lineCount = getNumberOfLines();
        } catch (IIOException itFreakedOut) {
            System.out.println(itFreakedOut.getMessage());
        }

        for (int i = 1; i < lineCount; ++i) {
            String[] toParse = filedata[i].split(":");
            toAdd = new Patient(toParse[0], Integer.parseInt(toParse[1]),
                    toParse[2], toParse[3], toParse[4], Integer.parseInt(toParse[5]));

            insertPatient(toAdd); //calling the insert function
        }
        return 0;
    }

    public void insertPatient(Patient toAdd) {
        patDir.put(toAdd.getPatientNumber(), new Patient(toAdd));
    }

    public int deletePatient(int toDelete) {
        if (patDir.containsKey(toDelete)) { //Check to see if the service exists based on its key
            patDir.remove(toDelete); //remove from HashMap
            return 1; //return success
        }
        return 0; //else return failure
    }

    public Patient retrievePatient(int toRetrieve) {
        return patDir.get(toRetrieve);
    }
}
