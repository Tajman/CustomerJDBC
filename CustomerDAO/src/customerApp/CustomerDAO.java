package customerApp;

import java.util.List;

public interface CustomerDAO { 
	
	public Customer getCustomer(int id);
	public List<Customer> getAllCustomers(); 
	public List<Customer> getCustomerPro();

}
