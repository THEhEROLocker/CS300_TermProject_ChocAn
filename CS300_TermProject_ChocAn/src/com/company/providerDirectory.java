package company;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;


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

    private int readFromFile() throws IOException{
        return 0;
    }
}
