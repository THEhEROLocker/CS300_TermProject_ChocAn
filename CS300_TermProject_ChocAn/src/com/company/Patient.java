package company;

/**
 * Created by eynis on 5/15/16.
 */
import java.io.*;
import java.util.Scanner;

public class Patient extends basicPatient {

    private basicService head = null;    //reference to future link list. review method of implementation via LLL library
    private basicService tail = null;

    protected String address;
    protected String city;
    protected String state;
    protected int zip;
    protected Scanner input=null;
    protected String lastPaid;

    public Patient(){
        tail = head = null;
        address = city = state = null;
        zip = 0;
        input = null;
    }

    public Patient(Patient toAdd){
        this.patientNumber = toAdd.patientNumber;
        this.name = toAdd.name;
        this.address = toAdd.address;
        this.city = toAdd.city;
        this.bill = toAdd.bill;
        this.lastPaid = toAdd.lastPaid;
        this.state = toAdd.state;
        this.zip = toAdd.zip;
    }
    public Patient(String name, int patientNumber, String address, String city,
                   String state, int zip, int bill, String lastPaid) {
        super(name, patientNumber,bill,"");
        this.address = address;
        this.lastPaid = lastPaid;
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

    public float getBill() {return bill;}

    public String getLastPaid() {return lastPaid;}

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

    public void setBill(float bill){this.bill = bill;}

    public void  setDate(String lastPaid) {this.lastPaid = lastPaid;}

    public int addService(basicService newService){
        head = addService(head,newService);
        return 1;
    }

    public void display(){
        super.display();
        System.out.println(address + " " + city + " " + state + " " + zip);
        displayService(head);
    }

    private basicService addService(basicService head,basicService Service){
        if(head == null){
            head = new basicService(Service);
            head.setNext(null);
            head.setPrevious(null);
            this.tail = head;
            return head;
        }
        else if(head.compare(Service) >= 0){
            basicService temp = new basicService(Service);
            temp.setNext(head);
            temp.setPrevious(head.getPrevious());
            head.setPrevious(temp);
            return temp;
        }

        head.setNext(addService(head.getNext(),Service));

        head.getNext().setPrevious(head);

        return head;
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

       displayService(head.getNext());
       head.display();
       System.out.println();
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

        return removeService(procedure,traverse.getNext());
    }

    public basicService retrieveService(){
        String procedure = null;

        System.out.println("Enter the name of the procedure to search for");
        procedure=input.nextLine();

        basicService searchedService = null;
        basicService traverse = head;

        int result = retrieveService(procedure, searchedService, traverse);

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

    public void validation(Patient checkValidation){
        validation(checkValidation.getBill(),checkValidation.getLastPaid());
    }

    private boolean validation(float toPay, String lastPaid){

        return true;
    }
    public int clearService(){
        head = null;
        return 1;
    }
}






