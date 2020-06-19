package customerApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOClass implements CustomerDAO{

	//list is working as a database
	   List<Customer> customerList;

	   public CustomerDAOClass(){
		  customerList = new ArrayList<Customer>(); 
		}
	
	   @Override
	     public List <Customer> getAllCustomers() {
			   Connection con = ConnectionFact.getConnection();
			    try {
			        Statement stmt = con.createStatement();
			        ResultSet rs = stmt.executeQuery("SELECT * FROM Customer");
			        List<Customer> customerList = new ArrayList<Customer>();

			        while(rs.next())
			        {
		            	Customer cn = new Customer();
		                cn.setCustomerNumber(rs.getInt("CustomerNumber")); 
		                cn.setCustomerName(rs.getString("CustomerName") );
		                cn.setAddress(rs.getString("Address") ); 
		                cn.setCity(rs.getString("City") ); 
		                cn.setCountry(rs.getString("Country") );
			            customerList.add(cn);
			        }
			        return customerList;
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    }
			    return null;
			}
	   

	   @Override
	   public Customer getCustomer(int id) {
		    Connection con = ConnectionFact.getConnection();
		        try {
		            Statement stmt = con.createStatement();
		            ResultSet rs = stmt.executeQuery("SELECT * FROM Customer WHERE CustomerNumber=" + id);
		            if(rs.next())
		            {
		            	Customer cn = new Customer();
		            	cn.setCustomerNumber(rs.getInt("CustomerNumber")); 
		                cn.setCustomerName(rs.getString("CustomerName") );
		                cn.setAddress(rs.getString("Address") ); 
		                cn.setCity(rs.getString("City") ); 
		                cn.setCountry(rs.getString("Country") );
		            return cn;
		            }
		        } catch (SQLException ex) {
	            ex.printStackTrace();
		        }
		    return null;
		}  
	   
	   @Override
	     public List <Customer> getCustomerPro() {
			   Connection con = ConnectionFact.getConnection();
			    try {
			        Statement stmt = con.createStatement();
			        ResultSet rs = stmt.executeQuery("Select * from Customer, Orders where Customer.CustomerNumber = Orders.CustomerNumber");
			        List<Customer> customerList = new ArrayList<Customer>();

			        while(rs.next())
			        {
		            	Customer cn = new Customer();
		                cn.setCustomerNumber(rs.getInt("CustomerNumber")); 
		                cn.setCustomerName(rs.getString("CustomerName") );
			            customerList.add(cn);
			        }
			        return customerList;
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    }
			    return null;
			}
}
