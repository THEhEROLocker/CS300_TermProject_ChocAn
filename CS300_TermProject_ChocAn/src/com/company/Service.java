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

    public Service(String providerName, String serviceName, int serviceNumber, float serviceCost) {
        super.setServiceName(serviceName);
        super.setServiceNumber(serviceNumber);
        super.setProviderName(providerName);
        this.serviceCost = serviceCost;
    }

    public void display(){
        super.display();
        System.out.print(serviceCost);
    }
}
