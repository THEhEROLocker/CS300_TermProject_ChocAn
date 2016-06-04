package company;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by hERO on 6/1/16.
 */
public class ChocANTerminal extends fileReader {

    private patientDirectory patientDirectoryObj = null;
    private serviceDirectory serviceDirectoryObj = null;
    private providerDirectory providerDirectoryObj = null;


    public ChocANTerminal(){
        patientDirectoryObj = new patientDirectory();
        serviceDirectoryObj = new serviceDirectory();
        providerDirectoryObj = new providerDirectory();

        Scanner input = new Scanner(System.in);
        boolean again = true;
        int option = 0;
        char response = '\0';

        System.out.println("Hello welcome to the ChocAn Data Processing Software!");

        do {
            System.out.println("Please select an option you would like to execute:");
            System.out.println("1.  Validate a member/patient");
            System.out.println("2.  Bill a member/patient");
            System.out.println("3.  Request copy of provider directory");
            System.out.println("4.  Add a service");
            System.out.println("5.  Remove a service");
            System.out.println("6.  Add a member");
            System.out.println("7.  Remove a member");
            System.out.println("8.  Update a member");
            System.out.println("9.  Add a provider");
            System.out.println("10. Remove a provider");
            System.out.println("11. Update a provider");
            System.out.println("12. Show member list");
            System.out.println("13. Generate report for provider");
            System.out.println("14. Generate report for member");

            do {
                System.out.print("Please enter a command: ");
                option = input.nextInt();
            }while(option < 1 || option > 15);

            switch(option){
                case 1:
                    System.out.print("Enter member/patient number to validate: ");
                    int patientID = input.nextInt();
                    if(1 == patientDirectoryObj.validatePatient(patientID))
                        System.out.println("Member/patient exists and is validated!");
                    else
                        System.out.println("Member/patient does not exist or is invalid!");
                    break;
                case 2:
                    break;
                case 3:
                    providerDirectoryObj.displayAll();
                    break;
                case 4:
                    serviceDirectoryObj.insertService();
                    break;
                case 5:
                    serviceDirectoryObj.deleteService();
                    break;
                case 6:
                    patientDirectoryObj.insertPatient();
                    break;
                case 7:
                    patientDirectoryObj.deletePatient();
                    break;
                case 8:
                    patientDirectoryObj.updatePatient();
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    patientDirectoryObj.displayAll();
                    break;
                case 13:
                    providerDirectoryObj.displayAll();
                    break;
                case 14:
                    break;
                default:
                    break;

            }

            System.out.print("Would you like enter another command? (Y/N) ");
            response = input.next().charAt(0);
            if(response == 'N')
                again = false;

        }while(again);



        //populateServiceDirectory();
        populateProviderDirectory(); //should work when retrieve is done for pDir

        //patientDirectoryObj.displayAll();
        providerDirectoryObj.displayAll();

    }

    /*
    --------------------------------------------------------------------------------------------------------------------
     */

    private int populateProviderDirectory(){

        final File folder = new File("../../Providers/");
        String []files = listFiles(folder);
        int count = folder.listFiles().length;

        for(int i = 0; i < count; ++i){
            Provider temp = providerDirectoryObj.retrieve(Integer.parseInt(files[i]));
            String[] filedata = null;

            if (temp != null){ //flip logic later
                try{
                    String path = "../../Providers/";
                    updateFilePath(path + files[i]);
                    filedata = ReadFileData();
                    insertProviders(filedata,Integer.parseInt(files[i]));
                }catch (IOException e){
                    System.out.println(e.getMessage());
                }
            }

        }
        return 1;
    }

    private int insertProviders(String []filedata,int id){

        Provider match = providerDirectoryObj.retrieve(id);

        int fileLength = filedata.length;
        int f =1;

        for(int i = 0; f < fileLength; ++i){
            String[] line = filedata[i].split(":");
            basicService temp = new basicService(line[0],Integer.parseInt(line[1]),line[2]);
            providerDirectoryObj.insertService(id,temp);
            ++i;//parse the next line

            if(i >= fileLength){
                break;
            }
            line = filedata[i].split(":");
            int  j = line.length;
            while(i < fileLength && j == 4){
                basicPatient temp2 = new basicPatient(line[1],Integer.parseInt(line[0])
                                         ,Float.parseFloat(line[2]),line[3]);
                providerDirectoryObj.insertPatient(id,temp.getServiceNumber(),temp2);
                if(i+1 < fileLength && filedata[i+1].split(":").length == 4){
                    ++i;
                    line = filedata[i].split(":");
                    j = line.length;
                }
                else{
                    j = 0;
                    ++f;
                }

            }
        }
        return 1;
    }

    /*
    --------------------------------------------------------------------------------------------------------------------
     */

    private int populateServiceDirectory(){

        final File folder = new File("../../People/");
        String []files = listFiles(folder);
        int count = folder.listFiles().length;

        for(int i = 0; i < count; ++i){
            Patient temp = patientDirectoryObj.retrievePatient(Integer.parseInt(files[i]));
            String[] filedata = null;

            if (temp != null){
                try{
                    String path = "../../People/";
                    updateFilePath(path + files[i]);
                    filedata = ReadFileData();
                    insertServices(filedata,Integer.parseInt(files[i]));
                }catch (IOException e){
                    System.out.println(e.getMessage());
                }
            }

        }
        return 1;
    }

    private int insertServices(String []filedata,int id){

        Patient match = patientDirectoryObj.retrievePatient(id);
        int len = filedata.length;

        for(int i = 0; i < len; ++i){
            String[] line = filedata[i].split(":");
            basicService temp = new basicService(line[0],Integer.parseInt(line[1]),line[2]);

            if(serviceDirectoryObj.retrieveService(temp.getServiceNumber()) != null){
                match.addService(temp);
            }

        }
        return 1;
    }

    public String[] listFiles(final File folder) {
        String [] array = new String[folder.listFiles().length];
        int i = 0;

        for (final File fileEntry : folder.listFiles()) {
            array[i] = fileEntry.getName();
            ++i;
        }
        return array;
    }


}
