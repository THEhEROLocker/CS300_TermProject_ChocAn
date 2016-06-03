/**
 * Created by rujo2 on 4/24/16.
 */
package company;

import java.util.*;

public class Provider{
    private String name="";
    private int providerNumber=0;
    private String address="";
    private String city="";
    private String state="";
    private int zip=0;
    private int totalConsultation=0;
    private double weeklyFees=0;
    private ArrayList<basicService> content = null; //reference to future link list. review method of implementation via LLL library
    private patientDirectory directory;

    public Provider() {}

    public Provider(Provider toClone){
        this.name = toClone.name;
        this.providerNumber = toClone.providerNumber;
        this.address = toClone.address;
        this.city = toClone.city;
        this.state = toClone.state;
        this.zip = toClone.zip;
        this.totalConsultation = toClone.totalConsultation;
        this.weeklyFees = toClone.weeklyFees;
        this.content = toClone.content;
    }

    public Provider(String name,
                    int providerNumber,
                    String address,
                    String city,
                    String state,
                    int zip,
                    int totalConsultation,
                    double weeklyFees) {
        this.name = name;
        this.providerNumber = providerNumber;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.totalConsultation = totalConsultation;
        this.weeklyFees = weeklyFees;
        this.content = new ArrayList<basicService>();
    }

    public String getName() {
        return name;
    }

    private void displayServices(){
        Iterator<basicService> temp = content.iterator();
        while(temp.hasNext()){
            basicService a = temp.next();
            a.display();
            System.out.println();
            a.displayAllPatients();
        }
    }

    public int getProviderNumber() {
        return providerNumber;
    }

    public void addService (basicService toAdd) {
        content.add(new basicService(toAdd));
        Collections.sort(content,new myCompService());
    }
    public boolean delService (int index) {
        basicService found = content.remove(index);
        return found != null;
    }

    public int addPatient(int serviceNumber, basicPatient toAdd){
        ListIterator<basicService> Itr = content.listIterator();
        while(Itr.hasNext()){
            basicService temp = Itr.next();
            if(temp.getServiceNumber() == serviceNumber){
                temp.insertPatient(toAdd);
                return 1;
            }
        }
        return 0;
    }

    public void display () {
        System.out.print(name + " " + providerNumber + " ");
        System.out.println(address + " " + city + " " + state + " " + zip);
        displayServices();
    }

    public static void main(String[] args) {
        Provider prov1 = new Provider();
        Provider prov2 = new Provider("Local Herb Collective", 6978648, "1234 Some St", "Somecity", "ST", 21668, 0, 34.4);
        prov1.display(); prov2.display();
    }
}


