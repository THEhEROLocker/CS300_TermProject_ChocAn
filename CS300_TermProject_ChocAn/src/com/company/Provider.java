/**
 * Created by rujo2 on 4/24/16.
 */
package company;

public class Provider extends Node {
    protected String providerName;
    protected int providerNumber;
    protected String providerAddress;
    protected String city;
    protected String state;
    protected int zipCode;
    protected int totalConsultation;
    protected int weeklyFees;
    protected Provider next;

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
        this.next = next;
    }
}


