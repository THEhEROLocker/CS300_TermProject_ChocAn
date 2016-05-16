package company;

/**
 * Created by eynis on 5/15/16.
 */
public class Patient extends basicPatient {

    protected basicService received;    //reference to future link list. review method of implementation via LLL library
    protected String address;
    protected String city;
    protected String state;
    protected int zip;

    public Patient(String name, int patientNumber, basicService received, String address, String city, String state, int zip) {
        super(name, patientNumber);
        this.received = received;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public basicService getReceived() {
        return received;
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
    public void setReceived(basicService received) {
        this.received = received;
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
}
