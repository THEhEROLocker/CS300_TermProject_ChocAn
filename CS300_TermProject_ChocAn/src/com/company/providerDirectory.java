package company;

import java.io.IOException;
import java.util.HashMap;


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

    private int readFromFile() throws IOException{
        return 0;
    }
}
