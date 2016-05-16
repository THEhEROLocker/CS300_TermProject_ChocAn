/**
 * Created by rujo2 on 4/24/16.
 */
package company;

public class Service extends basicService {

    protected float serviceCost;

    public Service(){}

    public float getServiceCost() {
        return serviceCost;
    }

    public  Service(Service toClone){
        super(toClone);
        this.serviceCost = toClone.serviceCost;
    }

    public Service(String serviceName, int serviceNumber, float serviceCost) {
        super.serviceName = serviceName;
        super.serviceNumber = serviceNumber;
        this.serviceCost = serviceCost;
    }
}
