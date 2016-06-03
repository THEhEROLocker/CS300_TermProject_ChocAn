package company;

import java.io.IOException;
import java.util.*;
import javax.imageio.IIOException;

/**
 * Created by hERO on 6/2/16.
 */

public class providerDirectory extends fileReader{

    private HashMap<Integer, Provider> provDir = new HashMap<Integer, Provider>();

    public providerDirectory(){
        super("Provider.txt");
        try{
            readFromFile();
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void displayAll(){
        Collection<Provider> temp = provDir.values();
        List<Provider> list = new ArrayList<Provider>(temp);
        Collections.sort(list,new myCompProvider());

        while (!list.isEmpty()) {
            list.get(0).display();
            list.remove(0);
            System.out.println("\n");
        }
    }

    public Provider retrieve(int providerNumber){
        if (provDir.containsKey(providerNumber))
                return provDir.get(providerNumber);
        return null;
    }


    private void insertProvider(Provider toAdd){
        provDir.put(toAdd.getProviderNumber(), new Provider(toAdd));
    }

    public int insertService(int providerNumber, basicService toAdd){
        if (provDir.containsKey(providerNumber)) { //Check to see if the service exists based on its key
            provDir.get(providerNumber).addService(toAdd);
            return 1; //return success
        }
        return 0; //else return failure
    }

    public int insertPatient(int providerNumber, int serviceNumber, basicPatient toAdd){
        if(provDir.containsKey(providerNumber)){
            return provDir.get(providerNumber).addPatient(serviceNumber, toAdd);
        }
        return 0;
    }

    private int readFromFile() throws IOException {

        String[] filedata = null;
        Provider toAdd;

        int lineCount = 0;

        try {
            filedata = ReadFileData();
            lineCount = getNumberOfLines();
        } catch (IIOException itFreakOut) {
            System.out.println(itFreakOut.getMessage());
        }
        for (int i = 1; i < lineCount; ++i) {
            String[] toParse = filedata[i].split(":");
            toAdd = new Provider(toParse[0], Integer.parseInt(toParse[1]), toParse[2], toParse[3],
                    toParse[4], Integer.parseInt(toParse[5]), Integer.parseInt(toParse[6]), Integer.parseInt(toParse[7]));

            insertProvider(toAdd); //calling the insert function
        }

        return 0;
    }

}
