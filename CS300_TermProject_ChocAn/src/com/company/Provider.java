/**
 * Created by rujo2 on 4/24/16.
 */
package company;

import java.util.Comparator;
import java.util.List;

public class Provider{
    private String name="";
    private int providerNumber=0;
    private String address="";
    private String city="";
    private String state="";
    private int zip=0;
    private int totalConsultation=0;
    private double weeklyFees=0;
    private List<basicService> content; //reference to future link list. review method of implementation via LLL library
    private patientDirectory directory;

    public Provider() {}

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
    }

    public void addService (basicService toAdd) {
        content.add(toAdd);
        //Comparator<int> C=new Comparator<int>();
        //content.sort(C.compare(content.get(0).getServiceNumber(), toAdd.getServiceNumber()));
    }
    public boolean delService (int index) {
        basicService found = content.remove(index);
        return found != null;
    }

    public void display () {
        System.out.print(name + " " + providerNumber + " ");
        System.out.println(address + " " + city + " " + state + " " + zip);
    }

    public static void main(String[] args) {
        Provider prov1 = new Provider();
        Provider prov2 = new Provider("Local Herb Collective", 6978648, "1234 Some St", "Somecity", "ST", 21668, 0, 34.4);
        prov1.display(); prov2.display();
    }
}


