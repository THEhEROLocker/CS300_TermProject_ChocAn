package company;

/**
 * Created by eynis on 5/15/16.
 */
public class basicService {
    protected String serviceName;
    protected int serviceNumber;

    public basicService(){

    }

    public basicService(basicService toClone)
    {
        this.serviceName = toClone.serviceName;
        this.serviceNumber = toClone.serviceNumber;
    }

    public String getServiceName() {
        return serviceName;
    }

    public int getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(int serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
