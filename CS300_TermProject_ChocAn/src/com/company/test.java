package company;

/**
 * Created by Rudd Johnson on 6/3/16.
 */

import java.io.IOException;
import java.util.Scanner;

//test class tests primary display, insert, retrieve, and remove functions for classes pertaining
//to members, providers, and services.
public class test {
    private patientDirectory testMem;
    private providerDirectory testProv;
    private serviceDirectory testServ;

    public test(){
        Scanner input = new Scanner(System.in);
        testMem = new patientDirectory();
        testProv =new providerDirectory();
        testServ =new serviceDirectory();
    }

    public void testDisplayAll(){
        System.out.print("Member directory display: ");         //Test class tests displayAll functions for member, provider, and service directory
        testMem.displayAll();

        System.out.print("Provider directory display: ");
        testProv.displayAll();

        System.out.print("Service directory display: ");
        testServ.displayAll();
    }

    public void testInsert(){
        System.out.print("Member directory insert ");         //Test class tests insert functions for member, provider, and service directory
        testMem.insertPatient();

        System.out.print("Provider directory insert ");
        testProv.insertProvider();

        System.out.print("Service directory insert ");
        testServ.insertService();

    }

    public void testRemove() {
        System.out.print("Member directory remove");         //Test class tests remove functions for member, provider, and service directory
        testMem.deletePatient();

        System.out.print("Provider directory remove ");
        testProv.removeProvider();

        System.out.print("Service directory remove");
        testServ.deleteService();
    }

    public void testUpdate() {
        System.out.print("Member directory update");         //Test class tests update functions for member, provider directory
        testMem.updatePatient();

        System.out.print("Provider directory update ");
        testProv.updateProvider();
    }
}
