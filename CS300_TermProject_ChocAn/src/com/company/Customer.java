/*
Rudd Johnson
ChocAn members and services.
*/

package company;

public class Customer extends Node {
	protected String name;
	protected int memNumber;
	protected String memAddress;
	protected String city;
	protected String state;
	protected int memZip;
    protected Customer next;
    protected ServicesReceived head;

    public Customer() {}

    public Customer(String name, int memNumber, String memAddress, String city, String state, int memZip, Customer next, ServicesReceived head) {
        this.name = name;
        this.memNumber = memNumber;
        this.memAddress = memAddress;
        this.city = city;
        this.state = state;
        this.memZip = memZip;
        this.next = next;
        this.head = head;
    }
}