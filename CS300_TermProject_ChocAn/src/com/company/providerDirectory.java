package company;

import java.io.IOException;
import javax.imageio.IIOException;
import java.io.IOException;
import java.text.DateFormat;
import java.util.*;
import java.text.SimpleDateFormat;

/**
 * Created by hERO on 6/2/16.
 */
public class providerDirectory {

    private int readFromFile() throws IOException{

        String[] filedata  = null;
        Provider toAdd;

        int lineCount = 0;

        try{
            filedata = ReadFileData();
            lineCount = getNumberOfLines();
        }
        catch(IIOException itFreakOut) {
            System.out.println(itFreakOut.getMessage());
        }
        for (int i = 1; i < lineCount; ++i) {
            String[] toParse = filedata[i].split(":");
            toAdd = new Provider(toParse[0],Integer.parseInt(toParse[1]),toParse[2],toParse[3],
                    toParse[4],Integer.parseInt(toParse[5]),Integer.parseInt(toParse[6]),Integer.parseInt(toParse[7]));

            insertProvider(toAdd); //calling the insert function
        }
        return 0;
    }
}
