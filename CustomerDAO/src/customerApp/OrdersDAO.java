package customerApp;

import java.util.List;

public interface OrdersDAO { 
	
	public Orders getOrder(int id);
	public List<Orders> getAllOrders(); 
	public int delete(int code, int customer);

}
