package company;

/**
 * Created by eynis on 5/15/16.
 */
public class basicPatient {

    protected String name;
    protected int patientNumber;

    public basicPatient(){
        name = null;
        patientNumber = 0;
    }

    public basicPatient(String name, int patientNumber) {
        this.name = name;
        this.patientNumber = patientNumber;
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
