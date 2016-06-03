/**
 * Created by rujo2 on 4/24/16.
 */
package company;

public class Provider{
    private String name;
    private int providerNumber;
    private String address;
    private String city;
    private String state;
    private int zip;
    private int totalConsultation;
    private double weeklyFees;
    private basicService serviceProvider; //reference to future link list. review method of implementation via LLL library
    private patientDirectory directory;

    public Provider() {
        this.name = "";
        this.providerNumber = 0;
        this.address = "";
        this.city = "";
        this.state = "";
        this.zip = 0;
        this.totalConsultation = 0;
        this.weeklyFees = 0;
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
    }

    public void display () {
        System.out.print(name + " " + providerNumber + " ");
        System.out.println(address + " " + city + " " + state + " " + zip);
    }

    public static void main(String[] args) {
        Provider prov = new Provider("Local Herb Collective", 6978648, "1234 Some St", "Somecity", "ST", 21668, 0, 34.4);
        prov.display();
    }
}


