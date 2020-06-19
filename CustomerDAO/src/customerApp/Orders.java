package customerApp;

public class Orders { 
	
	private int orderNumber; 
	private int customerNumber;
	private int productCode; 
	private double price;
	private int quantity; 
	
	public Orders() {
		
	}

	public Orders(int orderNumber, int customerNumber, int productCode, double price, int quantity) {
		super();
		this.orderNumber = orderNumber;
		this.customerNumber = customerNumber;
		this.productCode = productCode;
		this.price = price;
		this.quantity = quantity;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	} 
	
	

}
