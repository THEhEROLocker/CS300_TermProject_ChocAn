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

    private fileWriter writer = null;


    public ChocANTerminal(){
        patientDirectoryObj = new patientDirectory();
        serviceDirectoryObj = new serviceDirectory();
        providerDirectoryObj = new providerDirectory();

        //populateServiceDirectory();  //populates the list in service directory
        //populateProviderDirectory(); //populates the list of lists in provided directory

        Scanner input = new Scanner(System.in);
        boolean again = true;
        boolean again2 = true;
        boolean again3 = true;
        int option = 0;
        char response = '\0';

        //User interface
        System.out.println("Hello welcome to the ChocAn Data Processing Software!");

        do {
            System.out.println("Please choose a login: ");
            System.out.println("1. Provider login");
            System.out.println("2. Manager/Operator Login");

            do {
                System.out.print("Please enter a command: ");
                option = input.nextInt();
            }while(option < 1 || option > 2);

            if(option == 1){
                System.out.print("Please enter your provider ID: ");
                if(providerDirectoryObj.validateProvider(input.nextInt()) == 0){
                    option = -1;
                    System.out.println("Invalid provider ID!");
                }
            }else{
                System.out.print("Please enter your manager ID: ");
                int manID = input.nextInt();
                if(manID != 666){
                    System.out.println("Invalid manager ID!");
                    option = -1;
                }
            }

            if(option == 1) {
                do {
                    System.out.println("Please select an option you would like to execute:");
                    System.out.println("1.  Validate a member/patient");
                    System.out.println("2.  Bill a member/patient");
                    System.out.println("3.  Request copy of provider directory");

                    do {
                        System.out.print("Please enter a command: ");
                        option = input.nextInt();
                    } while (option < 1 || option > 3);

                    switch (option) {
                        case 1:
                            System.out.print("Enter member/patient number to validate: ");
                            int patientID = input.nextInt();
                            if (1 == patientDirectoryObj.validatePatient(patientID))
                                System.out.println("Member/patient exists and is validated!");
                            else
                                System.out.println("Member/patient does not exist or is invalid!");
                            break;
                        case 2:
                            billMember();
                            break;
                        case 3:
                            providerDirectoryObj.displayAll();
                            break;
                        default:
                            break;
                    }

                    System.out.print("Would you like enter another command? (Y/N) ");
                    response = input.next().charAt(0);
                    if(response == 'N')
                        again2 = false;
                }while(again2);
            }
            else {
                do {
                    System.out.println("Please select an option you would like to execute:");
                    System.out.println("1.  Add a service");
                    System.out.println("2.  Remove a service");
                    System.out.println("3.  Add a member");
                    System.out.println("4.  Remove a member");
                    System.out.println("5.  Update a member");
                    System.out.println("6.  Add a provider");
                    System.out.println("7.  Remove a provider");
                    System.out.println("8.  Update a provider");
                    System.out.println("9.  Show member list");
                    System.out.println("10. Generate report for provider");
                    System.out.println("11. Generate report for member");

                    do {
                        System.out.print("Please enter a command: ");
                        option = input.nextInt();
                    } while (option < 1 || option > 11);

                    switch (option) {
                        case 1:
                            serviceDirectoryObj.insertService();
                            break;
                        case 2:
                            serviceDirectoryObj.deleteService();
                            break;
                        case 3:
                            patientDirectoryObj.insertPatient();
                            break;
                        case 4:
                            patientDirectoryObj.deletePatient();
                            break;
                        case 5:
                            patientDirectoryObj.updatePatient();
                            break;
                        case 6:
                            providerDirectoryObj.insertProvider();
                            break;
                        case 7:
                            providerDirectoryObj.removeProvider();
                            break;
                        case 8:
                            providerDirectoryObj.updateProvider();
                            break;
                        case 9:
                            patientDirectoryObj.displayAll();
                            break;
                        case 10:
                            providerDirectoryObj.displayAll();
                            break;
                        case 11:
                            retrieveMemberInfo();
                            break;
                        default:
                            break;

                    }

                    System.out.print("Would you like enter another command? (Y/N) ");
                    response = input.next().charAt(0);
                    if (response == 'N')
                        again3 = false;
                }while(again3);
            }

            System.out.print("Would you like to continue? (Y/N) ");
            response = input.next().charAt(0);
            if (response == 'N')
                again = false;
        }while(again);

        write_all_data();


    }

    private void write_all_data(){

        //write out all the Service data
         //   String [] data = serviceDirectoryObj;
        //write out all the Patient Data

            //write out all the "People"

        //write out all the Provider data

            //write out all the "Providers"

    }

    private void billMember() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter member ID to bill: ");
        int memID = input.nextInt();
        System.out.print("Enter service ID: ");
        int serID = input.nextInt();
        System.out.print("Enter provider ID: ");
        int provID = input.nextInt();

        Patient toBill = patientDirectoryObj.retrievePatient(memID);
        Service memSer = serviceDirectoryObj.retrieveService(serID);
        Provider memProv = providerDirectoryObj.retrieve(provID);

        if (toBill == null || memSer == null || memProv == null) {
            System.out.println("member ID or service ID invalid!");
            return;
        } else {
            basicService toAdd = new basicService(memSer);
            toBill.addService(toAdd);
            float serCost = memSer.getServiceCost();
            toBill.addBill(serCost);
        }
    }

/*
    private void memberValidate() {
        Scanner input = new Scanner(System.in);
        Patient ret = null;
        do {
            System.out.println("\n\n");
            System.out.print("Please pass your card through(Enter the number): ");
            int ID = input.nextInt();
            input.nextLine();
            ret = patientDirectoryObj.retrievePatient(ID);
            if(ret == null){
                System.out.println("Member does not exist");
            }
        } while(ret == null);
        System.out.println("1. Update member Information");
        System.out.println("2. Pay bill");
        System.out.println("3. Request provider directory");
        int option;
        do {
            System.out.print("Please enter a command: ");
            option = input.nextInt();
        } while (option < 1 || option > 11);


         switch (option) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        default:
                            break;
                    }

    }
*/
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
    private void retrieveMemberInfo(){
        Scanner input = new Scanner (System.in);

        System.out.print("Please enter the member ID to display service information.");
        int idSearch = input.nextInt();

       Patient search = patientDirectoryObj.retrievePatient(idSearch);

        if(search != null)
        {
            search.displayService();
        }
    }
}
