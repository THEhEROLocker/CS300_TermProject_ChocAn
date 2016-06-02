/**
 * Created by rujo2 on 4/24/16.
 */
package company;

public class Provider{
    private String providerName;
    private int providerNumber;
    private String providerAddress;
    private String city;
    private String state;
    private int zipCode;
    private int totalConsultation;
    private int weeklyFees;
    private basicService serviceProvider; //reference to future link list. review method of implementation via LLL library
    private patientDirectory directory;

    public Provider() {}

    public Provider(String providerName, int providerNumber, String providerAddress, String city, String state, int zipCode, int totalConsultation, int weeklyFees, Provider next) {
        this.providerName = providerName;
        this.providerNumber = providerNumber;
        this.providerAddress = providerAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.totalConsultation = totalConsultation;
        this.weeklyFees = weeklyFees;
    }
}


