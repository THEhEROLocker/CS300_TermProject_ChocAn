package company;

/**
 * Created by Rudd on 6/3/16.
 */

import java.io.IOException;
import java.util.Scanner;

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

    public void testDisplay(){
        System.out.print("Member directory display: ");
        testMem.displayAll();

        System.out.print("Provider directory display: ");
        testProv.displayAll();

        System.out.print("Service directory display: ");
        testServ.displayAll();
    }

}
