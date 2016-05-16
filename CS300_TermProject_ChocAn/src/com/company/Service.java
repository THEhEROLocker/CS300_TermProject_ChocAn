/**
 * Created by rujo2 on 4/24/16.
 */
package company;

public class Service extends basicService {
   protected String serviceName;
   protected int serviceNumber;
   protected int serviceCost;
    protected Service next;

    public Service(){}

    public Service(String serviceName, int serviceNumber, int serviceCost, Service next) {
        this.serviceName = serviceName;
        this.serviceNumber = serviceNumber;
        this.serviceCost = serviceCost;
        this.next = next;
    }
}
