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
            return 1;
        }

        head.setNext(newService);
        return 1;
  }
    public int displayService(){
        String response = null;

        System.out.println("Would you like to see the list of services received by this member? (Y/N)");
        response=input.nextLine();
        response = response.toUpperCase();

        if(response.equals("Y"))
            displayService(head);
        return 1;

    }

   private void displayService(basicService head){

       head.display();
       displayService(head.getNext());
    }

    public int removeMessage(){

    }

    private int removeMessage(){

    }

    public int clearMessages(){
        head = null;
        return 1;
    }
}






