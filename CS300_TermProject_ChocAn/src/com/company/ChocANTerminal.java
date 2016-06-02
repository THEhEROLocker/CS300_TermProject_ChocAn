package company;

import java.io.File;
import java.io.IOException;

/**
 * Created by hERO on 6/1/16.
 */
public class ChocANTerminal extends fileReader {
    private patientDirectory p = null;
    private serviceDirectory s = null;

    public String[] listFiles(final File folder) {
        String [] array = new String[folder.listFiles().length];
        int i = 0;

        for (final File fileEntry : folder.listFiles()) {
            array[i] = fileEntry.getName();
            ++i;
        }
        return array;
    }


    public ChocANTerminal(){
        p = new patientDirectory();
       // s = new serviceDirectory();

        final File folder = new File("../../People/");
        String []files = listFiles(folder);
        int count = folder.listFiles().length;

        for(int i = 0; i < count; ++i){
            Patient temp = p.retrievePatient(Integer.parseInt(files[i]));
            String[] filedata = null;

            if (p != null){
                try{
                    String path = "../../People/";
                    updateFilePath(path + files[i]);
                    filedata = ReadFileData();
                    p.insertServices(filedata,Integer.parseInt(files[i]));
                }catch (IOException e){
                    System.out.println(e.getMessage());
                }
            }

        }

        p.displayAll();


    }
}
