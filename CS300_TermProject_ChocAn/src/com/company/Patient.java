package company;

/**
 * Created by eynis on 5/15/16.
 */
import java.io.*;
import java.util.Scanner;

public class Patient extends basicPatient {

    private basicService head = null;    //reference to future link list. review method of implementation via LLL library
    protected String address;
    protected String city;
    protected String state;
    protected int zip;
    protected Scanner input=null;

    public Patient(String name, int patientNumber, basicService head, String address, String city, String state, int zip) {
        super(name, patientNumber);
        this.head = head;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.input=new Scanner(System.in);
    }

    public basicService getHead() {
        return head;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZip() {
        return zip;
    }
    //reference to future link list. review method of implementation via LLL library
    public void setHead(basicService head) {
        this.head = head;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public int addService(basicService newService){
        if(head ==null) {
            head = newService;
            head.setNext(null);
            head.setPrevious(null);
            return 1;
        }

        head.setPrevious(newService);
        newService.setNext(head);
        newService.setPrevious(null);
        head = newService;
        return 1;
  }
    public int displayService(){
        String response = null;

        System.out.println("Would you like to see the list of services received by this member? (Y/N)");
        response=input.nextLine();

        if(response.equalsIgnoreCase("Y"))
            displayService(head);
        return 1;

    }

   private void displayService(basicService head){

       if(head==null)
           return;

       head.display();
       displayService(head.getNext());
    }

    public int removeService(){
        String procedure = null;

        System.out.println("Enter the name of the procedure to remove");
        procedure=input.nextLine();

        basicService traverse = head;
        return removeService(procedure,traverse);

    }

    private int removeService(String procedure, basicService traverse){
        if(traverse==null)                                                      //empty DLL
            return 1;
        if(procedure.equalsIgnoreCase(traverse.getServiceName())){              //match in DLL
            if(traverse.getNext() == null){
                if(traverse.getPrevious() == null) {                            //if only node in DLL
                    traverse = null;
                    return 1;

                }

                basicService temp = traverse.getPrevious();                     //match at end of DLL and more than one node
                traverse.setPrevious(null);
                traverse = null;
                temp.setNext(null);
                return 1;
            }

            if(traverse.getPrevious() == null){                                 //match at beginning on DLL with more than one node
                basicService temp = traverse.getNext();
                temp.setPrevious(null);
                traverse.setNext(null);
                traverse = null;
                return 1;
            }

            basicService temp = traverse.getPrevious();                        //match in middle of DLL
            temp.setNext(traverse.getNext());
            traverse.getNext().setPrevious(temp);
            traverse.setNext(null);
            traverse.setPrevious(null);
            traverse = null;
            return 1;
        }

        return 0;
    }

    public basicService retrieveService(){
        String procedure = null;

        System.out.println("Enter the name of the procedure to search for");
        procedure=input.nextLine();

        basicService searchedService = null;
        basicService traverse = head;

        int result = retrieveService(procedure, searchedService,traverse);

        if(result !=0)
        {
            return searchedService;
        }

        System.out.println("That procedure couldn't be found in the patients history");
        return null;


    }

    private int retrieveService(String procedure, basicService temp, basicService traverse){
        if(traverse == null)
            return 0;
        if(procedure.equalsIgnoreCase(traverse.getServiceName())) {
            temp = new basicService(traverse);
            return 1;
        }
        return retrieveService(procedure,temp, traverse.getNext());
        
    }

    public int clearService(){
        head = null;
        return 1;
    }
}






