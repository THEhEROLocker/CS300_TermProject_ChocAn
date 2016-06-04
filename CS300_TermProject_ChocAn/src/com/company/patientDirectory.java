package company;

import javax.imageio.IIOException;
import java.io.IOException;
import java.text.DateFormat;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.concurrent.ScheduledExecutorService;

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

    }

    public void displayAll() {
        Collection<Patient> temp = patDir.values();
        List<Patient> list = new ArrayList<Patient>(temp);
        Collections.sort(list,new myCompPatient());

        while (!list.isEmpty()) {
            list.get(0).display();
            list.remove(0);
            System.out.println("\n");
        }
    }

    public int validatePatient(int toValidate){
        if(patDir.containsKey(toValidate))
            return 1;
        return 0;
    }

    private HashMap<Integer, Patient> patDir = new HashMap<Integer, Patient>();

    public int insertServices(String[] filedata, int id) {

        Patient match = retrievePatient(id);
        int len = filedata.length;

        for (int i = 0; i < len; ++i) {
            String[] line = filedata[i].split(":");
            basicService temp = new basicService(line[0], Integer.parseInt(line[1]), line[2]);
            match.addService(temp);
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
                    toParse[2], toParse[3], toParse[4], Integer.parseInt(toParse[5]), Integer.parseInt(toParse[6]),
                    toParse[7]);

            insertPatient(toAdd); //calling the insert function
        }
        return 0;
    }

    public void insertPatient(){
        Scanner input = new Scanner(System.in);
        int memID;

        System.out.print("Enter member name: ");
        String memName = input.next();

        do{
            System.out.print("Enter member ID number: ");
            memID = input.nextInt();
        }while(patDir.containsKey(memID));

        System.out.print("Enter member address: ");
        String memAd = input.next();

        System.out.print("Enter member city: ");
        String memCt = input.next();

        System.out.print("Enter member state: ");
        String memSt = input.next();

        System.out.print("Enter member zip: ");
        int memZp = input.nextInt();

        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date date = new Date();
        insertPatient(new Patient(memName, memID, memAd, memCt, memSt, memZp, 0, df.format(date)));
    }

    public void insertPatient(Patient toAdd) {
        patDir.put(toAdd.getPatientNumber(), new Patient(toAdd));
    }

    public void deletePatient(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter member/patient ID to delete: ");
        int memID = input.nextInt();
        if(deletePatient(memID) == 1)
            System.out.println("Member/patient successfully deleted!");
        else
            System.out.println("Member/patient not deleted/not found!");
    }

    public int deletePatient(int toDelete) {
        if (patDir.containsKey(toDelete)) { //Check to see if the service exists based on its key
            patDir.remove(toDelete); //remove from HashMap
            return 1; //return success
        }
        return 0; //else return failure
    }

    public Patient retrievePatient(int toRetrieve) {

        if (patDir.containsKey(toRetrieve))
        return patDir.get(toRetrieve);

        return null;
    }

    public void updatePatient(){
        Scanner input = new Scanner(System.in);
        int memID;
        do {
            System.out.print("Enter member/patient ID to update: ");
            memID = input.nextInt();
        }while(patDir.containsKey(memID));

        updatePatient(memID);

    }

    public void updatePatient(int toUpdate) {

        int edit = toUpdate;

        Patient toEdit = retrievePatient(edit);

        String answer = null;

        Scanner s = new Scanner(System.in);
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("Please select which field of the patients information you would like to update.");
            System.out.println( "1 - Edit patients address" + "2 - Edit patients billing");
            int option = in.nextInt();

            if (option == 1)
            {
                String updatedAddress = null;
                String updateCity = null;
                String updateSate = null;
                int updateZip = 0;

                System.out.println("Please enter the Patients updated Address.");
                updatedAddress = in.nextLine();
                toEdit.setAddress(updatedAddress);

                System.out.println("Please enter the Patients updated city.");
                updateCity = in.nextLine();
                toEdit.setCity(updateCity);

                System.out.println("Please enter the patients updated State.");
                updateSate = in.nextLine();
                toEdit.setState(updateSate);

                System.out.println("Please enter the patients updated Zip code.");
                updateZip = in.nextInt();
                toEdit.setZip(updateZip);
                return;
            }
            else if (option == 2) {
                float updateBill = 0;
                String updateDate = null;

                System.out.print("Please enter the new bill amount for the Patient.");
                updateBill = in.nextFloat();
                toEdit.setBill(updateBill);

                DateFormat dateFormat = new SimpleDateFormat("MM/d/yyyy");
                Date date = new Date();
                updateDate = dateFormat.format(date);

                toEdit.setDate(updateDate);
                return;
            }

            System.out.println("That is an invalid response, press 'Y' if you want to try again.");
            answer = in.nextLine();
        }while(answer.equalsIgnoreCase("Y"));
    }
}

