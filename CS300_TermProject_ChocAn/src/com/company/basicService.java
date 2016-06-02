package company;

/**
 * Created by eynis on 5/15/16.
 */
public class basicService {

    private basicService next;
    private basicService previous;
    private String serviceName;
    private int serviceNumber;
    private String providerName;

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public basicService() {
        this.next = null;
        this.previous = null;
        this.serviceName = null;

        this.serviceNumber = 0;
    }

    public basicService(basicService toClone)
    {
        this.serviceName = toClone.serviceName;
        this.serviceNumber = toClone.serviceNumber;
        this.providerName = toClone.providerName;
    }

    public int compare(basicService toCompare){
        return serviceName.compareTo(toCompare.getServiceName());
    }

    public String getServiceName() {
        return serviceName;
    }

    public int getServiceNumber() {
        return serviceNumber;
    }

    public basicService getNext() {
        return next;
    }

    public void setNext(basicService next) {
        this.next = next;
    }

    public basicService getPrevious() {return previous;}

    public void setPrevious(basicService previous) {this.previous = previous;}

    public void setServiceNumber(int serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void display(){
        System.out.print(serviceName + " " + providerName + " " + serviceNumber + " ");
    }

}
