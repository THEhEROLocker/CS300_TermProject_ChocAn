package company;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;

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

        int len = Integer.parseInt(filedata[0]);
        int fileLength = filedata.length;

        for(int i = 1; i <= len; ++i){
            String[] line = filedata[i].split(":");
            basicService temp = new basicService(line[0],Integer.parseInt(line[1]),line[2]);
            providerDirectoryObj.insertService(id,temp);
            ++i;//parse the next line
            line = filedata[i].split(":");
            int  j = line.length;
            while(i < fileLength && j == 4){
                basicPatient temp2 = new basicPatient(line[1],Integer.parseInt(line[0])
                                         ,Float.parseFloat(line[2]),line[3]);
                providerDirectoryObj.insertPatient(id,temp.getServiceNumber(),temp2);
                ++i;
                if(i < fileLength){
                    line = filedata[i].split(":");
                    j = line.length;
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
