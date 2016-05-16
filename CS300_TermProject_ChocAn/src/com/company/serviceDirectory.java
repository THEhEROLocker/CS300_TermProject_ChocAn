package company;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by eynis on 5/15/16.
 */
public class serviceDirectory extends fileReader{

    public serviceDirectory(){

    }

    private HashMap<Integer, Service> serDir = new HashMap<Integer, Service>();

    private int readFromFile() throws IOException{
        String[] filedata = null;
        int lineCount = getNumberOfLines();
        Service toAdd;

        try{
            filedata = ReadFileData();
        }
        catch (IIOException itFreakedOut){
            System.out.println(itFreakedOut.getMessage());
        }

        for(int i =1; i < lineCount; ++i){
            String[] toParse = filedata[i].split(":");
            toAdd = new Service(toParse[0],,null);
        }


        return 0;
    }

    public void insertService(Service toAdd){
        serDir.put(toAdd.getServiceNumber(), toAdd.clone());
    }

    //This function deletes a service given the service number as a key to HashMap
    public int deleteService(int toDelete) {
        if (serDir.containsKey(toDelete)) { //Check to see if the service exists based on its key
            serDir.remove(toDelete); //remove from HashMap
            return 1; //return success
        }
        return 0; //else return failure
    }

    //This function retrieves a service given the service number as a key number to HashMap
    public Service retrieveService(int toRetrieve){
        return serDir.get(toRetrieve);
    }


}
