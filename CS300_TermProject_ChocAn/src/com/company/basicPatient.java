package company;

/**
 * Created by eynis on 5/15/16.
 */

public class basicPatient {

    protected String name;
    protected int patientNumber;
    protected float bill;
    protected String dateOfService;

    public basicPatient(){
        name = null;
        patientNumber = 0;
    }

    public basicPatient(String name, int patientNumber, float bill, String dateOfService) {
        this.name = name;
        this.patientNumber = patientNumber;
        this.bill = bill;
        this.dateOfService = dateOfService;
    }

    public void addBill(float bill) {
        this.bill += bill;
    }

    public void display(){
        System.out.print(name + " " + patientNumber + " ");
    }

    public String getName() {
        return name;
    }

    public int getPatientNumber() {
        return patientNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatientNumber(int patientNumber) {
        this.patientNumber = patientNumber;
    }
}
