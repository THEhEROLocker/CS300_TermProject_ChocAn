/**
 * Created by rujo2 on 4/24/16.
 */
package company;

public class Service extends basicService {

    protected int serviceCost;

    public Service(){}

    public int getServiceCost() {
        return serviceCost;
    }

    public  Service(Service toClone){
        super(toClone);
        this.serviceCost = toClone.serviceCost;
    }

    public Service(String serviceName, int serviceNumber, int serviceCost, Service next) {
        super.serviceName = serviceName;
        super.serviceNumber = serviceNumber;
        this.serviceCost = serviceCost;

    }
}
