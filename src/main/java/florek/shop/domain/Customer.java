package florek.shop.domain;

public class Customer {
    private int customerId;
    private String name;
    private String address;
    private int noOfOrdersMade;

    public Customer() {
	super();
    }

    public Customer(int customerId, String name) {
	this.customerId = customerId;
	this.name = name;
    }

    public void setCustomerId(int customerId) {
	this.customerId = customerId;
    }

    public int getCustomerId() {
	return customerId;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public String getAddress() {
	return address;
    }

    public void setNoOfOrdersMade(int noOfOrdersMade) {
	this.noOfOrdersMade = noOfOrdersMade;
    }

    public int getNoOfOrdersMade() {
	return noOfOrdersMade;
    }
}
