package company;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Collection;
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
        Iterator<Provider> temp2 = temp.iterator();

        while(temp2.hasNext()){
            temp2.next().display();
            System.out.println();
        }
    }

    private void insertProvider(Provider toAdd){

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
