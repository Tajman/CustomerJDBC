package customerApp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAOClass implements OrdersDAO {

	List<Orders> ordersList;

	   public OrdersDAOClass(){
		   ordersList = new ArrayList<Orders>(); 
		}
	
	   @Override
	     public List <Orders> getAllOrders() {
			   Connection con = ConnectionFact.getConnection();
			    try {
			        Statement stmt = con.createStatement();
			        ResultSet rs = stmt.executeQuery("SELECT * FROM Orders");
			        List<Orders> ordersList = new ArrayList<Orders>();

			        while(rs.next())
			        {
			        	Orders o = new Orders();
		                o.setOrderNumber(rs.getInt("OrderNumber")); 
		                o.setCustomerNumber(rs.getInt("CustomerNumber") );
		                o.setProductCode(rs.getInt("ProductCode") ); 
		                o.setPrice(rs.getDouble("Price") );
		                o.setQuantity(rs.getInt("Quantity") ); 
		                ordersList.add(o);
			        }
			        return ordersList;
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    }
			    return null;
			}
	   

	   @Override
	   public Orders getOrder(int id) {
		    Connection con = ConnectionFact.getConnection();
		        try {
		            Statement stmt = con.createStatement();
		            ResultSet rs = stmt.executeQuery("SELECT * FROM Orders WHERE OrderNumber=" + id);
		            if(rs.next())
		            {
		            	Orders o = new Orders();
		            	o.setOrderNumber(rs.getInt("OrderNumber")); 
		                o.setCustomerNumber(rs.getInt("CustomerNumber") );
		                o.setProductCode(rs.getInt("ProductCode") ); 
		                o.setPrice(rs.getDouble("Price") );
		                o.setQuantity(rs.getInt("Quantity") );
		            return o;
		            }
		        } catch (SQLException ex) {
	            ex.printStackTrace();
		        }
		    return null;
		} 
	   
	   @Override
	   public int delete(int code, int customer) {
		    Connection con = ConnectionFact.getConnection();
		        try {
		            Statement stmt = con.createStatement();
		            int count = stmt.executeUpdate("DELETE FROM Orders WHERE ProductCode = "+code+" AND CustomerNumber = "+customer+"");
		            return count;
		        } catch (SQLException ex) {
	            ex.printStackTrace();
		        }  
		        
		        return 0;
		} 
}
