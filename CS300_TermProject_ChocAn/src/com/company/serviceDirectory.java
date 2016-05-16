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

}
