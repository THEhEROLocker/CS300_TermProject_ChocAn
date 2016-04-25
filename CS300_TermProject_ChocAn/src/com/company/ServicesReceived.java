/**
 * Created by rujo2 on 4/24/16.
 */
package company;
public class ServicesReceived {
    protected int serviceDate;
    protected String providerName;
    protected String serviceName;

    public ServicesReceived() {}

    public ServicesReceived(int serviceDate, String providerName, String serviceName) {
        this.serviceDate = serviceDate;
        this.providerName = providerName;
        this.serviceName = serviceName;
    }
}
