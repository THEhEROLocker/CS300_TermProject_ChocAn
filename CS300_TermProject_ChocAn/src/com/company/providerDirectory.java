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

    public void updateProvider(){
        int ID = 0;
        Provider temp = null;
        Scanner input = new Scanner(System.in);

        do {
            displayAll();
            System.out.println();
            System.out.println("Enter the ID of the provider that you wish to update: ");
            ID = input.nextInt();
            input.nextLine();
            temp = retrieve(ID);
        }while (temp == null);

        System.out.print("Enter the name of the provider: ");
        String a = input.nextLine();
        temp.setName(a);

        System.out.println();

        String memID;
        int len = 0;

        do{
            System.out.print("Enter member ID number: ");
            memID = input.nextLine();
            len = memID.length();
        }while(provDir.containsKey(memID) && len == 6 );

        temp.setProviderNumber(Integer.parseInt(memID));

        System.out.print("Enter the address: ");
        temp.setAddress(input.nextLine());

        System.out.print("What city you from: ");
        temp.setCity(input.nextLine());

        System.out.print("What state you from: ");
        temp.setState(input.nextLine());

        System.out.print("Enter the zip code: ");
        temp.setZip(input.nextInt());
        input.nextLine();

        System.out.print("Enter the weekly prices: ");
        temp.setWeeklyFees(input.nextDouble());
    }

    public void removeProvider(){
        int ID = 0;
        Provider temp = null;
        Scanner input = new Scanner(System.in);

        do {
            displayAll();
            System.out.println();
            System.out.println("Enter the ID of the provider that you wish to remove: ");
            ID = input.nextInt();
            temp = retrieve(ID);
        }while (temp == null);

        provDir.remove(temp.getProviderNumber());
    }

    public Provider retrieve(int providerNumber){
        if (provDir.containsKey(providerNumber))
                return provDir.get(providerNumber);
        return null;
    }


    private void insertProvider(Provider toAdd){
        provDir.put(toAdd.getProviderNumber(), new Provider(toAdd));
    }

    public void insertProvider(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the name of the provider: ");
        String name  = input.nextLine();
        String memID;
        int len = 0;

        do{
            System.out.print("Enter member ID number: ");
            memID = input.nextLine();
            len = memID.length();
        }while(provDir.containsKey(memID) && len == 6 );
        System.out.print("Enter the address: ");
        String address = input.nextLine();

        System.out.print("What city you from: ");
        String city = input.nextLine();

        System.out.print("What state you from: ");
        String state = input.nextLine();

        System.out.print("Enter the zip code: ");
        int zip = input.nextInt();

        System.out.print("Enter the weekly prices: ");
        double price = input.nextDouble();

        Provider toAdd = new Provider(name,Integer.parseInt(memID),address,city,state,zip,0,price);

        insertProvider(toAdd);
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
