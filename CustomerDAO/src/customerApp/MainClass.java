package customerApp; 

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		CustomerDAOClass customerDAO = new CustomerDAOClass(); 
		ProductDAOClass productDAO = new ProductDAOClass(); 
		OrdersDAOClass ordersDAO = new OrdersDAOClass(); 
		
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("Welcome to the CustomerApp."); 
		System.out.println("\n");
		System.out.println("Please choose an option..."); 
		System.out.println("1: Print all Customers");
		System.out.println("2: Print all available Products.");
		System.out.println("3: Print all Orders.");
		System.out.println("4: Print Customers with their orders.");
		System.out.println("5: Update the quantity of a product.");
		System.out.println("6: Delete all the orders of a product that a customer made."); 
		
		int option = sc.nextInt(); 
		
		switch(option) { 
			
			case 1:  
				for (Customer c : customerDAO.getAllCustomers()) {
			         System.out.println("Customer: [ Id: "+c.getCustomerNumber()+", Name: "+c.getCustomerName() 
			        		 + ", Address: "+c.getAddress() + ", City: "+c.getCity()+ ", Country: "+c.getCountry()+" ]");
			      }
				break; 
			
			case 2:  
				for (Product p : productDAO.getAllProducts()) {
			         System.out.println("Product: [ Code: "+p.getProductCode()+", Name: "+p.getProductName() 
			        		 + ", Price: $"+p.getPrice() + ", Quantity: "+p.getQuantity()+" ]");
			      }
				break;
			
			case 3:  
				for (Orders o : ordersDAO.getAllOrders()) {
			         System.out.println("Order: [ #: "+o.getOrderNumber()+", CustomerNumber: "+o.getCustomerNumber() 
			        		 + ", ProductCode: "+o.getProductCode() + ", Price Total: $"+o.getPrice()+ ", Quantity: "+o.getQuantity()+" ]");
			      }
				break; 
				
			case 4:  
				for (Customer c : customerDAO.getCustomerPro()) {
			         System.out.println("Customer: [ Id: "+c.getCustomerNumber()+", Name: "+c.getCustomerName() 
			        		 +" ]");
			      } 
				for (Product p : productDAO.getProductCusto()) {
			         System.out.println("Product: [ Code: "+p.getProductCode()+", Name: "+p.getProductName() 
			        		 +" ]");
			      } 
				for (Orders o : ordersDAO.getAllOrders()) {
			         System.out.println("Order: [ #: "+o.getOrderNumber()+", CustomerNumber: "+o.getCustomerNumber() 
			        		 + ", ProductCode: "+o.getProductCode() + ", Price Total: $"+o.getPrice()+ ", Quantity: "+o.getQuantity()+" ]");
			      }
				break; 
				
			case 5:  
				System.out.println("Which Product do yout want updated? Please enter product code."); 
				System.out.println("\n");
				for (Product p : productDAO.getAllProducts()) {
			         System.out.println("Product: [ Code: "+p.getProductCode()+", Name: "+p.getProductName() 
			        		 + ", Price: $"+p.getPrice() + ", Quantity: "+p.getQuantity()+" ]");
			      } 
				int code = sc.nextInt(); 
				
				System.out.println("What do you want the quantity to be updated to?"); 
				
				int amount = sc.nextInt(); 
				
				System.out.println(productDAO.update(amount, code)+" row has been updated"); 
				
				for (Product p : productDAO.getAllProducts()) {
			         System.out.println("Product: [ Code: "+p.getProductCode()+", Name: "+p.getProductName() 
			        		 + ", Quantity: "+p.getQuantity()+" ]");
			      }
				
				break; 
				
			case 6:  
				System.out.println("Which Product? Choose a product code from the orders below. Also see the available products below as well."); 
				System.out.println("\n");  
				for (Orders o : ordersDAO.getAllOrders()) {
			         System.out.println("Order: [ #: "+o.getOrderNumber()+", CustomerNumber: "+o.getCustomerNumber() 
			        		 + ", ProductCode: "+o.getProductCode() + ", Price Total: $"+o.getPrice()+ ", Quantity: "+o.getQuantity()+" ]");
			      } 
				
				System.out.println("\n"); 
				
				for (Product p : productDAO.getAllProducts()) {
			         System.out.println("Product: [ Code: "+p.getProductCode()+", Name: "+p.getProductName() 
			        		 + ", Price: $"+p.getPrice() + ", Quantity: "+p.getQuantity()+" ]");
			      }
				int codeNum = sc.nextInt(); 
				
				System.out.println("Which cusotmer? The customers are listed below. You can reference their codes from above with the right order."); 
				for (Customer c : customerDAO.getAllCustomers()) {
			         System.out.println("Customer: [ Id: "+c.getCustomerNumber()+", Name: "+c.getCustomerName() 
			        		 + ", Address: "+c.getAddress() + ", City: "+c.getCity()+ ", Country: "+c.getCountry()+" ]");
			      }  
				int customer = sc.nextInt(); 
				
				System.out.println(ordersDAO.delete(codeNum, customer)+" row(s) has been deleted"); 
				
				System.out.println("\n"); 
				
				System.out.println("Here is the updated order list."); 
				
				for (Orders o : ordersDAO.getAllOrders()) {
			         System.out.println("Order: [ #: "+o.getOrderNumber()+", CustomerNumber: "+o.getCustomerNumber() 
			        		 + ", ProductCode: "+o.getProductCode() + ", Price Total: $"+o.getPrice()+ ", Quantity: "+o.getQuantity()+" ]");
			      }
				
				
				break;
			
		}
	}
}
