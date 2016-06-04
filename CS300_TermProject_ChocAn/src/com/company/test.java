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
    private Patient testPat;
    private Provider testProvider;
    private ChocANTerminal testChocAn;
    public test(){
        Scanner input = new Scanner(System.in);
        testMem = new patientDirectory();
        testProv =new providerDirectory();
        testServ =new serviceDirectory();
        testPat = new Patient();
        testProvider = new Provider();
        testChocAn= new ChocANTerminal();
    }

    public void testDisplayAll(){
        System.out.print("Test Member directory display: \n");         //Test class tests displayAll functions for member, provider, and service directory
        testMem.displayAll();

        System.out.print("Test Provider directory display: \n");
        testProv.displayAll();

        System.out.print("Test Service directory display: \n");
        testServ.displayAll();
    }

    public void testInsert(){
        System.out.print("Test Member directory insert\n");         //Test class tests insert functions for member, provider, and service directory
        testMem.insertPatient();

        System.out.print("Test Provider directory insert\n");
        testProv.insertProvider();

        System.out.print("Test Service directory insert\n");
        testServ.insertService();

    }

    public void testRemove() {
        System.out.print("Test Member directory remove\n");         //Test class tests remove functions for member, provider, and service directory
        testMem.deletePatient();

        System.out.print("Test Provider directory remove\n");
        testProv.removeProvider();

        System.out.print("Test Service directory remove\n");
        testServ.deleteService();
    }

    public void testUpdate() {
        System.out.print("Test Member directory update\n");         //Test class tests update functions for member, provider directory
        testMem.updatePatient();

        System.out.print("Test Provider directory update\n");
        testProv.updateProvider();
    }

    public void displayIndividual(){
        System.out.print("Test Member display \n");         //Test class tests display functions for member and provider
        testPat.display();
        testPat.displayService();

        System.out.print("Test Provider display\n");
        testProvider.display();
    }

    public void testBill(){                                 //testing member billing
        testChocAn.billMember();
    }       //test member billing
}
