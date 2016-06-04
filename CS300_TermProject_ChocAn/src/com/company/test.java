package company;

/**
 * Created by Rudd on 6/3/16.
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


}
